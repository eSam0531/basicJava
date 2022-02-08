package com.hcl.jdbcemployeeexample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCSelectOneRecord {
	private static final String selectOne = "select empID, empName, dob, salary, age from employees where empID = ?;";

	public static Employee1 selectOne(int i) throws SQLException {
		// empty Employee object to be returned
		Employee1 emp = new Employee1();
		// Establish connection
		try (Connection connection = JDBCUtils.getConnection();
				// create statement to be executed
				PreparedStatement ps = connection.prepareStatement(selectOne);) {
			ps.setInt(1, i);
			System.out.println(ps);
			// Execute query
			ResultSet rs = ps.executeQuery();

			// Process results from query
			while (rs.next()) {
				emp.setEmpID(rs.getInt("empID"));
				emp.setEmpName(rs.getNString("empName"));
				emp.setDob(rs.getDate("dob"));
				emp.setSalary(rs.getInt("salary"));
				emp.setAge(rs.getInt("age"));
				System.out.println(emp.toString());
			}
		} catch (SQLException e) {
			JDBCUtils.printSQLException(e);
		}

		return emp;
	}
}
