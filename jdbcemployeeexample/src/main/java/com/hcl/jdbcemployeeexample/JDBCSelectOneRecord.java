package com.hcl.jdbcemployeeexample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCSelectOneRecord {
	private static final String selectOne = "select empID, empName, dob, salary, age from employees where id = ?";

	public Employee selectOne(int i) throws SQLException {
		//empty Employee object to be returned
		Employee emp = new Employee();
		// Establish connection
		try (Connection connection = JDBCUtils.getConnection();
				// create statement to be executed
				PreparedStatement ps = connection.prepareStatement(selectOne);) {
			ps.setInt(1, i);
			System.out.println(ps);
			// Execute query
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				// Process results from query
				while (rs.next()) {
					emp.setEmpID(i);
					emp.setEmpName(rs.getNString("empName"));
					emp.setDob(rs.getDate("dob"));
					emp.setSalary(rs.getInt("salary"));
					emp.setAge(rs.getInt("age"));
				}
				return emp;
			}
		} catch (SQLException e) {
			JDBCUtils.printSQLException(e);
		}
		
		return emp;
	}
}
