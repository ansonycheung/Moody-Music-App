package servlet;

import dal.*;
import model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/usercreate")
public class UserCreate extends HttpServlet {
	protected UsersDao usersDao;
	protected LocationDao locationDao;
	
	@Override
	public void init() throws ServletException {
		usersDao = UsersDao.getInstance();
		locationDao = LocationDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        //Just render the JSP.   
        req.getRequestDispatcher("/UserCreate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        String userName = req.getParameter("username");
        if (userName == null || userName.trim().isEmpty()) {
            messages.put("success", "Invalid UserName");
 
        } else {
        	// Create the User.
        	String phone = req.getParameter("phone");
        	String email = req.getParameter("email");
        	String city = req.getParameter("city");
        	String state = req.getParameter("state");
  
        	try {
        		Location location = new Location(city, state);
        		location = locationDao.create(location);
        		Users user = new Users(userName, phone, email, location);
        		user = usersDao.create(user);
        		messages.put("success", "Successfully created " + userName);
        	} catch (SQLException e) {
        		e.printStackTrace();
				throw new IOException(e);
        	}
        }
        req.getRequestDispatcher("/UserCreate.jsp").forward(req, resp);
    }
}
