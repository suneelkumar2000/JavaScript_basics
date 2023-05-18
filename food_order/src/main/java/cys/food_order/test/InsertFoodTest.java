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


@WebServlet("/InsertFoodTest")
public class InsertFoodTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InsertFoodTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		FoodItemImpl fi = new FoodItemImpl();
		FoodItem food = new FoodItem();
		
		String name=request.getParameter("name");
		String pr=request.getParameter("price");
		int price=Integer.parseInt(pr);
		String quant=request.getParameter("quantity");
		int quantity=Integer.parseInt(quant);
		String itemCategory=request.getParameter("itemCategory");
		response.setContentType("text/html");
		try (PrintWriter out=response.getWriter())
		{
			
			food.setName(name); 
			food.setUnitPrice(price);
			food.setQuantity(quantity);
			food.setItemCategory(itemCategory);
			int n = fi.insertFoodDetails(food);
			if(n>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("AdminPage.jsp");
				rd.include(request, response);
				out.println("<center>Successfully added</center>");
			}
			else
			{
				
				RequestDispatcher rd=request.getRequestDispatcher("InsertFood.jsp");
				rd.include(request, response);
				out.println("<center>Sorry Process Unsuccessfull</center>");
				
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
