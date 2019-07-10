package com.trungtamjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trungtamjava.model.Category;

public class CategoryDaoImpl extends JDBCConnection implements CategoryDao {

	@Override
	public void add(Category cate) {
		Connection con = super.getConnection();
		try {
			String sql = "INSERT INTO `servletdemo`.`category` (`category_name`, `category_count`) VALUES (?,?);";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, cate.getName());
			preparedStatement.setInt(2, Integer.parseInt(cate.getCount()));
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error:  " + e);
		}
	}

	@Override
	public void update(Category cate) {
		Connection con = super.getConnection();
		try {
			String sql = "Update category set name=?,category_count=?;";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, cate.getId());
			preparedStatement.setString(2, cate.getName());
			preparedStatement.setString(3, cate.getCount());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error:  " + e);
		}
	}

	@Override
	public void delete(int id) {

		Connection con = super.getConnection();
		try {
			String sql = "Delete from category where id=?;";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error:  " + e);
		}
	}

	@Override
	public Category get(int id) {
		Connection con = super.getConnection();
		try {
			String sql = "Select * from category where id=?";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Category cate = new Category();
				cate.setId(rs.getInt("id"));
				cate.setName(rs.getString("category_name"));
				cate.setCount(rs.getString("category_count"));
				return cate;
			}

		} catch (Exception e) {
			System.out.println("Error:  " + e);
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
	public List<Category> search(String name) {

		List<Category> list = new ArrayList<Category>();
		Connection con = super.getConnection();
		try {
			String sql = "select c.id,c.category_name,COUNT(p.id) as 'SL' from category c,product p\r\n" + 
					"where c.id=p.category_id \r\n" + 
					"group by c.category_name";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Category cate = new Category();
				cate.setId(rs.getInt("id"));
				cate.setName(rs.getString("category_name"));
				cate.setCount(rs.getString("SL"));

				list.add(cate);

			}

		} catch (Exception e) {
			System.out.println("Error:  " + e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

}
