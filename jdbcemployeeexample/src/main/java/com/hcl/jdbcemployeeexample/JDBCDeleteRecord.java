package com.hcl.jdbcemployeeexample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDeleteRecord {
	
	private static final String deleteRecordSQL = "delete from employees where empID = ?";
	
	public static void deleteRecord(int empID) throws SQLException {
		// Establish Connection
		try(Connection connection = JDBCUtils.getConnection();
			//create a statement
			PreparedStatement ps = connection.prepareStatement(deleteRecordSQL);){
			ps.setInt(1,empID);
			System.out.println(ps);
			
			//Execute query
			ps.executeUpdate();
			System.out.println("The record has been deleted successfuly.");
		} catch (SQLException e) {
			JDBCUtils.printSQLException(e);
		}
	}
}
