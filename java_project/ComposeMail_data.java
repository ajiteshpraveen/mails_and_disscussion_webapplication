import java.io.*;
import java.util.*;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ComposeMail_data
{
	String from , sender , subject ; 
	String data ;
	public String getFrom()
	{
		return from;
	}
	public void setFrom(String from)
	{
		this.from = from;
	}

	public String getSend_person()
	{
		return sender;
	}
	public void setSend_person(String sender)
	{
		this.sender = sender;
	}

	public String getSubject()
	{
		return subject;
	}
	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	public String getData()
	{
		return data;
	}
	public void setData(String data)
	{
		this.data = data;
	}
	boolean status;
	public boolean fill_data()
	{
		try
		{
			int loc = (new String(data)).indexOf('\n');
			int no = 0;
			String sql = "Select file_no from mail_files where name = '"+sender+"'";
		
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Ajitesh56");
			Statement st = conn.createStatement();
			Statement st2 = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				no = (int)rs.getInt("file_no");
			}
			no = no + 1;
			String path = "localhost:8080/java_project/user_mails/text"+no+".txt";
			String path2 = "C:/xampp/tomcat/webapps/java_project/user_mails/text"+no+".txt";
			String sql2 = "Update mail_files set file_no ="+no+" where name = '"+sender+"'";
			String sql4 = "insert into mails_"+sender+"(name,subject,file_location)values('"+from+"','"+subject+"','"+path+"')";
			int b = st2.executeUpdate(sql4);
			int a = st.executeUpdate(sql2);
			st.close();
			st2.close();
			rs.close();
			conn.close();
			status = true;
		
			while(loc > 0)
			{
			
				BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path2), true));
				bw.write(data);
				bw.newLine();
				bw.close();

			}
			status = true;
			
		}
				
		catch(Exception e)
		{
			status = false;
		}
	
		return status;
	}
}