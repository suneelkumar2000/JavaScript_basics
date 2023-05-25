package cys.food_order.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cys.food_order.dao.CustomerImpl;
import cys.food_order.model.Customer;

@WebServlet("/CustomerRegisterTest")
public class CustomerRegisterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CustomerRegisterTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		CustomerImpl cus = new CustomerImpl();
		Customer customer = new Customer();

		String name = request.getParameter("name");
		String mob = request.getParameter("mobile");
		long mobile=Long.parseLong(mob);
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		response.setContentType("text/html");

		try (PrintWriter out = response.getWriter()) {
			customer.setUserName(name); 
			customer.setPhoneNumber(mobile);
			customer.setEmail(email);
			customer.setPassword(password);
			int result = cus.insertCustomerDetails(customer);
			if (result > 0) {
				RequestDispatcher rd = request.getRequestDispatcher("CustomerloginPage.jsp");
				rd.include(request, response);
				out.println("<center><h3>Registered Successfully</h3></center>");
			} else {
				out.println("<center><h3> Fill all details </h3></center>");
				RequestDispatcher rd = request.getRequestDispatcher("RegisterPage.jsp");
				rd.include(request, response);
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
