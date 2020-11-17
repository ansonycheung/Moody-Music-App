package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import dal.*;

@WebServlet("/songcreate")
public class SongCreate extends HttpServlet {

	protected SongsDao songsDao;

	@Override
	public void init() throws ServletException {
		songsDao = SongsDao.getInstance();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Map for storing messages.
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);
		// Just render the JSP.
		req.getRequestDispatcher("/SongCreate.jsp").forward(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Map for storing messages.
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);

		// Retrieve and validate name.
		String songId = req.getParameter("songid");
		if (songId == null || songId.trim().isEmpty()) {
			messages.put("success", "Invalid SongId");
		} else {
			// Create the Songs.
			try {
				double acousticness = Double.parseDouble(req.getParameter("acousticness"));
				double danceability = Double.parseDouble(req.getParameter("danceability"));
				double duration = Double.parseDouble(req.getParameter("duration"));
				double energy = Double.parseDouble(req.getParameter("energy"));
				boolean explicit = req.getParameter("explicit") == "1" ? true : false;
				double instrumentalness = Double.parseDouble(req.getParameter("instrumentalness"));
				int songKey = Integer.parseInt(req.getParameter("songKey"));
				double liveness = Double.parseDouble(req.getParameter("liveness"));
				double loudness = Double.parseDouble(req.getParameter("loudness"));
				boolean mode = req.getParameter("mode") == "1" ? true : false;
				String title = req.getParameter("title");
				int popularity = Integer.parseInt(req.getParameter("popularity"));
				double speechiness = Double.parseDouble(req.getParameter("speechiness"));
				double tempo = Double.parseDouble(req.getParameter("tempo"));
				double valence = Double.parseDouble(req.getParameter("valence"));
				int year = Integer.parseInt(req.getParameter("year"));

				Songs song = new Songs(acousticness, danceability, duration, energy, explicit, songId, instrumentalness,
						songKey, liveness, loudness, mode, title, popularity, speechiness, tempo, valence, year);
				song = songsDao.create(song);
				messages.put("success", "Successfully created " + songId);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}

		}

		req.getRequestDispatcher("/UserCreate.jsp").forward(req, resp);
	}

}
