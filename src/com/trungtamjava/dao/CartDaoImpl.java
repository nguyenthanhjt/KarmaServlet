package com.trungtamjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trungtamjava.model.Cart;
import com.trungtamjava.model.Category;
import com.trungtamjava.service.UserService;
import com.trungtamjava.service.UserServiceImpl;

public class CartDaoImpl extends JDBCConnection implements CartDao {

	UserService userService = new UserServiceImpl();

	@Override
	public void add(Cart cart) {
		Connection con = super.getConnection();
		try {
			String sql = "INSERT INTO cart (id_buyer,status,buy_date) values (?,?,?)";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, cart.getBuyer().getAd());
			preparedStatement.setInt(2, cart.getStatus());
			preparedStatement.setString(3, cart.getBuyDate());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error:  " + e);
		}
	}

	@Override
	public void update(Cart cart) {
		Connection con = super.getConnection();
		try {
			String sql = "Update cart set id_buyer=?,status=?,buy_date=? where id=? ";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, cart.getBuyer().getAd());
			preparedStatement.setInt(2, cart.getStatus());
			preparedStatement.setString(3, cart.getBuyDate());
			preparedStatement.setInt(4, cart.getId());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error:  " + e);
		}
	}

	@Override
	public void delete(int id) {

		Connection con = super.getConnection();
		try {
			String sql = "Delete from cart where id=?;";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error:  " + e);
		}
	}

	@Override
	public Cart get(int id) {
		Connection con = super.getConnection();
		try {
			String sql = "select c.id,c.id_buyer,u.`name`,c.`status`,c.buy_date from cart c inner join user u on u.id=c.id_buyer where c.id=?";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Cart cart = new Cart();
				cart.setId(rs.getInt("id"));
				cart.setBuyer(userService.get(rs.getInt("id_buyer")));
				cart.setStatus(rs.getInt("status"));
				cart.setBuyDate(rs.getString("buy_date"));
				return cart;
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
	public List<Cart> search(String name) {
		List<Cart> list = new ArrayList<Cart>();
		Connection con = super.getConnection();
		try {
			String sql = "select c.id,c.id_buyer,u.`name`,c.`status`,c.buy_date from cart c inner join user u "
					+ "on u.id=c.id_buyer where u.name like ?";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, "%" + name + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Cart cart = new Cart();
				cart.setId(rs.getInt("id"));
				cart.setBuyer(userService.get(rs.getInt("id_buyer")));
				cart.setStatus(rs.getInt("status"));
				cart.setBuyDate(rs.getString("buy_date"));

				list.add(cart);
			}

		} catch (Exception e) {
			System.out.println("Error zzz:  " + e);
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
