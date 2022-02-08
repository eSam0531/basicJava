package com.hcl.jdbcemployeeexample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUpdateEmpSalary {

	private static final String updateSalarySQL = "update employees set salary = ? where empID = ?;";

	public static void updateRecord(int empSalary, int empID) throws SQLException {

		// Establish connection
		try (Connection connection = JDBCUtils.getConnection();
			// create a statement
			PreparedStatement ps = connection.prepareStatement(updateSalarySQL);) {
			ps.setInt(1, empSalary);
			ps.setInt(2, empID);
			
			//Execute the query
			ps.executeUpdate();
			System.out.println("The record has been updated");
			
		} catch (SQLException e) {
			JDBCUtils.printSQLException(e);
		}
	}
}
