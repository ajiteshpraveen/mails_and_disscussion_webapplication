import java.io.*;
import java.util.*;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class Logging_out 
{
	private String name;
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	boolean status;
	public boolean data_update()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
        	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Ajitesh56");
        	Statement st = conn.createStatement();
        	String sql;    	   	
			sql = "Update login_details set status = 0 where name = '"+name+"'";
			int a = st.executeUpdate(sql);
			status = true;
			st.close();
        	conn.close();
	   	}
		catch(Exception ex)
		{
			status = false;
		}
		return status;
	}
		
	
}
