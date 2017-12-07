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

public class Open_file extends HttpServlet
{
	protected void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException , IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String f_loc = req.getParameter("mail_button");
		f_loc.toString();
		String path = "localhost:8080/java_project/user_mails/";
		int length = f_loc.length();
		Download_file download = new Download_file();
		download.setFileLocation(f_loc);
		String r_fname;
		r_fname = download.file_download();
		if(r_fname != null)
		{
			res.setContentType("APPLICATION/OCTET-STREAM");
			res.setHeader("Content-Disposition", "attachment; filename=/"+ r_fname + "/");
			FileInputStream fileInputStream = new FileInputStream(path + r_fname);
			int i;
			while ((i = fileInputStream.read()) != -1) 
			{
				out.write(i);
			}
			fileInputStream.close();
			out.close();
			RequestDispatcher rd=req.getRequestDispatcher("email.jsp");  
            rd.forward(req, res);
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("email.jsp");  
            rd.forward(req, res);
		}
	}
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)  throws ServletException, IOException 
    {  
        doPost(req, res);  
    }
}