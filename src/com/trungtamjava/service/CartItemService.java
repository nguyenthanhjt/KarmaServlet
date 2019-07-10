package com.trungtamjava.service;

import java.util.List;

import com.trungtamjava.model.CartItem;

public interface CartItemService {

	void add(CartItem item);

	void update(CartItem item);

	void delete(int id);

	CartItem get(int id);

	CartItem itemDetail(int id);

	List<CartItem> search(String name);
}
