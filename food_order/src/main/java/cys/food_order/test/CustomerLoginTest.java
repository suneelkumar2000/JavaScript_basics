package cys.food_order.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cys.food_order.dao.CustomerImpl;
import cys.food_order.model.Customer;

@WebServlet("/CustomerLoginTest")
public class CustomerLoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CustomerLoginTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		CustomerImpl cus = new CustomerImpl();

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		response.setContentType("text/html");

		try (PrintWriter out = response.getWriter()) {
			boolean result = cus.customerLogin(name,password);
			
			if (result == true) {
				int customerId=cus.findCustomerId(name);
				String id=String.valueOf(customerId);
				String email=cus.findEmail(customerId);
				HttpSession session=request.getSession(true);
				session.putValue("customerId",id);
				session.putValue("userName",name);
				session.putValue("email",email);
				response.sendRedirect("Menu.jsp");
				
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
				rd.include(request, response);
				out.println("<center><h3> Incorrect Username and password </h3></center>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
