package com.vtaf.db;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbConnection {
	Properties prop;
	// JDBC driver name and database URL
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	String DB_URL;
	String DB;

	// Database credentials
	String USER;
	String PASS;

	Connection conn = null;
	Statement stmt = null;

	public DbConnection() {
		try {

			String result = "";
			prop = new Properties();
			String propFileName = "app.properties";

			InputStream inputStream = getClass().getClassLoader()
					.getResourceAsStream(propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '"
						+ propFileName + "' not found in the classpath");
			}

			// get the property value and print it out
			DB_URL = prop.getProperty("databaseurl");
			DB = prop.getProperty("database");
			USER = prop.getProperty("dbuser");
			PASS = prop.getProperty("dbpassword");

			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL + DB, USER, PASS);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public boolean logUser(int userId, String password) throws Exception {
		boolean userLogged = false;
		try {
			Statement stmtUser = conn.createStatement();

			String sql = "SELECT ID, PassWord  FROM login_details where ID="
					+ userId + " and  PassWord='" + password + "'";
			ResultSet rs = stmtUser.executeQuery(sql);

			while (rs.next()) {
				userLogged = true;
				break;
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return userLogged;
	}

	public boolean isUserAvailable(int userId) {
		boolean userFound = false;
		try {
			Statement stmtUser = conn.createStatement();

			String sql = "SELECT * FROM login_details WHERE ID = " + userId;
			ResultSet rs = stmtUser.executeQuery(sql);

			while (rs.next()) {
				userFound = true;
				break;
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return userFound;
	}

	public boolean isBalanceSufficient(int userId, double amt) {
		boolean isBalanceEnough = false;
		try {
			Statement stmtBalance = conn.createStatement();

			String sql = "SELECT * FROM login_details WHERE ID = " + userId
					+ " AND current_balance >= " + amt;

			ResultSet rs = stmtBalance.executeQuery(sql);
			while (rs.next()) {
				isBalanceEnough = true;
				break;
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return isBalanceEnough;
	}

	public boolean checkPin(int userId, int pin) {
		boolean validPin = false;
		try {
			Statement stmtPin = conn.createStatement();

			String sql = "SELECT * FROM user_info WHERE user_account_no = "
					+ userId + " AND user_PIN = " + pin;

			ResultSet rs = stmtPin.executeQuery(sql);
			while (rs.next()) {
				validPin = true;
				break;
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return validPin;
	}

	public boolean transferMoney(double amount, int receiverId, int senderId)
			throws Exception {
		boolean transferred = false;
		try {
			conn.setAutoCommit(false);
			String sqlAdd = "UPDATE login_details SET current_balance = current_balance -"
					+ amount + " WHERE ID = " + senderId;
			PreparedStatement preparedStatementAdd = conn
					.prepareStatement(sqlAdd);

			String sqlDeduct = "UPDATE login_details SET current_balance = current_balance +"
					+ amount + " WHERE ID = " + receiverId;
			PreparedStatement preparedStatementDeduct = conn
					.prepareStatement(sqlDeduct);

			String sqlLog = "INSERT INTO acc_details VALUES (" + senderId
					+ ", " + amount + ", " + receiverId + ")";
			PreparedStatement preparedStatementLog = conn
					.prepareStatement(sqlLog);

			preparedStatementAdd.executeUpdate();
			preparedStatementDeduct.executeUpdate();
			preparedStatementLog.executeUpdate();
			conn.commit();
			transferred = true;
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return transferred;
	}

	public void sampleMethod02() {

		boolean transferred = false;
		BufferedReader br = null;

		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader("C:\\testing.txt"));

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader("C:\\testing.txt"));

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

    public void sampleMethod03() {

        boolean transferred = false;
        BufferedReader br = null;

        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader("C:\\testing.txt"));

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader("C:\\testing.txt"));

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

    }

}
