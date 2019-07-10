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
import com.trungtamjava.model.User;
import com.trungtamjava.service.CartService;
import com.trungtamjava.service.CartServiceImpl;
import com.trungtamjava.service.UserService;
import com.trungtamjava.service.UserServiceImpl;

@WebServlet(urlPatterns = "/admin/cart/add")
public class AddCartController extends HttpServlet {

	UserService userService = new UserServiceImpl();
	CartService cartService = new CartServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<User> listUser = userService.listUser("");
		req.setAttribute("user", listUser);

		// get Session
		HttpSession session = req.getSession();
		Object object = session.getAttribute("loginUser");

		// forward to jsp
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cart/add-cart.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idBuyer = req.getParameter("idBuyer");
		String status = req.getParameter("status");
		String buyDate = req.getParameter("buyDate");
		System.out.println(idBuyer + status + buyDate);
		Cart c = new Cart();
		c.setBuyer(userService.get(Integer.parseInt(idBuyer)));
		c.setStatus(Integer.parseInt(status));
		c.setBuyDate(buyDate);

		System.out.println(c.getBuyer().getAd() + c.getBuyer().getName() + c.getBuyDate());
		cartService.add(c);

		resp.sendRedirect(req.getContextPath() + "/admin/cart/list");
	}

}
