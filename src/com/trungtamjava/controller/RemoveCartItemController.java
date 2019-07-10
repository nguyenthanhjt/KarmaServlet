package com.trungtamjava.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.model.CartItem;

@WebServlet(urlPatterns = "/member/remove-cart-item")
public class RemoveCartItemController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String key = req.getParameter("key");

		HttpSession session = req.getSession();
		Object obj = session.getAttribute("cart");

		if (obj != null) {

			Map<Integer, CartItem> map = (Map<Integer, CartItem>) obj;

			// xoa theo key
			map.remove(Integer.parseInt(key));

			// update session
			session.setAttribute("cart", map);
		}
		resp.sendRedirect(req.getContextPath() + "/client/gio-hang");
	}
}
