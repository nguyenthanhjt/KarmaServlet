package com.trungtamjava.controller.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.model.CartItem;
import com.trungtamjava.model.Product;
import com.trungtamjava.service.ProductService;
import com.trungtamjava.service.ProductServiceImpl;

@WebServlet(urlPatterns = "/client/add-to-cart")

public class AddToCartController extends HttpServlet {

	ProductService productService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String pID = req.getParameter("productId");

		Product product = productService.get(Integer.parseInt(pID));

		HttpSession session = req.getSession();
		Object obj = session.getAttribute("cart");
		if (obj == null) { // chua co gi trong gio? hang`
			// them hang`
			CartItem cartItem = new CartItem();
			cartItem.setQuantity(1);
			cartItem.setUnitPrice(product.getPrice());
			cartItem.setP(product);
			// gio hang co nhieu hang`
			Map<Integer, CartItem> map = new HashMap<>();
			map.put(product.getId(), cartItem);

			// set CartItem vao Session
			session.setAttribute("cart", map);

		} else {
			Map<Integer, CartItem> map = (Map<Integer, CartItem>) obj;
			// tim theo key
			CartItem cartItem = map.get(product.getId());
			if (cartItem == null) {
				// them hang`
				CartItem cartItem2 = new CartItem();
				cartItem2.setQuantity(1);
				cartItem2.setUnitPrice(product.getPrice());
				cartItem2.setP(product);

				map.put(product.getId(), cartItem2);

			} else {
				cartItem.setQuantity(cartItem.getQuantity() + 1);
			}
			session.setAttribute("cart", map);
		}
		resp.sendRedirect(req.getContextPath() + "/client/gio-hang");

	}
}
