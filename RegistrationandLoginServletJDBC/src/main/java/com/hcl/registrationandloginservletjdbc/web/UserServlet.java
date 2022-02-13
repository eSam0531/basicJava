package com.hcl.registrationandloginservletjdbc.web;

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
		
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		
		User user = new User();
		
		user.setFname(firstName);
		user.setLname(lastName);
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		
		try {
			UserDao.registerRecord(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		resp.sendRedirect("userdetails.jsp");
		
	}
	
}
