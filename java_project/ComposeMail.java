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

public class ComposeMail extends HttpServlet
{
	protected void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException , IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		HttpSession session3 = req.getSession(false);
  		String from = (String)session3.getAttribute("uname");
		String send_person = req.getParameter("send_to");
		String sub = req.getParameter("subject");
		String data = new String(req.getParameter("mail_data"));
		ComposeMail_data obj = new ComposeMail_data();
		obj.setFrom(from);
		obj.setSend_person(send_person);
		obj.setSubject(sub);
		obj.setData(data);
		boolean status;
		status = obj.fill_data();
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