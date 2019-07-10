package com.trungtamjava.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.model.Category;
import com.trungtamjava.model.User;
import com.trungtamjava.service.CategoryService;
import com.trungtamjava.service.CategoryServiceImpl;

@WebServlet(urlPatterns = "/admin/category/add")
public class AddCategoryController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get Session
		HttpSession session = req.getSession();
		Object object = session.getAttribute("loginUser");
		if (object != null) {
			User user2 = (User) object;
			System.err.println(user2.getUsername());
			RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/category/add-category.jsp");
			dispatcher.forward(req, resp);
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String name = req.getParameter("category-name");
		String count = req.getParameter("count");

		Category cate = new Category();
		cate.setId(Integer.parseInt(id));
		cate.setName(name);
		cate.setCount(count);

		CategoryService categoryService = new CategoryServiceImpl();
		categoryService.add(cate);

		resp.sendRedirect(req.getContextPath() + "/admin/category/list");

		System.out.println(id);
		System.out.println(name);
		System.out.println(count);

	}

}
