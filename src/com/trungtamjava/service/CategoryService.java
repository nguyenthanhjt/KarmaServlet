package com.trungtamjava.service;

import java.util.List;

import com.trungtamjava.model.Category;

public interface CategoryService {
	void add(Category cate);

	void update(Category cate);

	void delete(int id);

	Category get(int id);

	List<Category> search(String name);

}
