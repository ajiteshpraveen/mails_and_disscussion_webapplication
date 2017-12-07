import java.io.*;
import java.util.*;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class Email_search_data 
{
	private String from_database , find_person ;
	String going_out = "";
	public String getPerson()
	{
		return from_database;
	}
	public void setPerson(String from_database)
	{
		this.from_database = from_database;
	}

	public String getTo_find()
	{
		return find_person ;
	}
	public void setTo_find(String find_person)
	{
		this.find_person = find_person;
	}

	public String display_this()
	{
		String sql = "Select * from mails_"+from_database+" where name = '"+find_person+"'";
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
    		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Ajitesh56");
    		Statement st = conn.createStatement();
    		ResultSet rs = st.executeQuery(sql);
    		while(rs.next())
    		{
    			if(rs.getString("name") != null && rs.getString("subject") != null && rs.getString("file_location") != null)
    			{
    				going_out = going_out + "<tr><td>"+rs.getString("name")+"</td><td>"+rs.getString("subject")+"</td><td><form action = 'Open_file' method = 'POST'><button type = 'submit' name = 'submit' value = '"+rs.getString("file_location")+"'>Open</button></form></td></tr>";
    			}
    		}
    		rs.close();
    		st.close();
    		conn.close();
    	}
    	catch(Exception e)
    	{
    		going_out = "";
    	}
    	return going_out;
	}
}
