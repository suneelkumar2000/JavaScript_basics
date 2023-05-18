<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Register Page</title>
<style>
#tab1{
	margin-top:20%;
	margin-left:40%
}	
body
{
	background:linear-gradient(90deg,#6495ED,#87CEFA);
}
</style>
</head>
<body>
<form action="CustomerRegisterTest" method="get">
<table id="tab1">
	<tr><td>Admin name:<input type="text" name="name"></td></tr>
	<tr><td>user name:<input type="number" name="mobile"></td></tr>
	<tr><td>password :<input type="password" name="password"></td></tr>
	<tr><td><input type="submit"></td></tr>
</table>
</form>
</body>
</html>