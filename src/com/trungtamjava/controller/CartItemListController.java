package com.trungtamjava.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.model.CartItem;
import com.trungtamjava.service.CartItemService;
import com.trungtamjava.service.CartItemServiceImpl;

@WebServlet(urlPatterns = "/admin/cart-item/list")
public class CartItemListController extends HttpServlet{
	CartItemService cartItemService = new CartItemServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CartItem> items = cartItemService.search(""); 
		req.setAttribute("items", items);
		for(CartItem i : items) {
			System.out.println(i.getId()+"Buyer: "+i.getCart().getBuyer().getName()+"--"+i.getP().getName()+"=="+i.getQuantity()+i.getUnitPrice());
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cart/cartitem-list.jsp");
		dispatcher.forward(req, resp);
	}
	
}
