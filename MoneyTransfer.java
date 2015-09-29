package com.vtaf.account;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vtaf.db.DbConnection;

public class MoneyTransfer extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String LOGIN_PAGE = "index.jsp";
		// String CONFIRM_PAGE = "Transaction.html";
		String receiver = request.getParameter("acc_no");
		String amount = request.getParameter("amount");
		HttpSession session = request.getSession(false);

		if (session != null) {
			session.setAttribute("receiver", Integer.valueOf(receiver));
			session.setAttribute("amount", Double.valueOf(amount));
			sendMoney(request, response);
		} else {
			response.sendRedirect(LOGIN_PAGE);
		}

	}

	public void sendMoney(HttpServletRequest request,
			HttpServletResponse response) {
		String LOGIN_PAGE = "index.jsp";
		String MAIN_PAGE = "WEB-INF/Main.jsp";
		String userIDKey = new String("userID");

		Integer senderId = null;
		Integer receiverId = null;
		double amount = 0;

		try {
			HttpSession session = request.getSession(false);
			if (session != null) {
				senderId = (Integer) session.getAttribute(userIDKey);
				receiverId = (Integer) session.getAttribute("receiver");
				amount = (Double) session.getAttribute("amount");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(LOGIN_PAGE);
				rd.forward(request, response);
			}

			DbConnection dbCon = new DbConnection();
			if (!dbCon.isUserAvailable(senderId)
					|| !dbCon.isUserAvailable(receiverId)) {
				request.setAttribute("Error", "Invalid User!");
				throw new Exception();
			}

			if (!dbCon.isBalanceSufficient(senderId, amount)) {
				request.setAttribute("Error", "Insufficient Balance!");
				throw new Exception();
			}

			boolean success = false;
			success = dbCon.transferMoney(amount, receiverId, senderId);
			if (success) {
				request.setAttribute("mesage", "Money Transferred Successfuly!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				RequestDispatcher rd = request.getRequestDispatcher(MAIN_PAGE);
				rd.forward(request, response);
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		} // end try
	}
}
