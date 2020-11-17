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

@WebServlet("/favoritesongcreate")
public class FavoriteSongCreate extends HttpServlet {
	
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
        //Just render the JSP.   
        req.getRequestDispatcher("/FavoriteSongCreate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate foreign key (songID, userName).
        String songID = req.getParameter("songid");
    	String userName = req.getParameter("username");
        if (songID == null || songID.trim().isEmpty() || userName == null || userName.trim().isEmpty()) {
            messages.put("success", "Invalid input");
        } else {
        	// Create the FavoriteSongs instance.
	        try {
	        	Songs song = new Songs(songID);
	        	Users user = new Users(userName);
	        	FavoriteSongs favoriteSong = new FavoriteSongs(user, song);
	        	favoriteSong = favoriteSongsDao.create(favoriteSong);
	        	messages.put("success", "Successfully created " + userName);
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/FavoriteSongCreate.jsp").forward(req, resp);
    }

}
