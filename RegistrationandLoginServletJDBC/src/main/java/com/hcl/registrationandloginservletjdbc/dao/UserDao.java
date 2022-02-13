package com.hcl.registrationandloginservletjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hcl.registrationandloginservletjdbc.entity.User;
import com.hcl.registrationandloginservletjdbc.jdbcutils.JdbcUtils;

public class UserDao {

	private static final String insertUserSQL = "INSERT INTO users"
			+ " (ID,fname,lname,username,password,email) VALUES " + " (?,?,?,?,?,?);";
	
	public static int registerRecord(User user) throws ClassNotFoundException{
		
		int result = 0;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = JdbcUtils.getConnection();
				PreparedStatement ps = connection.prepareStatement(insertUserSQL);){
			ps.setInt(1, user.getId());
			ps.setString(2, user.getFname());
			ps.setString(3, user.getLname());
			ps.setString(4, user.getUsername());
			ps.setString(5, user.getPassword());
			ps.setString(6, user.getEmail());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			JdbcUtils.printSQLException(e);
		}
		
		
		return result;
		
	}
	
}
