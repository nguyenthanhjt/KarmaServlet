package com.trungtamjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.trungtamjava.model.User;

public class UserDaoImpl extends JDBCConnection implements UserDao {

	@Override
	public void add(User user) {
		Connection con = JDBCConnection.getConnection2();
		try {
			String sql = "INSERT INTO `servletdemo`.`user` (`name`, `username`, `password`, `gender`, `city`, `role`)"
					+ " VALUES (?,?,?,?,?,?);";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getGender());
			preparedStatement.setString(5, user.getCity());
			preparedStatement.setString(6, user.getRole());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error " + e);
		}

	}

	@Override
	public void update(User user) {
		Connection con = JDBCConnection.getConnection2();
		try {
			String sql = "Update user set name=?,username=?,password=?,gender=?,city=?,role=? where id=?";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getGender());
			preparedStatement.setString(5, user.getCity());
			preparedStatement.setString(6, user.getRole());
			preparedStatement.setInt(7, user.getAd());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error " + e);
		}
	}

	@Override
	public void delete(int id) {
		Connection conn = super.getConnection();
		try {
			String sql = " DELETE FROM `user` WHERE (`id` = ?);";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Loi: " + e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public User get(int id) {
		Connection con = super.getConnection();
		try {
			String sql = "Select * from user where id=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setAd(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
				user.setCity(rs.getString("city"));
				user.setRole(rs.getString("role"));
				return user;
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<User> search(String name) {
		Connection con = super.getConnection();
		List<User> searchList = new ArrayList<>();
//		User user = new User();
		try {
			String sql = "Select * from user";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
//			preparedStatement.setString(1, name);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setAd(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
				user.setCity(rs.getString("city"));
				user.setRole(rs.getString("role"));

				searchList.add(user);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return searchList;
	}

	@Override
	public User get(String username) {
		Connection con = super.getConnection();
		try {
			String sql = "Select * from user where username=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setAd(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
				user.setCity(rs.getString("city"));
				user.setRole(rs.getString("role"));
				return user;
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
