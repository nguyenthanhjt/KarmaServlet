package com.trungtamjava.controller.client;

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

import com.trungtamjava.model.CartItem;

@WebServlet(urlPatterns = "/client/gio-hang")
public class CartSessionController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// get Session
		HttpSession session = req.getSession();
		Object object = session.getAttribute("loginUser");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/client/cart.jsp");
		dispatcher.forward(req, resp);
	}
}
