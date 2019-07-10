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

@WebFilter(urlPatterns = { "/admin/*" })
public class AdminFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Hello Filter---");
		// Xu ly Request o tren doFIlter

		// Allow access
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		HttpSession session = req.getSession();
		Object obj = session.getAttribute("loginUser");
		User user = (User) obj;
//		System.out.println(user.getAd() + user.getName() + user.getRole());
		System.out.println("---obj---");

		if (user != null) {
//			User user = (User) obj;
			if (user.getRole().equals("Admin")) {
				// cho di tiep
				System.out.println("---Admin---");
				chain.doFilter(request, response);
			} else if(user.getRole().equals("Member")){
				resp.sendRedirect(req.getContextPath() + "/access-deny");
				System.out.println("---Not admin---> login");
			}
		} else {
			System.out.println("---Need to login---");
			resp.sendRedirect(req.getContextPath() + "/login");
		}

		// Xu ly Response
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
