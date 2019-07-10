package com.trungtamjava.controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.model.Category;
import com.trungtamjava.model.Product;
import com.trungtamjava.service.CategoryService;
import com.trungtamjava.service.CategoryServiceImpl;
import com.trungtamjava.service.ProductService;
import com.trungtamjava.service.ProductServiceImpl;

@WebServlet(urlPatterns = "/client/product-list")
public class ProductListCategoryController extends HttpServlet {

	ProductService productService = new ProductServiceImpl();
	CategoryService categoryService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String cateID = req.getParameter("cateID");
		List<Category> categoryList = categoryService.search("");
		List<Product> list = productService.listCategory(Integer.parseInt(cateID));

		for (Category c : categoryList) {
			System.out.println(c.getId() + c.getName());
		}
		for (Product p : list) {
			System.out.println(p.getId() + p.getName() + p.getCate().getId());
		}
		req.setAttribute("productList", list);
		req.setAttribute("categoryList", categoryList);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/client/category-product.jsp");
		requestDispatcher.forward(req, resp);
	}

}
