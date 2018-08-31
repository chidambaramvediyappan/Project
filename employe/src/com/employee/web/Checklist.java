package com.employee.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.data.DButill;


@WebServlet("/Checklist")
public class Checklist extends HttpServlet {	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection =null;
		PreparedStatement preparedStamement=null;
		String inputuserId= request.getParameter("name");
		String inputPassword=request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		ResultSet resultset = null;
		try {
			String number ="select *from EMP";
	      connection=DButill.getConnection();
	       preparedStamement = connection.prepareStatement(number);
	       resultset =  preparedStamement.executeQuery();
	       int flag=0;
	      while(resultset.next()) {
               if(inputuserId.equals(resultset.getObject(1))&& inputPassword.equals(resultset.getObject(2)))
               {
            	   out.print("login sucess");
            	   flag=1;
            	   break;
               }
	      }
	      javax.servlet.RequestDispatcher rs =null;
	      if(flag==1) {
	    	  out.println("<h1> login sucessfully</h1>");
	    	  rs=request.getRequestDispatcher("details.html");
	    	  rs.forward(request, response);
	      }
	      else
	      {
	    	  out.println("<h1> user invalied</h1>");
	    	  rs=request.getRequestDispatcher("userlogin.html");
	    	  rs.include(request, response);
	      }
	      
		} catch (Exception e) {
			
		}
	}

}
