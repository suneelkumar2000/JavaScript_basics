package cys.food_order.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cys.food_order.dao.FoodItemImpl;
import cys.food_order.dao.OrderImpl;
import cys.food_order.model.FoodItem;
import cys.food_order.model.Order;

@WebServlet("/OrderTest")
public class OrderTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		OrderImpl or = new OrderImpl();
		Order order = new Order();
		FoodItemImpl fi = new FoodItemImpl();

		String foodId = request.getParameter("foodId");
		String quan = request.getParameter("quantity");
		String price = request.getParameter("price");
		int id = Integer.parseInt(foodId);
		int orderQuantity = Integer.parseInt(quan);
		int unitPrice=Integer.parseInt(price);

		
		PrintWriter out = response.getWriter();
		try {
			order.setFoodId(id);
			order.setQuantity(orderQuantity);

			int foodQuantity = fi.selectQuantity(id);
			if (foodQuantity > orderQuantity && 0<orderQuantity) {
				
				int newQuantity = foodQuantity - orderQuantity;
				fi.updateQuantity(id, newQuantity);
				or.insertOrder(order);
				int amount=unitPrice*orderQuantity;
				RequestDispatcher rd = request.getRequestDispatcher("Order.jsp");
				rd.include(request, response);
				out.println("<center>Ordered Successfully</center>");
				out.println("<center>Total Amount is "+amount+"</center>");
				out.println("<center><button><a href=\"Payment.jsp\">PAY</a></button></center>");
				

			} else if (foodQuantity == orderQuantity) {
			} else if (foodQuantity < orderQuantity){
				RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");
				rd.include(request, response);
				out.println("<center>Sorry Insufficient quantity</center>");
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");
				rd.include(request, response);
				out.println("<center>Sorry Wrong Input Please Check Again</center>");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
