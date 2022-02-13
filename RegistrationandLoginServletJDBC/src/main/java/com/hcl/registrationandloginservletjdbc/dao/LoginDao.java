package com.hcl.registrationandloginservletjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hcl.registrationandloginservletjdbc.entity.User;
import com.hcl.registrationandloginservletjdbc.jdbcutils.JdbcUtils;

public class LoginDao {
	
	public static final String validateUserSQL = "select id from users where username = ? and password = ?;";
	
	public static boolean validate(User user) throws ClassNotFoundException {
		
		boolean valid = false;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = JdbcUtils.getConnection();
				PreparedStatement ps = connection.prepareStatement(validateUserSQL);){
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			
			ResultSet result = ps.executeQuery();
			
			valid = result.next();
			
		} catch (SQLException e) {
			JdbcUtils.printSQLException(e);
		}
		
		return valid;
	}

}
