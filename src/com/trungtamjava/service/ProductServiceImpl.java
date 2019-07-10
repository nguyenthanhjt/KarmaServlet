package com.trungtamjava.service;

import java.util.ArrayList;
import java.util.List;

import com.trungtamjava.dao.ProductDao;
import com.trungtamjava.dao.ProductDaoImpl;
import com.trungtamjava.model.Product;

public class ProductServiceImpl implements ProductService{
	ProductDao productDao=new ProductDaoImpl();
	@Override
	public void add(Product p) {
		productDao.add(p);
		
	}

	@Override
	public void update(Product p) {
		productDao.update(p);
		
	}

	@Override
	public void delete(int id) {
		productDao.delete(id);
	}

	@Override
	public Product get(int id) {
		Product p =productDao.get(id);
		return p;
	}

	@Override
	public List<Product> list(String name) {
		List<Product> list = new ArrayList<Product>();
		list=productDao.list(name);
		return list;
	}

	@Override
	public List<Product> listCategory(int id) {
		List<Product> list = new ArrayList<Product>();
		list=productDao.listCategory(id);
		return list;
	}

	@Override
	public List<Product> search(String name) {
		List<Product> list = new ArrayList<Product>();
		list=productDao.search(name);
		return list;
	}

}
