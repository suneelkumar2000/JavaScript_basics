<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String price = request.getParameter("price");
	String quantity = request.getParameter("quantity");
	%>
	<form action="OrderTest" method="get">
		<table id="tab1">
			<tr>
				<td>Food ID:<input type="text" name="foodId" value=<%=id%> readonly></td>
			</tr>
			<tr>
				<td>Food name:<input type="text" name="name" value=<%=name%> readonly></td>
			</tr>
			<tr>
				<td>Price :<input type="number" name="price" value=<%=price%> readonly></td>
			</tr>
			<tr>
				<td>Quantity:<input type="number" name="quantity" value=<%=quantity%>></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>