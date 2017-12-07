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

public class LogOut extends HttpServlet
{
	protected void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException , IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		HttpSession sess=req.getSession(false);
  		String n=(String)sess.getAttribute("uname");
  		Logging_out lo = new Logging_out();
  		lo.setName(n);
  		boolean status;
  		status = lo.data_update();
  		if(status)
  		{
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");  
            rd.forward(req, res);
  		}
  		else
  		{
  			out.println("<center>THERE IS SOME PROBLEM WITH THE SERVER DATABASE CONNECTIVITY</center>");
  		}
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)  throws ServletException, IOException 
    {  
        doPost(req, res);  
    }
}