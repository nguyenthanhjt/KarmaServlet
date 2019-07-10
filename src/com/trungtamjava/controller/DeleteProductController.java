package com.trungtamjava.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.service.ProductService;
import com.trungtamjava.service.ProductServiceImpl;

@WebServlet(urlPatterns = "/product/delete")
public class DeleteProductController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProductService productService= new ProductServiceImpl();
		String id = req.getParameter("uid");
		
		productService.delete(Integer.parseInt(id));
		
		resp.sendRedirect(req.getContextPath()+"/product/list");
		

	}
}
