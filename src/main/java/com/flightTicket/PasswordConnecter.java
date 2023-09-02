package com.flightTicket;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PasswordConnecter
 */
@WebServlet("/PasswordConnecter")
public class PasswordConnecter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordConnecter() {
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
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String rePassword=request.getParameter("rePassword");
		String newPassword=request.getParameter("newPassword");
		if(password.matches(rePassword)){
			Flightdao fDao=new Flightdao();
			String result=fDao.updatePassword(name,password,newPassword);
			System.out.println("result is "+result);
			request.setAttribute("result", result);
			request.getRequestDispatcher("passwordChange.jsp").forward(request, response);
		}else {
			System.out.println("not matching "+password+":"+rePassword);
		}
		
		
	}

}
