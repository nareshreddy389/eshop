package sample;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpringSample extends HttpServlet {
	
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
       {
	
    	   ServletConfig config=getServletConfig();
    	  String n= config.getServletName()+"- servlet.xml";
    	  System.out.println(n);
    	   
    	   
    	   
    	   
    	   
    	   
    	   
    	   
    	   
    	   
    	   
    	   
    	   
	}

}
