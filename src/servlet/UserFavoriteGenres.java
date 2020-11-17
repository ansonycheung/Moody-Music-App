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

@WebServlet("/userfavoritegenres")
public class UserFavoriteGenres extends HttpServlet  {
	
	protected FavoriteGenresDao favoriteGenresDao;
	
	@Override
	public void init() throws ServletException {
		favoriteGenresDao = FavoriteGenresDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Map for storing messages.
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);

		// Retrieve FavoriteGenres, and store in the request.
		List<FavoriteGenres> favoriteGenres = new ArrayList<FavoriteGenres>();

		// Retrieve FavoriteSongs depending on valid UserName or GenreName.
		String userName = req.getParameter("username");
		String genreName = req.getParameter("genrename");

		try {
			if (userName != null && !userName.trim().isEmpty()) {
				// If the username param is provided then ignore the genrename param.
				Users user = new Users(userName);
				favoriteGenres = favoriteGenresDao.getFavoriteGenresByUser(user);
				messages.put("genre", "Favorite Genres for UserName " + userName);
			} else if (genreName != null && !genreName.trim().isEmpty()) {
				// If username is invalid, then use the genrename param.
				Genres genre = new Genres(genreName);
				favoriteGenres = favoriteGenresDao.getFavoriteGenresByGenre(genre);
				messages.put("genre", "Favorite Songs for GenreName " + genreName);
			} else {
				messages.put("genre", "Invalid UserName and GenreName.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}

		req.setAttribute("favoriteGenres", favoriteGenres);
		req.getRequestDispatcher("/UserFavoriteGenres.jsp").forward(req, resp);
	}

}
