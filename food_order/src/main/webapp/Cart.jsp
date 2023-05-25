<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" import="cys.food_order.util.ConnectionUtil"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<style>
body {
	background: linear-gradient(90deg, #6495ED, #87CEFA);
}

button {
	background: #080808;
	color: #fff;
}

.navbar-brand {
	color: #fff;
	margin-right: 10%;
}

.navbar-brand a {
	color: #fff;
	margin-right: 50%;
}

nav {
	background: #0F21BF;
	width: 100%;
	padding: 10px 10%;
	display: flex;
	align-items: center;
	justify-content: space-between;
	position: relative;
}
table td{
background-color: #DBD9E3;
}
table th{
color: #fff;
background-color: #0F21BF;
}
</style>
</head>
<body>
	<%
	String customerId = request.getParameter("customerId");
	session.putValue("customerId", customerId);
	int customer = Integer.parseInt(customerId);
	%>
	<nav>
		<div>
			<div class="navbar-brand">
				<a href="Menu.jsp?customerId=<%=customer%>"> < Back </a>Foodies
				App
			</div>
		</div>
	</nav>
	<header> </header>
	<br>

	<div class="row">

		<div class="container">

			<h3 class="text-center">MY CART</h3>
			<hr>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Food Name</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Amount</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<%
					Connection con = ConnectionUtil.getConnection();
					String select = "select id,food_id,quantity,amount from Orders where customer_id=?";
					PreparedStatement ps = con.prepareStatement(select);
					ps.setInt(1, customer);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						int id = rs.getInt(1);
						int foodId = rs.getInt(2);
						int quantity = rs.getInt(3);
						int amount = rs.getInt(4);

						String find = "select name,unit_price from fooditem where id=?";
						PreparedStatement ps1 = con.prepareStatement(find);
						ps1.setInt(1, foodId);
						ResultSet rs1 = ps1.executeQuery();
						while (rs1.next()) {
							String name = rs1.getString(1);
							int price = rs1.getInt(2);
					%>
					<tr>
						<td><%=name%></td>
						<td>Rs.<%=price%></td>
						<td><%=quantity%></td>
						<td>Rs.<%=amount%></td>
						<td><button>
								<a href="DeleteCartTest?orderId=<%=id%>&customerId=<%=customer%>">remove</a>
							</button></td>
					</tr>
					<%
					}
					}
					%>
				</tbody>
			</table>
			<%
			Statement stmt = con.createStatement();
			ResultSet rs1 = stmt
					.executeQuery("select SUM(amount) as Total_amount FROM Orders where customer_id='" + customer + "'");
			while (rs1.next()) {
				int total = rs1.getInt(1);
			%>
			<tr>
				<h5>
					TOTAL AMOUNT : Rs.<%=total%></h5>
			</tr>
			<button>
				<a href="Payment.jsp?customerId=<%=customerId%>&total=<%=total%>">Payment</a>
			</button>
			<%
			}
			%>

		</div>
	</div>
</body>
</html>