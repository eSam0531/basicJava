package com.hcl.registrationandloginservletjdbc.jdbcutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {

	private static String jdbcURL = "jdbc:mysql://localhost:3306/test";
	private static String jdbcUsername = "esmee";
	private static String jdbcPassword = "TestPassword2022";
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void printSQLException(SQLException ex) {
		for(Throwable e : ex) {
			e.printStackTrace(System.err);
			System.err.println("SQLState: " + ((SQLException) e).getSQLState());
			System.err.println("Error code: " + ((SQLException) e).getErrorCode());
			System.err.println("Message: " + e.getMessage());
			Throwable t = ex.getCause();
			while(t != null) {
				System.out.println("Cause: " + t);
				t = t.getCause();
			}
		}
	}
	
}
