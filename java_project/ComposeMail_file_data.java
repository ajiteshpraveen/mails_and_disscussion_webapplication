import java.io.*;
import java.util.*;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class ComposeMail_file_data
{
	String name , subject , file_name;

	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}

	public String getSubject()
	{
		return subject;
	}
	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	public String getFileName()
	{
		return file_name;
	}
	public void setFileName(String file_name)
	{
		this.file_name = file_name;
	}

	boolean status;
	public boolean enter_data()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String file_location = "localhost:8080/java_project/user_mails/"+file_name;
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Ajitesh56");
			PreparedStatement stmt=conn.prepareStatement("insert into mails_"+name+" values(?,?,?)");			
			stmt.setString(1,name);
			stmt.setString(2,subject);
			stmt.setString(3,file_location);
			int a = stmt.executeUpdate();
			stmt.close();
			conn.close();
			status = true;
		}
		catch(Exception e)
		{
			status = false;
		}
		return status;
	}
}