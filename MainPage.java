package com.vtaf.account;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainPage extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// check session
		HttpSession curSession = request.getSession(false);
		if (curSession == null) {
		response.sendRedirect("index.jsp");
		} else {
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/WEB-INF/Main.html");
			dispatcher.forward(request, response);
		}
	}

}
