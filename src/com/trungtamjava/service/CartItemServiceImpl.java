package com.trungtamjava.service;

import java.util.List;

import com.trungtamjava.dao.CartItemDao;
import com.trungtamjava.dao.CartItemDaoImpl;
import com.trungtamjava.model.CartItem;

public class CartItemServiceImpl implements CartItemService {
	CartItemDao cartItemDao = new CartItemDaoImpl();

	@Override
	public void add(CartItem item) {
		cartItemDao.add(item);
	}

	@Override
	public void update(CartItem item) {
		cartItemDao.update(item);
	}

	@Override
	public void delete(int id) {
		cartItemDao.delete(id);
	}

	@Override
	public CartItem get(int id) {
		return cartItemDao.get(id);
	}

	@Override
	public List<CartItem> search(String name) {

		return cartItemDao.search("");
	}

	@Override
	public CartItem itemDetail(int id) {

		return cartItemDao.getDetail(id);
	}

}
