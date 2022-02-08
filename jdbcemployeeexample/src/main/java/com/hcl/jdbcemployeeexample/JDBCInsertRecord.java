package com.hcl.jdbcemployeeexample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCInsertRecord {

	private static final String insertEmployeeSQL = "INSERT INTO employees"
			+ " (empID, empName, dob, salary, age) VALUES " + " (?,?,?,?,?);";

	public void insertRecord(Employee emp) throws SQLException {
		// Establish connection
		try (Connection connection = JDBCUtils.getConnection();
				// Create a statement using connection object
				PreparedStatement ps = connection.prepareStatement(insertEmployeeSQL)) {
			ps.setInt(1, emp.getEmpID());
			ps.setString(2, emp.getEmpName());
			ps.setDate(3, new java.sql.Date(emp.getDob().getTime()));
			ps.setInt(4, emp.getSalary());
			ps.setInt(5, emp.getAge());

			System.out.println(ps);
			// Execute the query
			ps.executeUpdate();
			System.out.println("New employee record has been inserted to table employees");
		} catch (SQLException e) {
			// print SQL execption info
			JDBCUtils.printSQLException(e);
		}
	}
}
