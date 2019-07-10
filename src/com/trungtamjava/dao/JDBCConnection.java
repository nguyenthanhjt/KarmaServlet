package com.trungtamjava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	public static void main(String[] args) {
		JDBCConnection jdbcConnection = new JDBCConnection();

		Connection con = jdbcConnection.getConnection();
		if (con == null) {
			System.out.println("Ket noi that bai");

		} else {
			System.out.println("Ket noi thanh cong");
		}
	}

	public Connection getConnection() {
		try {
			final String user = "nguyenthanhjt";
			final String password = "4197";
			final String url = "jdbc:mysql://localhost:3306/servletdemo?useSSL=false";

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;

		} catch (Exception e) {
			System.out.println("Loi ket noi");
		}
		return null;
		
	}

	public static Connection getConnection2() {
		try {
			final String user = "nguyenthanhjt";
			final String password = "4197";
			final String url = "jdbc:mysql://localhost:3306/servletdemo?useSSL=false";

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;

		} catch (Exception e) {
			System.out.println("Loi" +e);
		}
		return null;
	}

}
