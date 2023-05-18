<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" import="cys.food_order.util.ConnectionUtil"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<nav class="navbar navbar-expand-md navbar-dark"
	style="background-color: #0F21BF">
	<div>
		<a href="https://www.javaguides.net" class="navbar-brand"> Foodies
			App </a>
	</div>
</nav>
<style>
body {
	background: linear-gradient(90deg, #6495ED, #87CEFA);
}

button{
background: #080808;
color: #fff;
}
</style>
</head>
<body>

	<header> </header>
	<br>

	<div class="row">

		<div class="container">
			<h3 class="text-center">Food Menu</h3>
			<hr>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Food ID</th>
						<th>Food Name</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Category</th>
					</tr>
				</thead>
				<tbody>


					<%
					
					Connection con = ConnectionUtil.getConnection();
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("select id,name,quantity,unit_price,item_category from fooditem");
					while (rs.next()) {
						int id = rs.getInt(1);
						String name = rs.getString(2);
						int quantity = rs.getInt(3);
						int price = rs.getInt(4);
						String category = rs.getString(5);
					%>
					<tr>
						<td><%=id%></td>
						<td><%=name%></td>
						<td><%=price%></td>
						<td><%=quantity%></td>
						<td><%=category%></td>

						<td><button><a href="Order.jsp?id=<%=id%>&name=<%=name%>&price=<%=price%>&quantity=<%=quantity%>&category=<%=category%>">select</a></button></td>
					</tr>
					<%
					}
					String customerId = request.getParameter("name");
					%>
				</tbody>

			</table>
			<button>
				<a href="Index.jsp">logout</a>
			</button>
			customer Id is <%=customerId%>
		</div>
	</div>
</body>
</html>






