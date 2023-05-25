<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Foodies Index Page</title>
</head>
<style>
* {
	margin: 0;
	padding: 0;
	font-family: 'Poppins', sans-serif;
}

.container {
	height: 100vh;
	width: 100%;
	background: linear-gradient(90deg, #6495ED, #87CEFA);
	background-position: center;
	background-size: cover;
	padding-right: 5%;
	padding-left: 3%;
	box-sizing: border-box;
	position: relative;
}

.navbar {
	width: 100%;
	height: 15vh;
	margin: auto;
	display: flex;
	align-items: center;
}

.logo {
	font-size: 50px;
	color: #0F21BF;
	margin-top: 5px;
	font-family: 'Palette Mosaic', cursive;
	text-transform: uppercase;
	cursor: pointer;
}

nav {
	flex: 1;
	padding-left: 660px;
}

nav ul li {
	display: inline-block;
	list-style: none;
	margin: 0 15px;
}

nav ul li a {
	text-decoration: none;
	color: #fff;
	text-transform: uppercase;
	font-size: 15px;
	font-weight: 600;
}

nav ul li a:hover {
	color: #0F21BF;
	transition: all .5s;
}

.content {
	position: relative;
}

h1 {
	font-family: 'Lobster', cursive;
	text-transform: uppercase;
	font-weight: 800;
	margin-top: 100px;
	letter-spacing: .1em;
	font-size: 70px;
	color: #1b1b1b;
}

h1 .style {
	color: #eda134;
	font-size: 80px;
	font-weight: 800;
	font-family: 'Lobster', cursive;
}

.text {
	position: relative;
	display: flex;
	align-items: center;
}

.btn {
	background-color: #0F21BF;
	margin-top: 80px;
	padding: 15px 45px;
	border: none;
	outline: none;
	text-transform: uppercase;
	transition: .5s;
	cursor: pointer;
	font-weight: 700;
	font-size: 24px;
	display: block;
	border-radius: 30px;
	background-size: 200% auto;
	box-shadow: 3px 8px 22px rgba(22, 21, 21, .15);
}

.btn a {
	color: #fff;
	text-transform: uppercase;	
}

.social-media {
	font-family: 'Poppins', sans-serif;
	margin-top: 80px;
	margin-left: 50px;
	text-decoration: none;
	font-size: 27px;
}

.icons {
	color: #0F21BF;
	padding: 12px 12px 10px 12px;
	border-radius: 50%;
	background-color: #fff;
	margin-left: 10px;
	height: 27px;
	width: 27px;
	text-align: center;
	box-shadow: 3px 8px 22px rgba(22, 21, 21, .15);
}

.icons:hover {
	transform: scale(1.1);
	color: #fff;
	background-color: #0F21BF;
	transition: all .5s;
}
</style>
<body>
	<div class="container">
		<div class="navbar">
			<h3 class="logo">Foodies</h3>
			<nav>
				<ul>
					<li><a href="">Home</a></li>
					<li><a href="">Order</a></li>
					<li><a href="">Menu</a></li>
					<li><a href="">Contact Us</a></li>
					<li><a href="AdminloginPage.jsp">Admin</a></li>

				</ul>
			</nav>
		</div>
		<div class="content">
			<h1>
				The House of <br> <span class="style">Trendy Food</span>
			</h1>
			<div class="text">
				<button class="btn">
					<a href="CustomerloginPage.jsp">Login</a>
				</button>
				<div class="social-media">
					<a href=""><i class="fa icons fa-facebook"></i></a> <a href=""><i
						class="fa icons fa-instagram"></i></a> <a href=""><i
						class="fa icons fa-twitter"></i></a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>