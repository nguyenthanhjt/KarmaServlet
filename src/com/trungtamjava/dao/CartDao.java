package com.trungtamjava.dao;

import java.util.List;

import com.trungtamjava.model.Cart;
import com.trungtamjava.model.Category;

public interface CartDao {

	void add(Cart cart);

	void update(Cart cart);

	void delete(int id);

	Cart get(int id);

	List<Cart> search(String name);
}
