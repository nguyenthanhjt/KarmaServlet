package com.trungtamjava.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.trungtamjava.dao.CategoryDao;
import com.trungtamjava.dao.CategoryDaoImpl;
import com.trungtamjava.dao.JDBCConnection;
import com.trungtamjava.model.Category;

public class CategoryServiceImpl extends JDBCConnection implements CategoryService {
	CategoryDao categoryDao = new CategoryDaoImpl();

	@Override
	public void add(Category cate) {

		categoryDao.add(cate);
	}

	@Override
	public void update(Category cate) {

		categoryDao.update(cate);
	}

	@Override
	public void delete(int id) {

		categoryDao.delete(id);
	}

	@Override
	public Category get(int id) {
		Category cate =categoryDao.get(id);
		return cate;
	}

	@Override
	public List<Category> search(String name) {

		List<Category> list = categoryDao.search(name);
		return list;
	}

}
