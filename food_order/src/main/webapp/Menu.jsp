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

.user-pic {
	width: 40px;
	border-radius: 50%;
	cursor: pointer;
	margin-left: 95%;
}

.sub-menu-wrap {
	position: absolute;
	top: 100%;
	right: 1%;
	width: 250px;
	border-radius: 20%;
	max-height: 0px;
	overflow: hidden;
	transition: max-height 0.5s;
}

.sub-menu-wrap.open-menu {
	max-height: 400px;
}

.sub-menu {
	background: rgb(250, 250, 250);
	padding: 20px;
	margin: 10px;
}

.user-info {
	display: flex;
	align-items: center;
}

.user-info h3 {
	font-weight: 500;
	font-size: 20px;
}

.user-info img {
	width: 60px;
	border-radius: 50%;
	margin-right: 15px;
}

.sub-menu-link {
	display: flex;
	align-items: center;
	text-decoration: none;
	color: #FF0303;
	margin: 12px 0;
}

.sub-menu-link p {
	width: 100%;
}

.sub-menu-link span {
	font-size: 22px;
	transition: transform 0.5s;
}

.sub-menu-link:hover span {
	transform: translateX(5px);
}

.sub-menu-link:hover p {
	transform: translateX(5px);
	font-weight: 600;
}
</style>
</head>
<body>
	<nav>
		<div class="navbar-brand">Foodies App</div>
		<div class="image">
			<img src="{% # %}" class="user-pic" onclick="tooglemenu()">
			<div class="sub-menu-wrap" id="submenu">
				<div class="sub-menu">
					<div class="user-info">
						<img src="{% # %}">
						<%
						String userName = (String) session.getValue("userName");
						String customerId = (String) session.getValue("customerId");
						String email = (String) session.getValue("email");
						%>
						<h3><%=userName%></h3>
					</div>
					<%=email%>
					<hr>
					<a href="Index.jsp" class="sub-menu-link">
						<p>logout</p> <span>></span>
					</a>
				</div>
			</div>
		</div>
	</nav>
	<script>
		let submenu = document.getElementById("submenu");
		function tooglemenu() {
			submenu.classList.toggle("open-menu");
		}
	</script>

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
						<th>Food Name</th>
						<th>Price</th>
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
						<td><%=name%></td>
						<td><%=price%></td>
						<td><%=category%></td>

						<td><button>
								<a
									href="Order.jsp?foodId=<%=id%>&name=<%=name%>&price=<%=price%>&quantity=<%=quantity%>&category=<%=category%>&customerId=<%=customerId%>">select</a>
							</button></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
			<center>
				<h3>
					<button>
						<a href="Cart.jsp?customerId=<%=customerId%>">View Cart</a>
					</button>
				</h3>
			</center>
		</div>
	</div>
</body>
</html>






