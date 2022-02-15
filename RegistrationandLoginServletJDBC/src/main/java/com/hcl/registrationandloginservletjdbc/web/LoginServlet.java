package com.hcl.registrationandloginservletjdbc.web;
//login servlet redirects to success message if successful
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hcl.registrationandloginservletjdbc.dao.LoginDao;
import com.hcl.registrationandloginservletjdbc.entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// gets data input on page
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		// creates user object to hold data input on login page
		User user = new User();
		// sets data received from web page
		user.setUsername(username);
		user.setPassword(password);

		try {
			// calls validate message from LoginDao
			if (LoginDao.validate(user)) {
				// redirects to loginsuccess page if user is valid
				resp.sendRedirect("loginsuccess.jsp");
			} else {
				resp.sendRedirect("loginfailure.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
