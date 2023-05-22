<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Page</title>
<style>
#tab1 {
	margin-top: 20%;
	margin-left: 40%
}

body {
	background: linear-gradient(90deg, #6495ED, #87CEFA);
}
</style>
</head>
<body>
	<%
	String customerId = request.getParameter("customerId");
	String foodId = request.getParameter("foodId");
	String foodName = request.getParameter("name");
	String price = request.getParameter("price");
	String quantity = request.getParameter("quantity");
	session.putValue("customerId",customerId);
	session.putValue("foodId",foodId);
	%>
	<form action="OrderTest" method="get">
		
		<table id="tab1">
			<tr>
				<td>Food name:<input type="text" name="name"
					value=<%=foodName%> readonly></td>
			</tr>
			<tr>
				<td>Price :<input type="number" name="price" value=<%=price%>
					readonly></td>
			</tr>
			<tr>
				<td>Quantity:<input type="number" name="quantity"></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>