import java.io.*;
import java.util.*;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class LoginData 
{
	private String name , password;
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;	
	}
	boolean status;
	public boolean validate()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
        	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Ajitesh56");
        	Statement st = conn.createStatement();
        	Statement st2 = conn.createStatement();
        	String sql , sql2;
        	sql = "select employee_name,employee_password from employee_details where employee_name ='"+name+"' and employee_password ='"+password+"'";
    	   	ResultSet rs = st.executeQuery(sql);
    	   	while(rs.next())
    	   	{
    	   		String na = (String)rs.getString("employee_name");
    	   		String pass = (String)rs.getString("employee_password");
   				if(na.equals(name) && pass.equals(password))
   				{
   					status = true;
   					sql2 = "Update login_details set status = 1 where name = '"+name+"'";
   					int a = st2.executeUpdate(sql2);
   				}
   				else
   				{
   					status = false;
   				}
    	   	}
        	st.close();
        	st2.close();
        	conn.close();
			rs.close();
		}
		catch(Exception ex)
		{
			status = false;
		}
		return status;
	}
}
