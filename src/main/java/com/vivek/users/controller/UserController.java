package com.vivek.users.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vivek.commonutils.SessionKeys;
import com.vivek.commonutils.URL;
import com.vivek.users.service.UserService;
import com.vivek.users.service.impl.UserServiceImpl;

@WebServlet(value = "/user/*")
public class UserController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doPost(req, resp);
		System.out.println("usercontroller do post");
		String url = req.getRequestURI();
//		String requestFor = url.split("/studentCRUD/user")[1];
		String requestFor = url.contains("/login")?"/login":"/invalid";
		HttpSession session = null;
		
		
		
		switch (requestFor) {
		case URL.LOGIN: {
			UserService userservice = new UserServiceImpl(); 
			String userId = req.getParameter("userId");
			String password = req.getParameter("password");
			
			try {
				if(userservice.verifyLoginCreds(userId, password)) {
			 		session = req.getSession();
			 		session.setAttribute(SessionKeys.ISLOGGEDIN, true);
			 		resp.sendRedirect("/studentCRUD/main");
//				RequestDispatcher rd = req.getRequestDispatcher("/main");
//				rd.forward(req, resp);
			 		
//					PrintWriter out = resp.getWriter();
//					out.println("<b> Login is succesfull</b>");
				}
			} catch (Exception e) {
				
				RequestDispatcher rd = req.getRequestDispatcher("/pages/user/login.jsp");
				rd.include(req, resp);
				PrintWriter out = resp.getWriter();
				out.println("<b>"+e.getMessage()+"</b>");
				e.printStackTrace();
			}
			break;
			
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + requestFor);
		}
	}
	
	

}
