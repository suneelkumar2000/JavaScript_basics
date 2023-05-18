package cys.food_order.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cys.food_order.dao.CustomerImpl;


@WebServlet("/PaymentTest")
public class PaymentTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PaymentTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		CustomerImpl cus = new CustomerImpl();

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		response.setContentType("text/html");

		try (PrintWriter out = response.getWriter()) {
			boolean result = cus.customerLogin(name,password);
			
			if (result == true) {
				response.sendRedirect("ThankYou.jsp");
				
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("Payment.jsp");
				rd.include(request, response);
				out.println("<center> Incorrect Username and password </center>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
