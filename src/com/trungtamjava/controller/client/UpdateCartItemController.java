package com.trungtamjava.controller.client;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

@WebServlet(urlPatterns = "/member/update-cart-item")
public class UpdateCartItemController extends HttpServlet {

	CartItemService cartItemService = new CartItemServiceImpl();

	ProductService productService = new ProductServiceImpl();
	CategoryService categoryService = new CategoryServiceImpl();
	CartService cartService = new CartServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String key = req.getParameter("key");

		HttpSession session = req.getSession();
		Object obj = session.getAttribute("cart");

		if (obj != null) {

			Map<Integer, CartItem> map = (Map<Integer, CartItem>) obj;

			// xoa theo key
//			map.remove(Integer.parseInt(key));
			CartItem cartItem = map.get(Integer.parseInt(key));
			cartItem.setQuantity(Integer.parseInt(req.getParameter("quantity")));
			// update session
			session.setAttribute("cart", map);
		}
		resp.sendRedirect(req.getContextPath() + "/client/gio-hang");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
