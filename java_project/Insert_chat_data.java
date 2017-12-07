import java.io.*;
import java.util.*;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class Insert_chat_data
{

	private String name , message;
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;	
	}
	boolean status;
	public boolean insert()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Ajitesh56");
			Statement st = conn.createStatement();
			String sql = "insert into disscussion_table(name,message)values('"+name+"','"+message+"')";
			int c = st.executeUpdate(sql);
			st.close();
			conn.close();
		}
		catch(Exception ax)
		{}
		return status;
	}
	
}