package com.trungtamjava.controller;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
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

@WebServlet(urlPatterns = "/admin/product/list")
public class ProductListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductService productService = new ProductServiceImpl();

		List<Product> list = productService.list("");

		for (Product p : list) {
			System.out.println(p.getId() + p.getName() + p.getCate().getId());
		}
		req.setAttribute("productList", list);
		// get Session
		HttpSession session = req.getSession();
		Object object = session.getAttribute("loginUser");
		if (object != null) {
			User user = (User) object;
			System.err.println(user.getUsername());
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/product/product-list.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}

	}
}
