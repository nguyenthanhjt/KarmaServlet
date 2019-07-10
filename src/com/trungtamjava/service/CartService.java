package com.trungtamjava.service;

import java.util.List;

import com.trungtamjava.model.Cart;

public interface CartService {

	void add(Cart cart);

	void update(Cart cart);

	void delete(int id);

	Cart get(int id);

	List<Cart> search(String name);
}
