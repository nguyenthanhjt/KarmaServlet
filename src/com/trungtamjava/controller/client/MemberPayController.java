package com.trungtamjava.controller.client;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.model.Cart;
import com.trungtamjava.model.CartItem;
import com.trungtamjava.model.User;
import com.trungtamjava.service.CartItemService;
import com.trungtamjava.service.CartItemServiceImpl;
import com.trungtamjava.service.CartService;
import com.trungtamjava.service.CartServiceImpl;

@WebServlet(urlPatterns="/member/pay")
public class MemberPayController extends HttpServlet{
	CartItemService cartItemService = new CartItemServiceImpl();
	CartService cartService = new CartServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		///tao cart
		Cart cart = new Cart();
		
		// cart id = 0 ?????????????????????????
		cart.setBuyer(loginUser);
		cart.setStatus(1);
		
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		cart.setBuyDate(sdf.format(now));
		cartService.add(cart);///can lay id gen tu DB set vao de su dung cho cartItem sql
		
		System.out.println(cart.getId()+cart.getBuyer().getName()+cart.getBuyDate());
		//lay cartItem tu sesssion ra
		Object obj = session.getAttribute("cart");
		if (obj != null) {
			Map<Integer, CartItem> map = (Map<Integer, CartItem>) obj;
			
			for (Entry<Integer, CartItem> entry : map.entrySet()) {
				CartItem cartItem = entry.getValue();
//				System.out.println(cartService.get(cart.getId()).getId()+cartService.get(cart.getId()).getBuyer().getName());
				
				// cart id = 0 ?????????????????????????
				cartItem.setCart(cart); // set don hang
				
				cartItemService.add(cartItem);
			}
		}
		
		session.removeAttribute("cart");  //clear gio hang
		resp.sendRedirect(req.getContextPath() + "/client/gio-hang");
	}
	
}
