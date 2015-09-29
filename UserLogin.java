package com.vtaf.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vtaf.db.DbConnection;

public class UserLogin extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// expire session
		HttpSession curSession = request.getSession(false);
		if (curSession != null) {
			curSession.invalidate();
		}

		String LOGIN_PAGE = "index.jsp";
		String MAIN_PAGE = "WEB-INF/Main.jsp";
		String userIDKey = new String("userID");
		Integer userID = Integer.valueOf(request.getParameter("userID"));
		String psw = request.getParameter("password");
		boolean loggedIn = false;
		DbConnection dbClass = new DbConnection();

		try {
			boolean logged = dbClass.logUser(userID, psw);
			if (logged == true) {
				HttpSession session = request.getSession(true);
				if (session != null) {
					session.setAttribute(userIDKey, userID);
					loggedIn = true;
				}
			}

		} catch (Exception se) {
			System.out.println(se.getMessage());
		} finally {
			if (loggedIn) {
				RequestDispatcher rd = request.getRequestDispatcher(MAIN_PAGE);
				rd.forward(request, response);
			} else {
				request.setAttribute("Error", "Incorrect UserName/ Password !");
				RequestDispatcher rd = request.getRequestDispatcher(LOGIN_PAGE);
				rd.forward(request, response);

			}
		} // end try
	}
}
