package com.trungtamjava.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.model.Cart;
import com.trungtamjava.model.CartItem;
import com.trungtamjava.service.CartItemService;
import com.trungtamjava.service.CartItemServiceImpl;
import com.trungtamjava.service.CartService;
import com.trungtamjava.service.CartServiceImpl;

@WebServlet(urlPatterns = "/cart-item/detail")
public class CartItemDetailController extends HttpServlet {

	CartService cartService = new CartServiceImpl();
	CartItemService cartItemService = new CartItemServiceImpl();

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
		// get parameter: id
		String id = req.getParameter("cartId");
		// Day du lieu vao Req de chuyen tiep qua view JSP file
		CartItem item = cartItemService.get(Integer.parseInt(id));
		List<CartItem> items = new ArrayList<>();
		items.add(item);
		req.setAttribute("items", items);
		// get Session
		HttpSession session = req.getSession();
		Object object = session.getAttribute("loginUser");
//		if (object != null) {
//			User user = (User) object;
//			System.err.println(user.getUsername());
//		} else {
//			resp.sendRedirect(req.getContextPath() + "/login");
//		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cart/cartitem-list.jsp");
		dispatcher.forward(req, resp);
	}
}
