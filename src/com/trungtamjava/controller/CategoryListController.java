package com.trungtamjava.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.model.Category;
import com.trungtamjava.service.CategoryService;
import com.trungtamjava.service.CategoryServiceImpl;

@WebServlet(urlPatterns = "/admin/category/list")
public class CategoryListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CategoryService categoryService = new CategoryServiceImpl();

		List<Category> list = categoryService.search("");

		for (Category cate : list) {
			System.out.println(cate.getId() + " " + cate.getName());
		}
		req.setAttribute("categoryList", list);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/category/category-list.jsp");
		dispatcher.forward(req, resp);

	}
}
