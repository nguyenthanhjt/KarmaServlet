package com.trungtamjava.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.model.Category;
import com.trungtamjava.model.Product;
import com.trungtamjava.model.User;
import com.trungtamjava.service.CategoryService;
import com.trungtamjava.service.CategoryServiceImpl;
import com.trungtamjava.service.ProductService;
import com.trungtamjava.service.ProductServiceImpl;

@WebServlet(urlPatterns = "/admin/product/add")
public class AddProductController extends HttpServlet {

	CategoryService categoryService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Category> listCate = categoryService.search("");
		req.setAttribute("category", listCate);
		// get Session
		HttpSession session = req.getSession();
		Object object = session.getAttribute("loginUser");
		if (object != null) {
			User user2 = (User) object;
			System.err.println(user2.getUsername());
			RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/product/add-product.jsp");
			dispatcher.forward(req, resp);
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String categoryID = req.getParameter("category");

		Product p = new Product();
//		p.setId(Integer.parseInt(id));
		p.setName(name);
		p.setPrice(Integer.parseInt(price));
		p.setCate(categoryService.get(Integer.parseInt(categoryID)));

		ProductService productService = new ProductServiceImpl();
		productService.add(p);

		resp.sendRedirect(req.getContextPath() + "/admin/product/list");

		System.out.println(id);
		System.out.println(name);
		System.out.println(categoryID);

	}
}
