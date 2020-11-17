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

@WebServlet("/topartists")
public class TopArtists extends HttpServlet {

	protected ArtistsDao artistDao;
	
	@Override
	public void init() throws ServletException {
		artistDao = ArtistsDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        List<Artists> artists = new ArrayList<>();
        
        // Retrieve and validate name.
        // stringYear is retrieved from the URL query string.
        String stringYear = req.getParameter("year");
        if (stringYear == null || stringYear.trim().isEmpty()
        		|| Integer.parseInt(stringYear) < 1921 || Integer.parseInt(stringYear) > 2020 ) {
            messages.put("success", "Please enter a valid year (1921 - 2020).");
        } else {
        	// Retrieve Artists, and store as a message.
        	try {
        		int year = Integer.parseInt(stringYear);
        		artists = artistDao.getArtistsByYear(year);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying top artists for year " + stringYear);
        	// Save the previous search term, so it can be used as the default
        	// in the input box when rendering TopArtists.jsp.
        	messages.put("previousFirstName", stringYear);
        }
        req.setAttribute("artists", artists);        
        req.getRequestDispatcher("/TopArtists.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        List<Artists> artists = new ArrayList<>();
        
        // Retrieve and validate name.
        // stringYear is retrieved from the URL query string.
        // By default, it is populated by the URL query string (in TopArtists.jsp).
        String stringYear = req.getParameter("year");
        if (stringYear == null || stringYear.trim().isEmpty()
        		|| Integer.parseInt(stringYear) < 1921 || Integer.parseInt(stringYear) > 2020 ) {
            messages.put("success", "Please enter a valid year (1921 - 2020).");
        } else {
        	// Retrieve Artists, and store as a message.
        	try {
        		int year = Integer.parseInt(stringYear);
        		artists = artistDao.getArtistsByYear(year);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying top artists for year " + stringYear);
        }
        req.setAttribute("artists", artists);        
        req.getRequestDispatcher("/TopArtists.jsp").forward(req, resp);
    }
}
