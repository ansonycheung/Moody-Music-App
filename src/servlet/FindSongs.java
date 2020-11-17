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

import model.*;
import dal.*;

/**
 * FindSongs is the primary entry point into the application.
 * 
 * Note the logic for doGet() and doPost() are almost identical. However, there
 * is a difference: doGet() handles the http GET request. This method is called
 * when you put in the /findsongs URL in the browser. doPost() handles the http
 * POST request. This method is called after you click the submit button.
 * 
 * To run: 1. Run the SQL script to recreate your database schema. 2. Insert
 * test data. You can do this by running blog.tools.Inserter (right click, Run
 * As > JavaApplication. Notice that this is similar to Runner.java in our JDBC
 * example. 3. Run the Tomcat server at localhost. 4. Point your browser to
 * http://localhost:8080/MoodyMusicApp/findsongs.
 */
@WebServlet("/findsongs")
public class FindSongs extends HttpServlet {
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

		// Retrieve Artists and corresponding Songs, and store in the request.
		// List<Artists> as key, because a song may have more than one artist.
		// List<Songs> as value, because a artist has more than one song.
		Map<List<Artists>, List<Songs>> outputMap = new HashMap<>();
		List<Artists> artistsList = new ArrayList<>();
		List<Songs> songsList = new ArrayList<>();

		// Retrieve Songs depending on valid song's title or artistName.
		// title or artistName is retrieved from the URL query string.
		String title = req.getParameter("title");
		String artistName = req.getParameter("artistname");

		try {
			if (title != null && !title.trim().isEmpty()) {
				// If the title parameter is provided then ignore the artistName parameters.
				List<Songs> songs = songsDao.getSongsByTitle(title);
				for (Songs song : songs) {
					artistsList = artistDao.getArtistBySongId(song.getSongId());
					songsList.add(song);
					outputMap.put(artistsList, songsList);
				}
				messages.put("song", "Songs for Title " + title);
				// Save the previous search term, so it can be used as the default
				// in the input box when rendering FindSongs.jsp.
				messages.put("previousSongTitle", title);
			} else if (artistName != null && !artistName.trim().isEmpty()) {
				// If title is invalid, then use the artistName parameters.
				Map<Integer, List<Songs>> songsByArtistName = songsDao.getSongsByArtistName(artistName);
				for (Map.Entry<Integer, List<Songs>> entry: songsByArtistName.entrySet()) {
					Artists artist = artistDao.getArtistByArtistKey(entry.getKey());
					artistsList.add(artist);
					outputMap.put(artistsList, entry.getValue());
				}

				messages.put("song", "Songs for Artist Name " + artistName);
				// Save the previous search term, so it can be used as the default
				// in the input box when rendering FindSongs.jsp.
				messages.put("previousArtistName", artistName);
			} else {
				messages.put("song", "Invalid Title and Artist Name.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}

		req.setAttribute("outputmap", outputMap);
		req.getRequestDispatcher("/FindSongs.jsp").forward(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Map for storing messages.
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);

		// Retrieve Artists and corresponding Songs, and store in the request.
		// List<Artists> as key, because a song may have more than one artist.
		// List<Songs> as value, because a artist has more than one song.
		Map<List<Artists>, List<Songs>> outputMap = new HashMap<>();
		List<Artists> artistsList = new ArrayList<>();
		List<Songs> songsList = new ArrayList<>();

		// Retrieve Songs depending on valid song's title or artistName.
		// title or artistName is retrieved from the URL query string.
		String title = req.getParameter("title");
		String artistName = req.getParameter("artistname");

		try {
			if (title != null && !title.trim().isEmpty()) {
				// If the title parameter is provided then ignore the artistName parameters.
				List<Songs> songs = songsDao.getSongsByTitle(title);
				for (Songs song : songs) {
					artistsList = artistDao.getArtistBySongId(song.getSongId());
					songsList.add(song);
					outputMap.put(artistsList, songsList);
				}
				messages.put("song", "Songs for Title " + title);
			} else if (artistName != null && !artistName.trim().isEmpty()) {
				// If title is invalid, then use the artistName parameters.
				Map<Integer, List<Songs>> songsByArtistName = songsDao.getSongsByArtistName(artistName);
				for (Map.Entry<Integer, List<Songs>> entry: songsByArtistName.entrySet()) {
					Artists artist = artistDao.getArtistByArtistKey(entry.getKey());
					artistsList.add(artist);
					outputMap.put(artistsList, entry.getValue());
				}

				messages.put("song", "Songs for Artist Name " + artistName);
			} else {
				messages.put("song", "Invalid Title and Artist Name.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}

		req.setAttribute("outputmap", outputMap);
		req.getRequestDispatcher("/FindSongs.jsp").forward(req, resp);
	}

}
