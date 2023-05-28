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
import cys.food_order.validation.Validation;
import cys.food_order.exception.EmailException;
import cys.food_order.exception.PasswordException;

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
		Validation val = new Validation();

		String name = request.getParameter("name");
		String mobileNumber = request.getParameter("mobile");
		long mobile = Long.parseLong(mobileNumber);
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		response.setContentType("text/html");

		try (PrintWriter out = response.getWriter()) {
			customer.setUserName(name);
			customer.setPhoneNumber(mobile);

			boolean emailId = val.emailValidation(request.getParameter("email"));
			boolean password1 = val.passwordValidation(request.getParameter("password"));
			try {
				if (emailId == true) {
					customer.setEmail(email);
					int result = cus.insertCustomerDetails(customer);
					try {
						if (password1 == true) {
							customer.setPassword(password);
							if (result > 0) {
								RequestDispatcher rd = request.getRequestDispatcher("CustomerloginPage.jsp");
								rd.include(request, response);
								out.println("<center><h3>Registered Successfully</h3></center>");
							} else {
								out.println("<center><h3> Fill all details </h3></center>");
								RequestDispatcher rd = request.getRequestDispatcher("RegisterPage.jsp");
								rd.include(request, response);
							}
						} else
							throw new PasswordException("Invalid Password", "password");
					} catch (PasswordException ex) {
						out.println("Invalid Password");
						response.sendRedirect("register.jsp");
					}
				} else
					throw new EmailException("Invalid Email ID", "email");
			} catch (EmailException em) {
				out.println("Invalid Email");
				response.sendRedirect("RegisterPage.jsp");
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
