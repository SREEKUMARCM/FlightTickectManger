package com.flightTicket;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class flightConnector
 */
@WebServlet("/flightConnector")
public class flightConnector extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public flightConnector() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int flightId = 0;
	    String flightName = null;
	    String source = request.getParameter("source");
	    String destination = request.getParameter("destination");
	    String numberOfPersonsstring=request.getParameter("numberOfPersons");
	    int numberOfPersons = Integer.parseInt(numberOfPersonsstring);
	    int price = 0;
	    int personId = 0;
	    String date = request.getParameter("date");

	    FlightDetails flight = new FlightDetails(flightId, flightName, source, destination, numberOfPersons, price, personId,date);
	    Flightdao fDao = new Flightdao();
	    List<FlightDetails> result = fDao.search(source, destination, numberOfPersons, date);

	    request.setAttribute("flightResults", result);

	    RequestDispatcher dispatcher = request.getRequestDispatcher("FlightList.jsp");
	    dispatcher.forward(request, response);
	}


}
