package com.trungtamjava.dao;

import java.util.List;

import com.trungtamjava.model.Cart;
import com.trungtamjava.model.CartItem;

public interface CartItemDao {
	void add(CartItem item);

	void update(CartItem item);

	void delete(int id);

	CartItem get(int id);

	CartItem getDetail(int cartId);

	List<CartItem> search(String name);

}
