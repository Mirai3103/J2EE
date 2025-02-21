package com.bkap.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseUtil {

	private static String dbFile="/project3.db";
	public static Connection getConnect() {
		Connection con=null;
		try {
			 String connectionURL = "jdbc:sqlite:" + dbFile;
			Class.forName("org.sqlite.JDBC");
			con=DriverManager.getConnection(connectionURL);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
