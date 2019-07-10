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
import com.trungtamjava.model.CartItem;
import com.trungtamjava.model.Category;
import com.trungtamjava.model.Product;
import com.trungtamjava.model.User;
import com.trungtamjava.service.CartItemService;
import com.trungtamjava.service.CartItemServiceImpl;
import com.trungtamjava.service.CartService;
import com.trungtamjava.service.CartServiceImpl;
import com.trungtamjava.service.CategoryService;
import com.trungtamjava.service.CategoryServiceImpl;
import com.trungtamjava.service.ProductService;
import com.trungtamjava.service.ProductServiceImpl;

@WebServlet(urlPatterns = "/admin/cart-item/add")
public class AddCartItemController extends HttpServlet {

	ProductService productService = new ProductServiceImpl();
	CategoryService categoryService = new CategoryServiceImpl();
	CartService cartService = new CartServiceImpl();
	CartItemService cartItemService = new CartItemServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Product> products = productService.search("");
		req.setAttribute("products", products);

		List<Cart> carts = cartService.search("");
		req.setAttribute("carts", carts);
		// get Session
		HttpSession session = req.getSession();
		Object object = session.getAttribute("loginUser");

		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cart/add-cartitem.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("11111111111111111111");
		int productId = Integer.parseInt(req.getParameter("productId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		int cartId = Integer.parseInt(req.getParameter("cartId"));
		System.out.println("2222222222222" + productId + "zz" + quantity + "zz" + cartId);
		Product p = productService.get(productId);
		System.out.println("3333333333333333333333");
		Cart c = cartService.get(cartId);
//		
		System.out.println("44444444444444444444");
		CartItem cartItem = new CartItem();
		cartItem.setCart(c);
		cartItem.setP(p);
		cartItem.setQuantity(quantity);
		cartItem.setUnitPrice(p.getPrice());
		System.out.println("product" + cartItem.getP().getName() + "ID " + cartItem.getCart().getId()
				+ cartItem.getUnitPrice() + "quantity:" + cartItem.getQuantity());

		cartItemService.add(cartItem);

		resp.sendRedirect(req.getContextPath() + "/admin/cart-item/list");

	}
}
