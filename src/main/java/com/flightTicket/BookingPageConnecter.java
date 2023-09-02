package com.flightTicket;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class BookingPageConnecter
 */
@WebServlet("/BookingPageConnecter")
public class BookingPageConnecter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingPageConnecter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fidStr=request.getParameter("flightId");
		int fId=Integer.parseInt(fidStr);
		String pIdStr=request.getParameter("pId");
		System.out.println("fID"+fidStr);
		int pId=Integer.parseInt(pIdStr);
		String pName=request.getParameter("pName");
		String ageStr=request.getParameter("age");
		int age=Integer.parseInt(ageStr);
		String gender=request.getParameter("gender");
		PersonalDetails personal=new PersonalDetails(pId,pName,age,gender,fId);
		Flightdao fDao=new Flightdao();
		  String result= fDao.insert(personal);
		  request.setAttribute("flightId", fId);
		
		    request.setAttribute("insertResult", result);

		   
		    RequestDispatcher dispatcher = request.getRequestDispatcher("PaymentDetails.jsp"); 
		    dispatcher.forward(request, response);
	}

}
