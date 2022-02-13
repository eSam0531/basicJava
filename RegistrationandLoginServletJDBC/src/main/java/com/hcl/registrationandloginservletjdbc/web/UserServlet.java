package com.hcl.registrationandloginservletjdbc.web;
//gets user data to add to db
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.registrationandloginservletjdbc.dao.UserDao;
import com.hcl.registrationandloginservletjdbc.entity.User;

@WebServlet("/register")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
		// string variables to hold data input from web page
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		// user object instance created
		User user = new User();
		// data from webpage set to user object
		user.setFname(firstName);
		user.setLname(lastName);
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		
		try {
			// sends user to register on db
			UserDao.registerRecord(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// rediect user to registered page
		resp.sendRedirect("userdetails.jsp");
		
	}
	
}
