package com.trungtamjava.service;

import java.util.List;

import com.trungtamjava.dao.CartDao;
import com.trungtamjava.dao.CartDaoImpl;
import com.trungtamjava.model.Cart;

public class CartServiceImpl implements CartService {

	CartDao cartDao = new CartDaoImpl();

	@Override
	public void add(Cart cart) {
		cartDao.add(cart);
	}

	@Override
	public void update(Cart cart) {
		cartDao.update(cart);

	}

	@Override
	public void delete(int id) {

		cartDao.delete(id);
	}

	@Override
	public Cart get(int id) {

		return cartDao.get(id);
	}

	@Override
	public List<Cart> search(String name) {

		return cartDao.search(name);
	}

}
