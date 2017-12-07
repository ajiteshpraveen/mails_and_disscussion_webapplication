import java.io.*;
import java.util.*;
import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 


public class RegisterController extends HttpServlet
{
	
	protected void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException , IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String register_name = (String)req.getParameter("register_name");
		String register_password = (String)req.getParameter("register_password");
		String register_repassword = (String)req.getParameter("register_re_password");
		String register_employee = (String)req.getParameter("register_employee_id");
		RegisterData bean = new RegisterData();
		bean.setRegName(register_name);
		bean.setRegPassword(register_password);
		bean.setRegRePassword(register_repassword);
		bean.setRegEmployee(register_employee);
		req.setAttribute("bean",bean);
		boolean status;
		status = bean.register();
		if(status)
		{
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");  
            rd.forward(req, res);
		}
		else
		{  
            RequestDispatcher rd=req.getRequestDispatcher("register.jsp");  
            rd.forward(req, res);
              
        } 
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)  throws ServletException, IOException 
    {  
        doPost(req, res);  
    }
}
