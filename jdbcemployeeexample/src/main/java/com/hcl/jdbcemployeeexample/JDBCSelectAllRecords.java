package com.hcl.jdbcemployeeexample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCSelectAllRecords {
	private static final String selectAll = "select empID, empName, dob, salary, age from employees";

	public List<Employee1> selectAll() throws SQLException {
		// empty Employee object to be returned
		List<Employee1> empList = new ArrayList<>();
		Employee1 temp = new Employee1();
		// Establish connection
		try (Connection connection = JDBCUtils.getConnection();
				// create statement to be executed
				PreparedStatement ps = connection.prepareStatement(selectAll);) {
			System.out.println(ps);
			// Execute query
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				temp.setEmpID(rs.getInt("empID"));
				temp.setEmpName(rs.getNString("empName"));
				temp.setDob(rs.getDate("dob"));
				temp.setSalary(rs.getInt("salary"));
				temp.setAge(rs.getInt("age"));
				empList.add(temp);
			}
		} catch (SQLException e) {
			JDBCUtils.printSQLException(e);
		}
		return empList;
	}
}
