<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="./styles/login.css">
</head>
<body>
<center>
	<h1>Login Page</h1>
	<div class="login">
<form action = "LoginController" method = "post" >
<table>
<tr>
<td><b>USER ID :</b></td>
<td><input type = "text" name = "login_userid"/></td>
</tr>
<tr>
<td><b>PASSOWRD :</b></td>
<td><input class="pass" type = "password" name = "login_password" /></td>
</tr>
</table>
<button type = "submit" name = "login_button">LOGIN</button>
</form>
</div>
</center>
</body>
</html>