package servlets;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.User;

/**
 * Servlet implementation class SERVERLOGIN
 */
@WebServlet("/SERVERLOGIN")
public class SERVERLOGIN extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SERVERLOGIN() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			
			String password;
			String email;
			User userac = new User();
			String typeuser="";
			RequestDispatcher rd = null;
			
			if(request.getParameter("signupbtn") !=null) {
				password = request.getParameter("password");
				email = request.getParameter("email");
			
				typeuser = userac.userlogin(email, password);
				request.setAttribute("typeuser", typeuser);
				request.setAttribute("email", email);
				
				rd = request.getRequestDispatcher("index.jsp");
			}
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
//	protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
//			throws ServletException, IOException {
//		response.setContentType("text/html;charset=UTF-8");
//		try(PrintWriter out = response.getWriter()){
//			
//			String password;
//			String email;
//			User userac = new User();
//			String typeuser="";
//			RequestDispatcher rd = null;
//			
//			if(request.getParameter("signupbtn") !=null) {
//				password = request.getParameter("password");
//				email = request.getParameter("email");
//				typeuser = userac.userlogin(email, password);
//				
//				request.setAttribute("typeuser", typeuser);
//				request.setAttribute("email", email);
//				
//				rd = request.getRequestDispatcher("index.jsp");
//			}
//			rd.forward(request, response);
//		}
//		
//	}

}
