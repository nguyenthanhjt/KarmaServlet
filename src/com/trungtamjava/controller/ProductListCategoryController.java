package com.trungtamjava.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.model.Product;
import com.trungtamjava.service.ProductService;
import com.trungtamjava.service.ProductServiceImpl;

@WebServlet(urlPatterns = "/admin/product/list2")
public class ProductListCategoryController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductService productService = new ProductServiceImpl();
		
		String id=req.getParameter("uid");
		List<Product> list = productService.listCategory(Integer.parseInt(id));
		
		for(Product p : list) {
			System.out.println(p.getId()+p.getName()+p.getCate().getId());
		}
		req.setAttribute("productList", list);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/admin/product/product-list2.jsp");
		requestDispatcher.forward(req, resp);
	}
	
}
