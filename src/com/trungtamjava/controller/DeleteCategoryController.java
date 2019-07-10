package com.trungtamjava.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.service.CategoryService;
import com.trungtamjava.service.CategoryServiceImpl;

@WebServlet(urlPatterns = "/category/delete")
public class DeleteCategoryController extends HttpServlet {
	CategoryService categoryService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("uid");

		categoryService.delete(Integer.parseInt(id));

		resp.sendRedirect(req.getContextPath() + "/category/list");

	}
}
