<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" import="cys.food_order.util.ConnectionUtil"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
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

	<ul class="navbar-nav">
		<li><a href="AdminRegisterPage.jsp">New Admin</a></li>
	</ul>
</nav>
<style>
body {
	background: linear-gradient(90deg, #6495ED, #87CEFA);
}

.add {
	width: 20%;
	border: 1px solid;
	background: #080808;
	border-radius: 25px;
	font-size: 5px;
	color: #e9f4fb;
	font-weight: 50;
	cursor: pointer;
	outline: none;
}

button {
	background: #080808;
}

button:hover {
	background: #E57E08;
}

table td {
	background-color: #DBD9E3;
}

table th {
	color: #fff;
	background-color: #0F21BF;
}

button a {
	color: #fff;
}

button a:hover {
	color: #fff;
}
</style>
</head>
<body>

	<header> </header>
	<br>

	<div class="row">

		<div class="container">
			<h3 class="text-center">List of Foods</h3>
			<hr>
			<div class="add">
				<h4 class="text-center">
					<a href="InsertFood.jsp">Add New Food</a>
				</h4>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Food Name</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Category</th>
						<th></th>
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
						<td><%=name%></td>
						<td><%=price%></td>
						<td><%=quantity%></td>
						<td><%=category%></td>

						<td><center>
								<button>
									<a
										href="UpdatePage.jsp?id=<%=id%>&name=<%=name%>&price=<%=price%>&quantity=<%=quantity%>&category=<%=category%>">update</a>
								</button>
								&nbsp;&nbsp;&nbsp;&nbsp;

								<button class=delete>
									<a href="DeleteFoodTest?id=<%=id%>">Delete</a>
								</button>

							</center></td>
					</tr>
					<%
					}
					%>
				</tbody>

			</table>
			<button>
				<a href="Index.jsp">logout</a>
			</button>
		</div>
	</div>
</body>
</html>