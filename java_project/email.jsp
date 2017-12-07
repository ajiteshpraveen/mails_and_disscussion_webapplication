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
<title>EMAIL</title>
<link rel="stylesheet" type="text/css" href="styles/back.css"">
</head>
<body>
<%
	HttpSession session1=request.getSession(false);
	String n1=(String)session1.getAttribute("uname");
%>
<center>
<h1><%= "Welcome  " + n1 %></h1><form action = "LogOut" method = "POST" id = "LogOut"><button class="logout1"  type = "submit" name = "logout" value = "logout">LOG OUT</button> </form><br /><br />
<hr><br>
<table>
	<tr>
		<td>
			<button type = "submit" name = "submit" id = "submit" value = "submit" onclick="document.location.reload(true)">Reload</button>
		</td>
		<td>
			<form action = "Email_search" method = "POST">
				<input type = "text" name = "email_search_value" id = "email_search_value" placeholder = "Enter keyword" /><button type = "submit" id = "submit" value = "submit" name = "submit">Search</button>
			</form>
		</td>
		<td><a href = "./compose_email.jsp"><h2><b>Compose</h2></b></a></td><% // convert this href to look like a button in css %>
	</tr>
</table><br /><br />
</center>
<div class = "mails_output">
	<p name = "mails_output" id = "mails_output">
		<table name = "mail_output_table" id = "mail_output_table">
			<%
				String table_name = "mails_" + n1;
				String sql = "Select * from " + table_name;
				try
				{
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Ajitesh56");
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery(sql);
					while(rs.next())
					{
						String senders_name = rs.getString("name");
						String subject = rs.getString("subject");
						String file_loc = rs.getString("file_location");
						out.print("<tr><td id = 'table_td'>"+senders_name+"</td><td id = 'table_td'>"+subject+"</td><td id = 'table_td'><form action = 'Open_file' method = 'POST'><button type='submit' name='mail_button' value="+file_loc+" >Open</button></form></td></tr>");
					}
				}
				catch(Exception e)
				{
					out.println("SOMETHING IS WRONG WITH THE SERVER");
				}
			%>
		</table>
	</p>
	<hr>
</div>
</body>
</html>