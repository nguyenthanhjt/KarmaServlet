package com.trungtamjava.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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

@WebServlet(urlPatterns = "/admin/cart/list")
public class CartListController extends HttpServlet {

	CartService cartService = new CartServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Read cookie
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getName());
				System.out.println(cookie.getValue());
			}
		}
		// Day du lieu vao Req de chuyen tiep qua view JSP file
		List<Cart> carts = cartService.search("");
		req.setAttribute("cartList", carts);

		// get Session
		HttpSession session = req.getSession();
		Object object = session.getAttribute("loginUser");
//		if (object != null) {
//			User user = (User) object;
//			System.err.println(user.getUsername());
//		} else {
//			resp.sendRedirect(req.getContextPath() + "/login");
//		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cart/cart-list.jsp");
		dispatcher.forward(req, resp);
	}
}
