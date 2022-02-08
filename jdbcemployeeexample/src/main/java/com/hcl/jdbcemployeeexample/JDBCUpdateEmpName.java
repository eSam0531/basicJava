package com.hcl.jdbcemployeeexample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUpdateEmpName {

	private static final String updateNameSQL = "update employees set empName = ? where empID = ?;";

	public void updateRecord(String empName, int empID) throws SQLException {

		// Establish connection
		try (Connection connection = JDBCUtils.getConnection();
			// create a statement
			PreparedStatement ps = connection.prepareStatement(updateNameSQL);) {
			ps.setString(1, empName);
			ps.setInt(2, empID);
			
			//Execute the query
			ps.executeUpdate();
			System.out.println("The record has been updated");
			
		} catch (SQLException e) {
			JDBCUtils.printSQLException(e);
		}
	}
}
