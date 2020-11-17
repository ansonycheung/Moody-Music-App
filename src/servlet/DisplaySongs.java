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

import dal.*;
import model.*;


@WebServlet("/displaysongs")
public class DisplaySongs extends HttpServlet {
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
		Songs song = null;
		List<String> names = new ArrayList<String>();

		// Retrieve Songs depending on valid song's title or artistName.
		// title or artistName is retrieved from the URL query string.
		String alltime = req.getParameter("alltime");
		String generate = req.getParameter("generate");
		String userName = req.getParameter("username");

		try {
			if (alltime != null) {
				// If the title param is provided then ignore the artist param.
				songs = songsDao.getTop100Songs();
				messages.put("songs", "top 100 Songs of all time");
				names = getArtistNames(songs);
				// Save the previous search term, so it can be used as the default
				// in the input box when rendering FindSongs.jsp.
			} else if (generate != null) {
				// If title is invalid, then use the artistName param.
				song = songsDao.getSongsByWeather(userName);
				songs.add(song);
				names = getArtistNames(songs);
				messages.put("song", "recommending you a song");
			} else {
				messages.put("messages", "Invalid Title and Artist Name.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		req.setAttribute("songs", songs);
		req.setAttribute("names", names);
		req.getRequestDispatcher("/DisplaySongs.jsp").forward(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);

		List<Songs> songs = new ArrayList<Songs>();
		Songs song = null;
		List<String> names = new ArrayList<String>();

		String alltime = req.getParameter("alltime");
		String generate = req.getParameter("generate");
		String userName = req.getParameter("username");

		try {
			if (alltime != null) {
				// If the title param is provided then ignore the artist param.
				songs = songsDao.getTop100Songs();
				names = getArtistNames(songs);
//				for (Songs s: songs) {
//					names.add("a");
//				}
				messages.put("songs", "top 100 Songs of all time");
			} else if (generate != null) {
				// If title is invalid, then use the artistName param.
				song = songsDao.getSongsByWeather(userName);
				songs.add(song);
				names = getArtistNames(songs);
				messages.put("song", "recommending you a song");
			} else {
				messages.put("messages", "Invalid Title and Artist Name.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
		req.setAttribute("songs", songs);
		req.setAttribute("names", names);
		req.getRequestDispatcher("/DisplaySongs.jsp").forward(req, resp);
	}
	
	private List<String> getArtistNames(List<Songs> songs) throws SQLException {
		List<String> names = new ArrayList<String>();
		List<Artists> artists = new ArrayList<Artists>();
		try {
			for (Songs s: songs) {
				artists = artistDao.getArtistBySongId(s.getSongId());
				List<String> intermediate = new ArrayList<String>();
				if (artists.size() == 0) {
					names.add("N/A");
				} else {
					for (Artists a: artists) {
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
