package com.trungtamjava.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.model.Cart;
import com.trungtamjava.model.CartItem;
import com.trungtamjava.model.Product;
import com.trungtamjava.service.CartItemService;
import com.trungtamjava.service.CartItemServiceImpl;
import com.trungtamjava.service.CartService;
import com.trungtamjava.service.CartServiceImpl;
import com.trungtamjava.service.CategoryService;
import com.trungtamjava.service.CategoryServiceImpl;
import com.trungtamjava.service.ProductService;
import com.trungtamjava.service.ProductServiceImpl;

@WebServlet(urlPatterns = "/admin/cart-item/update")
public class UpdateCartItemController extends HttpServlet {

	CartItemService cartItemService = new CartItemServiceImpl();

	ProductService productService = new ProductServiceImpl();
	CategoryService categoryService = new CategoryServiceImpl();
	CartService cartService = new CartServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> products = productService.search("");
		req.setAttribute("products", products);

		List<Cart> carts = cartService.search("");
		req.setAttribute("carts", carts);

		int id = Integer.parseInt(req.getParameter("cartItemId"));
		CartItem cartItem = cartItemService.get(id);
		req.setAttribute("cartItem", cartItem);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cart/update-cartitem.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
