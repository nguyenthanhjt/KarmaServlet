package com.trungtamjava.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.model.Product;
import com.trungtamjava.model.User;
import com.trungtamjava.service.ProductService;
import com.trungtamjava.service.ProductServiceImpl;

@WebServlet(urlPatterns = "/admin/product/search")
public class SearchProductController extends HttpServlet {
	ProductService productService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("uid");
		// name = "i";
		List<Product> searchList = productService.search(name);
		System.out.println("-" + name);
		req.setAttribute("searchList", searchList);

		// get Session
		HttpSession session = req.getSession();
		Object object = session.getAttribute("loginUser");
		if (object != null) {
			User user2 = (User) object;
			System.err.println(user2.getUsername());
			RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/product/search-product.jsp");
			dispatcher.forward(req, resp);
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("searchpost");
		List<Product> searchList = productService.search(name);
		System.out.println("-" + name);
		req.setAttribute("searchList", searchList);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/search-product.jsp");
		dispatcher.forward(req, resp);
	}

}
