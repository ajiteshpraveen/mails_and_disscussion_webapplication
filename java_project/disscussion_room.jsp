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


<html>
<head><title>Disscussion Room</title>
<link rel="stylesheet" type="text/css" href="styles/discuss.css"  />
</head>
<body>
	<div class"body">
  <%
  		HttpSession sess=request.getSession(false);
  		String n=(String)sess.getAttribute("uname");
  	%>
  	<% 	
	  	Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Ajitesh56");
		Statement st = conn.createStatement();
		try
		{
			String sql = "Select status from login_details where name = '"+n+"'";
			ResultSet rs = st.executeQuery(sql);
			int status = 0;
			while(rs.next())
			{
				status = (int)rs.getInt("status");
			}
			rs.close();
			st.close();
		}
		catch(Exception e)
		{
			out.println(e);
		}
		
	 %>	<center>
		<h1>WELCOME <%=n%> </h1><table><td>
		<form class="mail" action = "To_mail" method = "POST" id = "To_mail">
			<button class="logout" type = "submit" name = "mail" value = "mail">MAIL</button> 
		</form></<td><td>
		<form  action = "LogOut" method = "POST" id = "LogOut">
			<button class="logout1" type = "submit" name = "logout" value = "logout">LOG OUT</button> 
		</form></td></table></td></center>
		<h2>DISSCUSSION FORUM</h1><br /><br />
		<div class="Disscussion">
		<p id = "message" name = "message">
			<%
				String na;
				String ms;
				Statement st3 = conn.createStatement();
				String sql3 = "Select * from disscussion_table";
				try
				{
					ResultSet rs2 = st3.executeQuery(sql3);
					while(rs2.next())
					{
						na = rs2.getString("name");
						ms = rs2.getString("message");
						String display = na + " : " + ms + "<br />";
						out.println(display);
					}
					rs2.close();
				}
				catch(Exception e)
				{
					out.println(e);
				}
				st3.close();
				conn.close();
			%>
		</div>
		</p><br /><br /> 
		<center>
		<form action = "InsertData" method = "POST" name = "chatting_data">
			<input class="InsertData" type = "text" name = "comment" id = "comment" placeholder = "Enter here"><br /><br />
			<table>
				<td>
			<button class="sub" type = "submit" name = "send" value = "send">Send</button></td><td>  
		</form><button class="ref" type="button" name="refresh" onclick="document.location.reload(true)">Refresh</button></td></table>
	</center>
		<%
		/*
			try
			{
				String b = (String)request.getParameter("send");
				String chat = (String)request.getParameter("comment");
				if(b.equals("send"))
				{
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection conn6 = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Ajitesh56");
					Statement st6 = conn6.createStatement();
					String sql6 = "insert into disscussion_table(name,message)values('"+n+"','"+chat+"')";
					int ecv = st6.executeUpdate(sql6);
					st6.close();
					conn6.close();
				}
				insertion.Insert_chat_data obj = new insertion.Insert_chat_data();
				obj.insert(n,chat);
			}
			catch(Exception ax)
			{
				ax.printStackTrace();
			}
			*/
		%>
</div>
</body>
</html>