import java.io.*;
import java.util.*;
import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.*;  
import javax.servlet.http.*;
import com.oreilly.servlet.MultipartRequest;

public class ComposeMail_file extends HttpServlet
{
	protected void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException , IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String name = req.getParameter("send_to_file");
		String subject = req.getParameter("subject_file");
		String file_name = req.getParameter("file_name");
		ComposeMail_file_data obj = new ComposeMail_file_data();
		obj.setName(name);
		obj.setSubject(subject);
		obj.setFileName(file_name);
		MultipartRequest m = new MultipartRequest(req,"C:/xampp/tomcat/webapps/java_project/user_mails");
		boolean status;
		status = obj.enter_data();
		if(status)
		{
			RequestDispatcher rd=req.getRequestDispatcher("email.jsp");  
            rd.forward(req, res);
		}
		else
		{
			out.println("SOMETHING WENT WRONG");
		}
	}
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)  throws ServletException, IOException 
    {  
        doPost(req, res);  
    }
}