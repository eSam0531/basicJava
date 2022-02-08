package com.hcl.jdbcemployeeexample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCGetLastEmpID {

	private static final String lastID = "select empID from employees order by empID desc limit 1;";

	public static int getLastID() {
		int last = 0;

		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement ps = connection.prepareStatement(lastID);) {

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				last = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();

			
		}
		return last;
	}
}
