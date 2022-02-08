package com.hcl.jdbcemployeeexample;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Creates a table in mysql database named employees
 * Not used in EmployeeManagmentCLI since I only need to create table once.
 * @author esmee
 *
 */
public class JDBCCreateTable {

	public static final String creatTableSQL = "create table employees (\r\n" + "  empID  int(3) primary key,\r\n" +
	        "  empName varchar(20),\r\n" + "  dob DATE,\r\n" + "  salary int(7),\r\n" +
	        "  age int(3)\r\n" + "  );";
	
	public static void main(String[] args) throws SQLException {
		JDBCCreateTable createTable = new JDBCCreateTable();
		createTable.createTable();
	}
	
	public void createTable() throws SQLException {
		//Establishing connection
		try(Connection connection = JDBCUtils.getConnection();
			//Create a statement using connection object
			Statement statement = connection.createStatement();){
			
			//Execute the query
			statement.execute(creatTableSQL);
			System.out.println("Table has been created in the test database with the name as employees");
		} catch(SQLException e) {
			//print SQL exception details
			JDBCUtils.printSQLException(e);
		}
		
		// close connection(try-with-resources statement will auto-close the connection)
	}

}
