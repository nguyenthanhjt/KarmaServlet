package com.trungtamjava.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/hello-session"})
public class Session1 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession=req.getSession();
		
		httpSession.setAttribute("name", "trung tam java");
		
		resp.setContentType("text/html");
		
		PrintWriter printWriter =resp.getWriter();
		
		printWriter.println("Xin chao trung tam java - set Session");
	}
}




