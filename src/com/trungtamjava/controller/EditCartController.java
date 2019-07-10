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

import com.trungtamjava.model.Cart;
import com.trungtamjava.model.Category;
import com.trungtamjava.model.Product;
import com.trungtamjava.model.User;
import com.trungtamjava.service.CartService;
import com.trungtamjava.service.CartServiceImpl;
import com.trungtamjava.service.CategoryService;
import com.trungtamjava.service.CategoryServiceImpl;
import com.trungtamjava.service.ProductService;
import com.trungtamjava.service.ProductServiceImpl;
import com.trungtamjava.service.UserService;
import com.trungtamjava.service.UserServiceImpl;

@WebServlet(urlPatterns = "/admin/cart/update")
public class EditCartController extends HttpServlet {
	UserService userService = new UserServiceImpl();
	CartService cartService = new CartServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<User> listUser = userService.listUser("");
		req.setAttribute("user", listUser);
		for (User u : listUser) {
			System.out.println(u.getAd() + u.getName());
		}
		String id = req.getParameter("uid");

		Cart c = cartService.get(Integer.parseInt(id));
		System.out.println("cart" + c.getId() + c.getBuyer().getName());
		req.setAttribute("cart", c);

		// get Session
		HttpSession session = req.getSession();
		Object object = session.getAttribute("loginUser");

		// forward to jsp
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cart/update-cart.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String idBuyer = req.getParameter("idBuyer");
		String status = req.getParameter("status");
		String buyDate = req.getParameter("buyDate");

		Cart c = new Cart();
		c.setId(Integer.parseInt(id));
		c.setBuyer(userService.get(Integer.parseInt(idBuyer)));
		c.setStatus(Integer.parseInt(status));
		c.setBuyDate(buyDate);

		System.out.println(c.getId()+c.getBuyer().getName());
		cartService.update(c);

		resp.sendRedirect(req.getContextPath() + "/cart/list");

	}

}
