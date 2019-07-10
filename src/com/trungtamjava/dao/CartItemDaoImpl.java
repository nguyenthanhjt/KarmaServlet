package com.trungtamjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trungtamjava.model.Cart;
import com.trungtamjava.model.CartItem;
import com.trungtamjava.service.CartService;
import com.trungtamjava.service.CartServiceImpl;
import com.trungtamjava.service.ProductService;
import com.trungtamjava.service.ProductServiceImpl;

public class CartItemDaoImpl extends JDBCConnection implements CartItemDao {

	ProductService productService = new ProductServiceImpl();
	CartService cartService = new CartServiceImpl();

	@Override
	public void add(CartItem item) {

		Connection con = super.getConnection();
		try {
			String sql = "INSERT INTO cart_item (product_id,price,quantity,cart_id) values (?,?,?,?)";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, item.getP().getId());
			preparedStatement.setInt(2, item.getP().getPrice());
			preparedStatement.setInt(3, item.getQuantity());
			preparedStatement.setInt(4, item.getCart().getId());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error:  " + e);
		}
	}

	@Override
	public void update(CartItem item) {

		Connection con = super.getConnection();
		try {
			String sql = "Update cart_item set product_id=?,price=?,quantity=?,cart_id=? where id=? ";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, item.getP().getId());
			preparedStatement.setInt(2, item.getP().getPrice());
			preparedStatement.setInt(3, item.getQuantity());
			preparedStatement.setInt(4, item.getCart().getId());
			preparedStatement.setInt(5, item.getId());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error:  " + e);
		}
	}

	@Override
	public void delete(int id) {

		Connection con = super.getConnection();
		try {
			String sql = "Delete from cart_item where id=?;";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error:  " + e);
		}
	}

	@Override
	public CartItem get(int id) {
		Connection con = super.getConnection();
		try {
			String sql = "select ci.id,c.id as'cart_id',c.id_buyer,u.`name`,p.id as 'product_id',\r\n"
					+ "ci.quantity,p.price,c.`status`,c.buy_date\r\n"
					+ "from product p,cart c,`user` u,cart_item ci\r\n"
					+ "where p.id=ci.product_id and c.id=ci.cart_id and c.id_buyer=u.id and ci.id=?";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				CartItem item = new CartItem();
				item.setId(rs.getInt("id"));
				item.setCart(cartService.get(rs.getInt("cart_id")));
				item.setP(productService.get(rs.getInt("product_id")));
				item.setQuantity(rs.getInt("quantity"));
				item.setUnitPrice(rs.getInt("price"));
				return item;
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
	public List<CartItem> search(String name) {
		List<CartItem> list = new ArrayList<CartItem>();
		Connection con = super.getConnection();
		try {
			String sql = "select ci.id,c.id as'cart_id',c.id_buyer,u.`name`,p.id as 'product_id',\r\n"
					+ "ci.quantity,p.price,c.`status`,c.buy_date\r\n"
					+ "from product p,cart c,`user` u,cart_item ci\r\n"
					+ "where p.id=ci.product_id and c.id=ci.cart_id and c.id_buyer=u.id";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				CartItem item = new CartItem();
				item.setId(rs.getInt("id"));
				item.setCart(cartService.get(rs.getInt("cart_id")));
				item.setP(productService.get(rs.getInt("product_id")));
				item.setQuantity(rs.getInt("quantity"));
				item.setUnitPrice(rs.getInt("price"));
				list.add(item);
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

	@Override
	public CartItem getDetail(int cartId) {
		Connection con = super.getConnection();
		try {
			String sql = "select ci.id,c.id as'cart_id',c.id_buyer,u.`name`,p.id as 'product_id',\r\n"
					+ "ci.quantity,p.price,c.`status`,c.buy_date\r\n"
					+ "from product p,cart c,`user` u,cart_item ci\r\n"
					+ "where p.id=ci.product_id and c.id=ci.cart_id and c.id_buyer=u.id and c.id=?";

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, cartId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				CartItem item = new CartItem();
				item.setId(rs.getInt("id"));
				item.setCart(cartService.get(rs.getInt("cart_id")));
				item.setP(productService.get(rs.getInt("product_id")));
				item.setQuantity(rs.getInt("quantity"));
				item.setUnitPrice(rs.getInt("price"));
				return item;
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

}
