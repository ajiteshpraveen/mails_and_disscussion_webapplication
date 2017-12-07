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

public class LoginController extends HttpServlet
{
	protected void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException , IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String user_name = req.getParameter("login_userid");
		String user_password = req.getParameter("login_password");
		LoginData log = new LoginData();
		log.setName(user_name);
		log.setPassword(user_password);
		boolean status = log.validate();
		if(status)
		{
			HttpSession session=req.getSession();
			session.setAttribute("uname",user_name);
			RequestDispatcher rd=req.getRequestDispatcher("disscussion_room.jsp");  
            rd.forward(req, res);
		}
		else
		{  
            RequestDispatcher rd=req.getRequestDispatcher("login.jsp");  
            rd.forward(req, res);  
        } 
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)  throws ServletException, IOException 
    {  
        doPost(req, res);  
    }
}
