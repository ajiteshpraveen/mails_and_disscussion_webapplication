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

public class To_mail extends HttpServlet
{
	protected void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException , IOException
	{
		res.setContentType("text/html");
		RequestDispatcher rd=req.getRequestDispatcher("email.jsp");  
        rd.forward(req, res);
    }
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)  throws ServletException, IOException 
    {  
        doPost(req, res);  
    }
}
