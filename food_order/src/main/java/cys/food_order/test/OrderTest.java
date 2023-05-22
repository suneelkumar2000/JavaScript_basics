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

		HttpSession session = request.getSession(true);
		String cusId = (String) session.getValue("customerId");
		String food = (String) session.getValue("foodId");
		String quantity = request.getParameter("quantity");
		String price = request.getParameter("price");

		int customerId = Integer.parseInt(cusId);
		int foodId = Integer.parseInt(food);
		int orderQuantity = Integer.parseInt(quantity);
		int unitPrice = Integer.parseInt(price);

		PrintWriter out = response.getWriter();
		try {
			order.setCustomerId(customerId);
			order.setFoodId(foodId);
			order.setQuantity(orderQuantity);
			int amount = unitPrice * orderQuantity;
			order.setAmount(amount);
			int foodQuantity = fi.selectQuantity(foodId);

			if ((foodQuantity > orderQuantity && 0 < orderQuantity) || (foodQuantity == orderQuantity)) {
				int foodid = or.findFoodId(customerId);

				if (foodid == foodId) {
					int oldQuantity = or.selectQuantity(foodId);
					int totalQuantity = oldQuantity + orderQuantity;
					or.updateOrderQuantity(foodId, totalQuantity);

					int newQuantity = or.selectQuantity(foodId);
					int newAmount = unitPrice * newQuantity;
					or.updateAmount(newAmount, foodId);

					RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");
					rd.include(request, response);
					out.println("<center><h3>Ordered Successfully</h3></center>");
				} else if(foodid != foodId){
					or.insertOrder(order);

					RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");
					rd.include(request, response);
					out.println("<center><h3>Ordered Successfully</h3></center>");
				}
			} else if (foodQuantity < orderQuantity) {
				RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");
				rd.include(request, response);
				out.println("<center><h3>Sorry Insufficient quantity</h3></center>");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");
				rd.include(request, response);
				out.println("<center><h3>Sorry Wrong Input Please Check Again</h3></center>");
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
