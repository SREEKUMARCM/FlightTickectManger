package com.flightTicket;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Loginconneter
 */
@WebServlet("/Loginconneter")
public class Loginconneter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginconneter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Flightdao fDao=new Flightdao();
		  List<FlightDetails> flightList = fDao.searchFlight();
		  List<PersonalDetails> personalList = fDao.searchPersonal();
	        request.setAttribute("flightList", flightList);
	        request.setAttribute("personalList", personalList);
	        request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
	        System.out.println("************");
	        System.out.println(flightList);
	}

}
