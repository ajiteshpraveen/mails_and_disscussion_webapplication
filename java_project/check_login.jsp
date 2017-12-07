<%@ page import = "java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<title>CHATTING</title>	
<link rel="stylesheet" type="text/css" href="styles/check_login.css"  />
</head>
<body>
<%
String uname = request.getParameter("login_userid");
String upass = request.getParameter("login_password");
String name = "ajitesh";
String pass = "ajitesh56";
if(name.equals(uname) && pass.equals(upass))
	{
	out.println("<jsp:forward page='chatting.jsp' >");
}
else
	{
	response.sendRedirect("localhost:8080/java_project/login.jsp");
}
%>
</body>
</html>