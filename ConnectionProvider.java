package com.infy.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	public static Connection getConnection() {
		Connection con = null;
		try {
			/* Initialize and load the JDBC-ODBC Bridge driver */
			Class.forName("oracle.jdbc.OracleDriver");
			/* Establish a connection with a data source */
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			return con;
		} catch (ClassNotFoundException | SQLException e) {

		}
		/* returns connection object */
		return con;
	}

}
