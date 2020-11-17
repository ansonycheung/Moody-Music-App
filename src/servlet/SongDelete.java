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

import model.*;
import dal.*;

@WebServlet("/songdelete")
public class SongDelete extends HttpServlet {
	
	protected SongsDao songsDao;

	@Override
	public void init() throws ServletException {
		songsDao = SongsDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        // Provide a song and render the JSP.
        messages.put("song", "Delete Song");        
        req.getRequestDispatcher("/SongDelete.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        String songId = req.getParameter("songid");
        if (songId == null || songId.trim().isEmpty()) {
            messages.put("song", "Invalid Song Id");
            messages.put("disableSubmit", "true");
        } else {
        	// Delete the BlogUser.
        	Songs song;
			try {
				song = songsDao.getSongBySongId(songId);
				song = songsDao.delete(song);
	        	// Update the message.
		        if (song == null) {
		            messages.put("song", "Successfully deleted " + songId);
		            messages.put("disableSubmit", "true");
		        } else {
		        	messages.put("title", "Failed to delete " + songId);
		        	messages.put("disableSubmit", "false");
		        }
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/SongDelete.jsp").forward(req, resp);
    }

}
