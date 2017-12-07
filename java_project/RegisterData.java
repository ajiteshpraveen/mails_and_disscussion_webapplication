import java.io.*;
import java.util.*;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class RegisterData 
{
	private String regname , regpassword , regrepassword ;
	private String regempid;

	public String getName()
	{
		return regname;
	}
	public void setRegName(String rname)
	{
		this.regname = rname;
	}
	public String getRegPassword()
	{
		return regpassword;
	}
	public void setRegPassword(String rpassword)
	{
		this.regpassword = rpassword;	
	}

	public String getRegRePassword()
	{
		return regrepassword;
	}

	public void setRegRePassword(String repassword)
	{
		this.regrepassword = repassword;
	}

	public String getRegEmpid()
	{
		return regempid;
	}

	public void setRegEmployee(String regemp)
	{
		this.regempid = regemp;
	}
	boolean status;
	public boolean register()
	{
		try
		{

			String sql = "create table mails_"+regname+"(name VARCHAR(20),subject VARCHAR(20),file_location VARCHAR(100))";
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
        	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Ajitesh56");
        	PreparedStatement st = conn.prepareStatement("insert into employee_details(employee_name,employee_password,employee_id)values(?,?,?)");
        	PreparedStatement st2 = conn.prepareStatement("insert into login_details(name,status)values(?,?)");
        	PreparedStatement st3 = conn.prepareStatement("insert into mail_files(name,file_no)values(?,?)");
        	Statement sst = conn.createStatement();
        	st.setString(1,regname);
        	st.setString(2,regpassword);
        	st.setString(3,regempid);
        	st2.setString(1,regname);
        	st2.setInt(2,0);   
        	st3.setString(1,regname);
        	st3.setInt(2,0);
        	int i = st.executeUpdate();
        	int i2 = st2.executeUpdate();
        	int i3 = st3.executeUpdate();
        	sst.executeUpdate(sql); 
        	st.close();
        	sst.close();
        	st3.close();
        	st2.close();
        	conn.close();
            status = true;
		} 
		catch (Exception ex) 
		{
			status = false;
            	
		}
		return status;
	}
}
