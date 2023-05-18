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
import cys.food_order.model.FoodItem;

@WebServlet("/UpdateFoodTest")
public class UpdateFoodTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateFoodTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		FoodItemImpl fi = new FoodItemImpl();
		
		String i=request.getParameter("id");
		int id=Integer.parseInt(i);
		String name=request.getParameter("name");
		String pr=request.getParameter("price");
		int price=Integer.parseInt(pr);
		String quant=request.getParameter("quantity");
		int quantity=Integer.parseInt(quant);
		String itemCategory=request.getParameter("category");
		try (PrintWriter out=response.getWriter())
		{
			int q = fi.updateQuantity(id,quantity);
			int p = fi.updatePrice(id,price);
			int c = fi.updateCategory(id,itemCategory);
			
			if(q>0 && p>0 && c>0) {
				RequestDispatcher rd=request.getRequestDispatcher("AdminPage.jsp");
				rd.include(request, response);
				out.println("<center>Updated Successfully</center>");
			}else {
				RequestDispatcher rd=request.getRequestDispatcher("UpdateFoodList.jsp");
				rd.include(request, response);
				out.println("<center>Updated UnSuccessfully</center>");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
