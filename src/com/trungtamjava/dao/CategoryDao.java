package com.trungtamjava.dao;

import java.util.List;

import com.trungtamjava.model.Category;

public interface CategoryDao {

	void add(Category cate);

	void update(Category cate);

	void delete(int id);

	Category get(int id);

	List<Category> search(String name);
}
