<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Completed page</title>
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
	color: #12BB34;
}

.center form {
	padding: 0 40px;
	box-sizing: border-box;
}

form .txt_field {
	position: relative;
	border-bottom: 2px solid #adadad;
	margin: 30px 0;
}

.txt_field input {
	width: 100%;
	padding: 0 5px;
	height: 40px;
	font-size: 16px;
	border: none;
	background: none;
	outline: none;
}

.txt_field label {
	position: absolute;
	top: 50%;
	left: 5px;
	color: #adadad;
	transform: translateY(-50%);
	font-size: 16px;
	pointer-events: none;
	transition: .5s;
}

.txt_field span::before {
	content: '';
	position: absolute;
	top: 40px;
	left: 0;
	width: 0%;
	height: 2px;
	background: #2691d9;
	transition: .5s;
}

.txt_field input:focus ~ label, .txt_field input:valid ~ label {
	top: -5px;
	color: #2691d9;
}

.txt_field input:focus ~ span::before, .txt_field input:valid ~ span::before
	{
	width: 100%;
}

.pass {
	margin: -5px 0 20px 5px;
	color: #a6a6a6;
	cursor: pointer;
}

.pass:hover {
	text-decoration: underline;
}

button {
	width: 80%;
	height: 50px;
	border: 1px solid;
	background: #ADC9C2;
	border-radius: 25px;
	font-size: 18px;
	color: white;
	font-weight: 700;
	cursor: pointer;
	outline: none;
}

button:hover {
	border-color: #2691d9;
	transition: .5s;
}

.signup_link {
	margin: 30px 0;
	text-align: center;
	font-size: 16px;
	color: #666666;
}
.signup_link a{
color: #2691d9;
text-decoration: none;
}
.signup_link a:hover{
text-decoration: underline;}
</style>
</head>
<body>
	<div class="center">
		<h1>PAYMENT SUCESSFULLY COMPLETED</h1>
			<center><div class="pass">THANK YOU , YOUR ORDER IS ON THE WAY</div>
			<button><a href="Menu.jsp">Back to Menu</a></button></center>
			<div class="signup_link">
				<a href="Index.jsp">Logout</a>
			</div>
		</form>
	</div>
</body>
</html>