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
import com.vivek.commonutils.URL;
import com.vivek.master.model.City;
import com.vivek.master.model.State;
import com.vivek.master.service.CityService;
import com.vivek.master.service.StateService;
import com.vivek.master.service.impl.CityServiceImpl;
import com.vivek.master.service.impl.StateServiceImpl;

/**
 * Servlet implementation class CityController
 */
@WebServlet("/CityController/*")
public class CityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		Boolean isLoggedIn = (Boolean) session.getAttribute(SessionKeys.ISLOGGEDIN);
		if (isLoggedIn==null || !isLoggedIn) {
			response.sendRedirect("/studentCRUD");
		}else {
			try {
				String url = request.getRequestURI();
				String requestfor = "/invalid";
				if (url.contains(URL.VIEWADDPAGE)) {
					requestfor = "/showaddpage";
					
				} else if(url.contains(URL.VIEWEDITPAGE)){
					requestfor = "/edit";

				}
				
				switch (requestfor) {
				case URL.VIEWADDPAGE: {
					StateService stateService = new StateServiceImpl();
					stateService.searchAll();
					request.setAttribute(SessionKeys.STATELIST, stateService);
					RequestDispatcher rd = request.getRequestDispatcher("/pages/master/city/addcity.jsp");
					rd.include(request, response);
					break;
				}
				case URL.VIEWEDITPAGE:{
					StateService stateService = new StateServiceImpl();
					stateService.searchAll();
					request.setAttribute(SessionKeys.STATELIST, stateService);
					CityService cityService = new CityServiceImpl();
					City city = cityService.fetchbyId(Integer.parseInt(request.getParameter("id")));
					request.setAttribute(SessionKeys.CITY, city);
					RequestDispatcher rd = request.getRequestDispatcher("/pages/master/city/editcity.jsp");
					rd.include(request, response);
					
					break;
				}
				default:
//					throw new IllegalArgumentException("Unexpected value: " + requestfor);
				try {
						CityService cityService = new CityServiceImpl();
						cityService.getallCities();
						request.setAttribute("cityService",cityService);
						RequestDispatcher rd = request.getRequestDispatcher("/pages/master/city/viewcities.jsp");
						rd.include(request, response);
						
					}catch (Exception e) {
					e.printStackTrace();
					}	
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I am in citycontroller's doPost");
		HttpSession session = request.getSession();
		Boolean isLoggedIn = (Boolean) session.getAttribute(SessionKeys.ISLOGGEDIN);
		if (isLoggedIn==null || !isLoggedIn) {
			response.sendRedirect("/studentCRUD");
		}else {
			String url = request.getRequestURI();
			String requestfor = "/invalid";
			if (url.contains(URL.ADD)) {
				requestfor = "/save";
				
			} else if(url.contains(URL.UPDATE)){
				requestfor = "/update";
			}
			
			State state = null;
			City city = null;
			try {
				switch (requestfor) {
				case URL.SAVE: {
//					if (request.getParameter("name") != null) {
					city = new City();
					city.setName(request.getParameter("name"));
					state = new State();
					state.setId(Long.parseLong(request.getParameter("stateId")));
					city.setState(state);
					CityService cityService = new CityServiceImpl();
					cityService.addCity(city);
//					}
				}
				response.sendRedirect("/studentCRUD/CityController");
				break;
				
				case URL.UPDATE:{
					city = new City();
					city.setId(Long.parseLong(request.getParameter("id")));
					city.setName(request.getParameter("name"));
					state = new State();
					state.setId(Long.parseLong(request.getParameter("stateId")));
					city.setState(state);
					CityService cityService = new CityServiceImpl();
					cityService.updatecity(city);
					
					
					
				}
				default:
					response.sendRedirect("/studentCRUD/CityController");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

	}
}
