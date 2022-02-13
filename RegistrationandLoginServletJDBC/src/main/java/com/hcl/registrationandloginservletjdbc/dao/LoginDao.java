package com.hcl.registrationandloginservletjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hcl.registrationandloginservletjdbc.entity.User;
import com.hcl.registrationandloginservletjdbc.jdbcutils.JdbcUtils;

public class LoginDao {
	// string to be prepared to send to MySQL db
	public static final String validateUserSQL = "select id from users where username = ? and password = ?;";
	
	public static boolean validate(User user) throws ClassNotFoundException {
		// boolean value to validate user default is false
		boolean valid = false;
		
		Class.forName("com.mysql.jdbc.Driver");
		//start connection
		try (Connection connection = JdbcUtils.getConnection();
				//prepare statement
				PreparedStatement ps = connection.prepareStatement(validateUserSQL);){
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			// execute query
			ResultSet result = ps.executeQuery();
			// check if user is valid
			valid = result.next();
			
		} catch (SQLException e) {
			JdbcUtils.printSQLException(e);
		}
		// return boolean value 
		return valid;
	}

}
