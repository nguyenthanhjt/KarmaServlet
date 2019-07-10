package com.trungtamjava.controller.client;

import java.io.IOException;
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

@WebServlet(urlPatterns = "/client/search-product")
public class SearchProductController extends HttpServlet {
	ProductService productService = new ProductServiceImpl();
	CategoryService categoryService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("uid");
		// name = "i";
		List<Product> productList = productService.search(name);
		System.out.println("-" + name);
		req.setAttribute("productList", productList);

		List<Category> categoryList = categoryService.search("");
		req.setAttribute("categoryList", categoryList);
		// get Session
		HttpSession session = req.getSession();
		Object object = session.getAttribute("loginUser");
//		if (object != null) {
//			User user2 = (User) object;
//			System.err.println(user2.getUsername());
//		} else {
//			resp.sendRedirect(req.getContextPath() + "/login");
//		}
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/client/category-product.jsp");
		requestDispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("keyword");
		List<Product> productList = productService.search(name);
		System.out.println("-" + name);
		req.setAttribute("productList", productList);

		List<Category> categoryList = categoryService.search("");
		req.setAttribute("categoryList", categoryList);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/client/category-product.jsp");
		requestDispatcher.forward(req, resp);
	}

}
