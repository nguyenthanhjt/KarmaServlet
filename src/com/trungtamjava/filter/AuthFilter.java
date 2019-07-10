package com.trungtamjava.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.model.User;

@WebFilter(urlPatterns = { "/user/*", "/product/*","/category/*","/cart/*" })
public class AuthFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Hello Filter");
		// Xu ly Request o tren doFIlter
		// Allow access
		HttpServletRequest req = (HttpServletRequest) request;
 		HttpServletResponse resp = (HttpServletResponse) response;
 
 		HttpSession session = req.getSession();
 		Object obj = session.getAttribute("loginUser");
 		if (obj != null) {
 
 			chain.doFilter(request, response);
 		} else {
 			resp.sendRedirect(req.getContextPath() + "/login");
 		}
//
//		// Xu ly Response
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
