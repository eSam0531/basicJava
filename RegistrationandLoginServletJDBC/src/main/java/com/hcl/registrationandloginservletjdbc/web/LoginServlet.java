package com.hcl.registrationandloginservletjdbc.web;

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

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);

		try {
			if (LoginDao.validate(user)) {
				resp.sendRedirect("loginsuccess.jsp");
			} else {
				HttpSession session = req.getSession();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
