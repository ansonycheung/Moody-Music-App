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

@WebServlet("/userfavoritesongs")
public class UserFavoriteSongs extends HttpServlet {

	protected FavoriteSongsDao favoriteSongsDao;

	@Override
	public void init() throws ServletException {
		favoriteSongsDao = FavoriteSongsDao.getInstance();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Map for storing messages.
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);

		// Retrieve FavoriteSongs, and store in the request.
		List<FavoriteSongs> favoriteSongs = new ArrayList<FavoriteSongs>();

		// Retrieve FavoriteSongs depending on valid SongId or UserName.
//		String songId = req.getParameter("songid");
		String userName = req.getParameter("username");

		try {
//			if (songId != null && !songId.trim().isEmpty()) {
//				// If the songid param is provided then ignore the username param.
//				favoriteSongs = favoriteSongsDao.getFavoriteSongsBySongsId(songId);
//				messages.put("favoriteSong", "Favorite Songs for songId " + songId);
//			} else 
				if (userName != null && !userName.trim().isEmpty()) {
				// If songid is invalid, then use the username param.
				favoriteSongs = favoriteSongsDao.getFavoriteSongsByUserName(userName);
				messages.put("favoriteSong", "Favorite Songs for UserName " + userName);
			} else {
				messages.put("favoriteSong", "Invalid PostId and UserName.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}

		req.setAttribute("favoriteSongs", favoriteSongs);
		req.getRequestDispatcher("/UserFavoriteSongs.jsp").forward(req, resp);
	}

}
