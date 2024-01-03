package com.vivek.master.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vivek.commonutils.SessionKeys;

@WebServlet (value = "/MasterController")
public class MasterController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Boolean isLoggedIn = (Boolean) session.getAttribute(SessionKeys.ISLOGGEDIN);
		System.out.println(isLoggedIn);
		if (isLoggedIn==null || !isLoggedIn) {
			response.sendRedirect("/studentCRUD/main/");
			
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/pages/Master.jsp");
			rd.include(request, response);
		}
		
	}

}
