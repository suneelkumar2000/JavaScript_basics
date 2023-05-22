package cys.food_order.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cys.food_order.dao.OrderImpl;

@WebServlet("/DeleteCartTest")
public class DeleteCartTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteCartTest() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		OrderImpl or = new OrderImpl();
		
		String i=request.getParameter("orderId");
		int id=Integer.parseInt(i);
		response.setContentType("text/html");
		try (PrintWriter out=response.getWriter())
		{
			
			int n = or.deleteOrder(id);
			if(n>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("Cart.jsp");
				rd.include(request, response);
				out.println("<center><h3>Successfully Removed</h3></center>");
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("Cart.jsp");
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
