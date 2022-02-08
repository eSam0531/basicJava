package com.hcl.jdbcemployeeexample;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDeleteRecord {
	
	private static final String deletRecordSQL = "delete from users where empID = ?";
	
	public void deleteRecord() throws SQLException {
		// Establish Connection
		try(Connection connection = JDBCUtils.getConnection();
				//create a statement
				Statement statement = connection.createStatement();){
			//Execute query
			statement.execute(deletRecordSQL);
			System.out.println("The record has been deleted successfuly.");
		} catch (SQLException e) {
			JDBCUtils.printSQLException(e);
		}
	}
}
