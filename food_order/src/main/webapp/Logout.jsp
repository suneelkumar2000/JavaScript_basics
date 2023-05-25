<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout page</title>
<style>
body {
	margin: 0;
	padding: 0;
	font-family: montserrat;
	background: linear-gradient(90deg, #6495ED, #87CEFA);
	height: 100vh;
	overflow: hidden;
}

.center {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	width: 400px;
	background: white;
	border-radius: 10px;
}
.center h1 {
	text-align: center;
	padding: 0 0 20px 0;
	border-bottom: 1px solid silver;
	color: red;
}
</style>
</head>
<body>

	<div class="center">
			<h1>Confirm Logout</h1>
			<h3>
			<center>
				<button>
					<a href="Menu.jsp">back</a>
				</button>

				<button>
					<a href="Logout">Logout</a>
				</button>
				</center>
			</h3>
	</div>>
</body>
</html>