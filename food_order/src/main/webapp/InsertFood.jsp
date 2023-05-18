<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Food Details</title>
<style>
body{
	margin-top:20%;
	margin-left:40%;
	background:linear-gradient(90deg,#6495ED,#87CEFA);
}
</style>
</head>
<body>
<form action="InsertFoodTest" method="get">
<table>
<tr><th>Food Name</th><td><input type="text" Name="name"></td></tr>
<tr><th>Price</th><td><input type="number" Name="price"></td></tr>
<tr><th>Quantity</th><td><input type="number" Name="quantity"></td></tr>
<tr><th>Category</th><td><input type="text" Name="itemCategory"></td></tr>
<tr><td><button><a href="AdminPage.jsp">back</a></button></td><td><input type="submit">	</td></tr>
</table>
</form>
</body>
</html>