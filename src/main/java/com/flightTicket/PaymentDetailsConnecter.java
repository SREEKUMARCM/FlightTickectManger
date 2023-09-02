package com.flightTicket;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaymentDetailsConnecter
 */
@WebServlet("/PaymentDetailsConnecter")
public class PaymentDetailsConnecter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentDetailsConnecter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flightIdstr=request.getParameter("flightId");
		System.out.println("**********(((((((((("+flightIdstr);
		int flightId=Integer.parseInt(flightIdstr);
        String flightName=null;
        String source=null;
        String destination=null;
       String numberOfPersonsstring=request.getParameter("numberOfPersons");
      int numberOfPersons = Integer.parseInt(numberOfPersonsstring);
      
        //int numberOfPersons =100;
        int price=0;
        int personId=0;
        String date=null;
		FlightDetails flight=new FlightDetails(flightId,flightName,source,destination,numberOfPersons, price,personId,date);
		  Flightdao fDao=new Flightdao();
		  List<FlightDetails> result = fDao.searchFid(flightId);
		  int amount = result.get(0).getPrice();
		  int totalAmount=numberOfPersons*amount;
		  Paymentdetailsclass payment=new Paymentdetailsclass(flightId,personId,amount);
		  Flightdao fDaoPayment=new Flightdao();
		  String resultPayment=fDaoPayment.insertPayment(payment);
		  request.setAttribute("totalAmount", totalAmount);
		  System.out.println("total amount is "+totalAmount);
		  request.setAttribute("result", result);
		  request.getRequestDispatcher("PaymentDetails.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
