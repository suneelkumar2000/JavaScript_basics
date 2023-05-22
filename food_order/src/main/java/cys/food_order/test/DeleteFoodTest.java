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

@WebServlet("/DeleteFoodTest")
public class DeleteFoodTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteFoodTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		FoodItemImpl fi = new FoodItemImpl();
		
		String i=request.getParameter("id");
		int id=Integer.parseInt(i);
		response.setContentType("text/html");
		try (PrintWriter out=response.getWriter())
		{
			
			int n = fi.deleteFoodDetails(id);
			if(n>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("AdminPage.jsp");
				rd.include(request, response);
				out.println("<center><h3>Successfully deleted</h3></center>");
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("AdminPage.jsp");
				rd.include(request, response);	
				out.println("<center><h3>process unsuccessfull</h3></center>");
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
