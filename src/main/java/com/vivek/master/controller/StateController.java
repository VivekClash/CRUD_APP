package com.vivek.master.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vivek.commonutils.SessionKeys;
import com.vivek.commonutils.URL;
import com.vivek.master.model.State;
import com.vivek.master.service.StateService;
import com.vivek.master.service.impl.StateServiceImpl;

/**
 * Servlet implementation class StateController
 */
@WebServlet("/StateController/*")
public class StateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StateController() {
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
			String url = request.getRequestURI();
			String requestfor = "/invalid" ;
//					url.contains("/editpage")?"/editpage":"/invalid";
			if(url.contains("/showaddpage")){
				requestfor="/showaddpage";
			}else if (url.contains("/editpage")) {
				requestfor="/editpage";
				
			}
			
			try {
			switch (requestfor) {
			case URL.VIEWADDPAGE :{
				 RequestDispatcher rd = request.getRequestDispatcher("/pages/master/state/addstate.jsp");
				 rd.include(request, response);
				 
				 break;
			}
			case URL.VIEWEDITPAGE :{
				String id = request.getParameter("id");
				StateService service = new StateServiceImpl();
				State state = service.fetchState(Integer.parseInt(id));
				request.setAttribute("state", state);
				RequestDispatcher rd = request.getRequestDispatcher("/pages/master/state/editstate.jsp");
				rd.include(request, response);
				 
				 break;
			}
			default:
				//service 
				
				try {
					StateService service = new StateServiceImpl();
					service.searchAll();
					request.setAttribute("service", service);
					  RequestDispatcher rd = request.getRequestDispatcher("/pages/master/state/statelist.jsp");
					rd.include(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
		}
			
			
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I am in statecontroller's doPost");
		HttpSession session = request.getSession();
		Boolean isLoggedIn = (Boolean) session.getAttribute(SessionKeys.ISLOGGEDIN);
		if (isLoggedIn==null || !isLoggedIn) {
			response.sendRedirect("/studentCRUD");
		}else {
			String url = request.getRequestURI();
//			String requestfor = url.contains("/add")?"/save":"/invalid";
			String requestfor = "/invalid";
			
			if (url.contains("/add")) {
				requestfor="/save";
				
			} else if (url.contains("/update")) {
				requestfor="/update";
			} 
			
			
			try {
				switch (requestfor) {
				case URL.SAVE:{ 
					
//					State state = null;
					if (request.getParameter("name") != null) {
						State state = new State();
						state.setName(request.getParameter("name"));
						StateService service = new StateServiceImpl();
						service.create(state);
					}
						
				}
				response.sendRedirect("/studentCRUD/StateController");
					break;
				case URL.UPDATE:{
					String name = request.getParameter("name");
					String id = request.getParameter("id");
					State stateupdate = new State();
					stateupdate.setId(Long.parseLong(id));
					stateupdate.setName(name);
					StateService service = new StateServiceImpl();
					service.modify(stateupdate);
					
				}
					
				default:
					response.sendRedirect("/studentCRUD/StateController");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
	}
	}
}
