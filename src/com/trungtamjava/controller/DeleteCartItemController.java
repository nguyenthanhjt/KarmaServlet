package com.trungtamjava.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.service.CartItemService;
import com.trungtamjava.service.CartItemServiceImpl;

@WebServlet(urlPatterns = "/admin/cart-item/delete")
public class DeleteCartItemController extends HttpServlet {

	CartItemService cartItemService = new CartItemServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("cartItemId"));

		cartItemService.delete(id);

		resp.sendRedirect(req.getContextPath() + "/admin/cart-item/list");
	}
}
