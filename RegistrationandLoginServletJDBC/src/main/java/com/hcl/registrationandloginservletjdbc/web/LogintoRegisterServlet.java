package com.hcl.registrationandloginservletjdbc.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogintoRegisterServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	// gets path to new page from link click on page
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		req.getRequestDispatcher("/webapp/" + pathInfo).forward(req, resp);
	}

}
