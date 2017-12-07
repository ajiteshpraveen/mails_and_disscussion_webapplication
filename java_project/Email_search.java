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


public class Email_search extends HttpServlet
{
	
	protected void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException , IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		HttpSession session5=req.getSession(false);
		String n2=(String)session5.getAttribute("uname");
		String to_find = (String)req.getParameter("email_search_value");
		Email_search_data obj = new Email_search_data();
		obj.setPerson(n2);
		obj.setTo_find(to_find);
		String to_print = obj.display_this();
		String to_print2 = "<!DOCTYPE><html><head><title>Email Search</title><link rel='stylesheet' type='text/css' href='./styles/Email_search.css' /></title></head><body>";
		if(to_print != null)
		{
			to_print2 = to_print2 + "<center><table><tr><th>Name</th><th>Subject</th><th>Email</th></tr>" + to_print + "</table></body></center></body></html>";
		}
		else 
		{
			to_print2 = to_print2 + "<center><h4>NO SUCH EMAILS WITH THAT NAME FOUND</h4></center></body></html>";	
		}
		out.println(to_print2);
	}

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)  throws ServletException, IOException 
    {  
        doPost(req, res);  
    }
}
