package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.*;
import model.*;

@WebServlet("/favoriteSongdelete")
public class FavoriteSongDelete extends HttpServlet {

	protected FavoriteSongsDao favoriteSongsDao;
	
	@Override
	public void init() throws ServletException {
		favoriteSongsDao = FavoriteSongsDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        // Provide a title and render the JSP.
        messages.put("song", "Unfavorite a Song");        
        req.getRequestDispatcher("/FavoriteSongDelete.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate FavoriteSongID.
        String favoriteSongId = req.getParameter("favoritesongid");
        if (favoriteSongId == null || favoriteSongId.trim().isEmpty()) {
            messages.put("song", "Invalid FavoriteSongId");
            messages.put("disableSubmit", "true");
        } else {
        	// Delete the FavoriteSong.
        	
        	FavoriteSongs favoriteSong = new FavoriteSongs(Integer.parseInt(favoriteSongId));
	        try {
	        	favoriteSong = favoriteSongsDao.delete(favoriteSong);
	        	// Update the message.
		        if (favoriteSong == null) {
		            messages.put("song", "Successfully deleted " + favoriteSongId);
		            messages.put("disableSubmit", "true");
		        } else {
		        	messages.put("song", "Failed to delete " + favoriteSongId);
		        	messages.put("disableSubmit", "false");
		        }
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/FavoriteSongDelete.jsp").forward(req, resp);
    }
}
