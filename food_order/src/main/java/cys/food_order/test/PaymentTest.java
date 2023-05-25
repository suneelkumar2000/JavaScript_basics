package cys.food_order.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cys.food_order.dao.CustomerImpl;
import cys.food_order.dao.FoodItemImpl;
import cys.food_order.dao.OrderImpl;
import cys.food_order.dao.OrderItemImpl;
import cys.food_order.model.OrderItem;
import cys.food_order.util.ConnectionUtil;

@WebServlet("/PaymentTest")
public class PaymentTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PaymentTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		CustomerImpl cus = new CustomerImpl();
		OrderItemImpl or = new OrderItemImpl();
		OrderImpl ord = new OrderImpl();
		FoodItemImpl fi = new FoodItemImpl();

		HttpSession session = request.getSession(true);
		String customer = (String) session.getValue("customerId");
		session.putValue("customerId",customer);
		
		int customerId = Integer.parseInt(customer);
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		response.setContentType("text/html");

		try (PrintWriter out = response.getWriter()) {
			boolean result = cus.paymentLogin(customerId,name, password);

			if (result == true) {
				int reduce=fi.reduceQuantity(customerId);
				if(reduce>0) {
				or.insertOrder(customerId);
				ord.deleteOrderByCustomer(customerId);

				response.sendRedirect("PaymentCompleted.jsp");
				}else {
					RequestDispatcher rd = request.getRequestDispatcher("Payment.jsp?customerId="+customerId);
					rd.include(request, response);
					out.println("<center> <h3>ERROR</h3> </center>");
				}
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("Payment.jsp?customerId="+customerId);
				rd.include(request, response);
				out.println("<center> <h3>Incorrect Username and password</h3> </center>");
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
