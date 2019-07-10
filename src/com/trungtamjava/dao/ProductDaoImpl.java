package com.trungtamjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.trungtamjava.model.Product;
import com.trungtamjava.service.CategoryService;

public class ProductDaoImpl extends JDBCConnection implements ProductDao {
	CategoryDao categoryDao = new CategoryDaoImpl();

	@Override
	public void add(Product p) {

		Connection con = JDBCConnection.getConnection2();
		try {
			String sql = "INSERT INTO `servletdemo`.`product` (`name`,`category_id`,`price`,`image') VALUES (?,?,?,?);";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, p.getName());
			preparedStatement.setInt(2, p.getCate().getId());
			preparedStatement.setInt(3, p.getPrice());
			preparedStatement.setString(4, p.getImage());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error:  " + e);
		}
	}

	@Override
	public void update(Product p) {
		Connection con = JDBCConnection.getConnection2();
		try {
			String sql = "UPDATE `servletdemo`.`product` SET `name` =?, `category_id` =?,`price`=?,`image`=?  WHERE (`id` =?);";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, p.getName());
			preparedStatement.setInt(2, p.getCate().getId());
			preparedStatement.setInt(3, p.getPrice());
			preparedStatement.setString(4, p.getImage());
			preparedStatement.setInt(5, p.getId());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error:  " + e);
		}

	}

	@Override
	public void delete(int id) {
		Connection con = JDBCConnection.getConnection2();
		try {
			String sql = "delete from product where id=?;";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error:  " + e);
		}
	}

	@Override
	public Product get(int id) {
		Connection con = JDBCConnection.getConnection2();
		try {
			String sql = "select * from product where id=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setCate(categoryDao.get(rs.getInt("category_id")));
				p.setPrice(rs.getInt("price"));
				p.setImage(rs.getString("image"));

				return p;
			}
		} catch (Exception e) {
			System.out.println("Error:  " + e);
		}
		return null;
	}

	@Override
	public List<Product> list(String name) {
		List<Product> list = new ArrayList<Product>();
		Connection con = JDBCConnection.getConnection2();
		try {
			String sql = "select * from product ";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setCate(categoryDao.get(rs.getInt("category_id")));
				p.setPrice(rs.getInt("price"));
				p.setImage(rs.getString("image"));
				list.add(p);
			}
		} catch (Exception e) {
			System.out.println("Error:  " + e);
		}

		return list;
	}

	@Override
	public List<Product> listCategory(int id) {
		List<Product> list = new ArrayList<Product>();
		Connection con = JDBCConnection.getConnection2();
		try {
			String sql = "select * from product where category_id=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getInt("price"));
				p.setCate(categoryDao.get(rs.getInt("category_id")));
				p.setImage(rs.getString("image"));

				list.add(p);
			}
		} catch (Exception e) {
			System.out.println("Error:  " + e);
		}

		return list;
	}

	@Override
	public List<Product> search(String name) {
		List<Product> list = new ArrayList<Product>();
		Connection con = JDBCConnection.getConnection2();
		try {
			String sql = "select * from `servletdemo`.`product` p where `p`.`name` like ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, "%" + name + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Product newP = new Product();
				newP.setId(rs.getInt("id"));
				newP.setName(rs.getString("name"));
				newP.setCate(categoryDao.get(rs.getInt("category_id")));
				newP.setPrice(rs.getInt("price"));
				newP.setImage(rs.getString("image"));
				list.add(newP);
			}
		} catch (Exception e) {
			System.out.println("Error:  " + e);
		}

		return list;
	}

}
