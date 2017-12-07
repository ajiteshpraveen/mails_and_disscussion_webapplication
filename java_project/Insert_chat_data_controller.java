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

public class Insert_chat_data_controller extends HttpServlet 
{  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        String message=request.getParameter("comment");  
        Insert_chat_data data=new Insert_chat_data();
        HttpSession sessi=request.getSession(false);
        String name=(String)sessi.getAttribute("uname");  
        data.setName(name);  
        data.setMessage(message);  
        request.setAttribute("data",data);
        boolean status = data.insert();
        if(status)
        {
            RequestDispatcher rd=request.getRequestDispatcher("again_to_chat.jsp");  
            rd.forward(request, response);
        }
        else
        {  
            RequestDispatcher rd=request.getRequestDispatcher("again_to_chat.jsp");  
            rd.forward(request, response);  
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException 
    {  
        doPost(request, response);  
    }
}