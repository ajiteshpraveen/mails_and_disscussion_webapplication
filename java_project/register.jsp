<!DOCTYPE html>
<html>
<head>
<title>Register</title>
<link rel="stylesheet" type="text/css" href="styles/register.css"/>
</head>
<body><center>
<h1> REGISTER</h1>
<b>
<form  action = "RegisterController" method = "POST" enctype = "text/html">
<table>
<tr>
<td>NAME :</td>
<td><input type = "text" name = "register_name"></td>
</tr>
<tr>
<td>PASSWORD :</td>
<td><input type = "password" name = "register_password"></td>
</tr>
<tr>
<td>RE-ENTER-PASSWORD :</td>
<td><input type = "password" name = "register_re_password"></td>
</tr>
<tr>
<td>EMPLOYEE-ID :</td>
<td><input type = "text" name = "register_employee_id"></td>
</tr>
</table><br>
<button type = "submit" value = "upload">SIGN-UP</button>


</form>
</b>
</center>
</body>
</html>