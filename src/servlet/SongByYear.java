package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.ArtistsDao;
import dal.SongsDao;
import model.Artists;
import model.Songs;

@WebServlet("/songbyyear")
public class SongByYear extends HttpServlet {
	protected SongsDao songsDao;
	protected ArtistsDao artistDao;

	@Override
	public void init() throws ServletException {
		songsDao = SongsDao.getInstance();
		artistDao = ArtistsDao.getInstance();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Map for storing messages.
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);

		// Retrieve Songs, and store in the request.
		List<Songs> songs = new ArrayList<Songs>();
		List<String> names = new ArrayList<String>();

		String year = req.getParameter("year");
		int resultYear = 0;

		int start = 1921;
		int end = 2020;

		try {
			if (resultYear >= start && resultYear <= end) {
				songs = songsDao.getTop100SongsOfYear(resultYear);
				messages.put("song", "top 100 Songs of year:" + year);
				names = getArtistNames(songs);

			} else {
				messages.put("song", "Invalid Year.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		req.setAttribute("songs", songs);
		req.setAttribute("names", names);
		req.getRequestDispatcher("/SongByYear.jsp").forward(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);

		// Retrieve Songs, and store in the request.
		List<Songs> songs = new ArrayList<Songs>();
		List<String> names = new ArrayList<String>();

		String year = req.getParameter("year");
		int resultYear = 0;
		try {
			resultYear = Integer.parseInt(year);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw e;
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw e;
		}

		int start = 1921;
		int end = 2020;

		try {
			if (resultYear >= start && resultYear <= end) {
				songs = songsDao.getTop100SongsOfYear(resultYear);
				messages.put("song", "top 100 Songs of year:" + year);
				names = getArtistNames(songs);
			} else {
				messages.put("song", "Invalid Year.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		req.setAttribute("songs", songs);
		req.setAttribute("names", names);
		req.getRequestDispatcher("/SongByYear.jsp").forward(req, resp);
	}

	private List<String> getArtistNames(List<Songs> songs) throws SQLException {
		List<String> names = new ArrayList<String>();
		List<Artists> artists = new ArrayList<Artists>();
		try {
			for (Songs s : songs) {
				artists = artistDao.getArtistBySongId(s.getSongId());
				List<String> intermediate = new ArrayList<String>();
				if (artists.size() == 0) {
					names.add("N/A");
				} else {
					for (Artists a : artists) {
						intermediate.add(a.getArtistName());
					}
					names.add(String.join(",", intermediate));
				}
			}
			return names;

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

	}
}
