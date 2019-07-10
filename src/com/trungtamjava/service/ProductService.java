package com.trungtamjava.service;

import java.util.List;

import com.trungtamjava.model.Product;

public interface ProductService {
	void add(Product p);
	void update(Product p);
	void delete(int id);
	Product get(int id);
	List<Product> list(String name);
	List<Product> listCategory(int id);
	List<Product> search(String name);
}
