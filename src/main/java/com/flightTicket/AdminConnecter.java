package com.flightTicket;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminConnecter
 */
@WebServlet("/AdminConnecter")
public class AdminConnecter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminConnecter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag=0;
		String adminName=request.getParameter("name");
		 System.out.println("Admin Name1: " + adminName);
		String AdminPassword=request.getParameter("password");
		 System.out.println("password1: " + AdminPassword);
		Adminclass admidinobj=new Adminclass(adminName,AdminPassword);
		Flightdao fDao=new Flightdao();
		List<Adminclass> result=fDao.searchAdmin();
		 List<FlightDetails> resultflight = fDao.searchFlight();
		for (Adminclass admin : result) {
		    String name = admin.getName();
		    System.out.println("Admin Name: " + name);
		    String password = admin.getPassword();
		    System.out.println("Admin Name: " + password);
		    if((adminName.matches(name))&&(AdminPassword.matches(password))) {
		    	System.out.println("success" );
		    	flag=1;
		    	break;
		    }else {
		    	System.out.println("not success" );
		    	flag=flag;
		    }
		}

	    request.setAttribute("adminflag", flag);
	    request.setAttribute("resultflight", resultflight);
	    if(flag==1) {
	    	
	    	request.getRequestDispatcher("Loginsuccess.jsp").forward(request, response);
	 	   
	    }else {
	    	 request.getRequestDispatcher("Loginfail.jsp").forward(request, response);
	 	   
	    }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
