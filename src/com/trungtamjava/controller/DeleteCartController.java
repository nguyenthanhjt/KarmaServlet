package com.trungtamjava.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.service.CartService;
import com.trungtamjava.service.CartServiceImpl;

@WebServlet(urlPatterns = "/cart/delete")
public class DeleteCartController extends HttpServlet {

	CartService cartService = new CartServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("uid");
		cartService.delete(Integer.parseInt(id));

		resp.sendRedirect(req.getContextPath() + "/cart/list");
	}
}
