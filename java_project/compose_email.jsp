<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.Connection"%> 
<%@page import="java.sql.DriverManager"%> 
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
	<title>Compose Mail</title>
	<link rel="stylesheet" type="text/css" href="styles/email.css"  />
</head>
<body>
	<center>
		<h2>COMPOSE MAIL</h2><form action = "LogOut" method = "POST" id = "LogOut"><button class="logout" type = "submit" name = "logout" value = "logout">LOG OUT</button> </form>
		<br /><br /><br />
		<label><h2>From :  <%
					HttpSession session2=request.getSession(false);
					String n2=(String)session2.getAttribute("uname");
					out.println(n2); %>
		</h2></label>
	</center>
		<div class="layout">
		<div class="article">
		<form action = "ComposeMail" method = "POST">
			<h4>To :</h4><input type = "text" name = "send_to" id = "send_to" /><br /><br />
			<h4>Subject :</h4><input type = "text" name = "subject" id = "subject" /><br /><br />
			<h4>Write Here</h4><br />
			<textarea name = "mail_data" id = "mail_data" cols="60" rows = "20" ></textarea><br />
			<button type = "submit" name = "send_mail_text" id = "send_mail_text">Compose Mail</button><br /><br />
		</form><br />
		<br /></div>
		<div class="nav">
		<form action = "ComposeMail_file" method = "POST" enctype="multipart/form-data">
			<h4>To :</h4><input type = "text" name = "send_to_file" id =  "send_to_file" ><br /><br />
			<h4>Subject :</h4><input type = "text" name = "subject_file" id = "subject_file" /><br /><br />
			<h4>File Name With Extension :</h4><input type = "text" name = "file_name" id = "file_name" /><br /><br /></br>
			<h4>Select File :</h4><input type = "file" name = "file_upload" id = "file_upload"><br /><br /></br>
			<button class="compose" type = "submit" name = "submit" id = "submit">Send</button><br /><br />
		</form>
	</div>
</div>

</body>
</html>