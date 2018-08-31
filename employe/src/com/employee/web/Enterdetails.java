package com.employee.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.data.DButill;


@WebServlet("/DetailsEntered")
public class Enterdetails extends HttpServlet {
    public Enterdetails() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String inputName=request.getParameter("Name");
		String inputAge=request.getParameter("Age");
		String inputdataofbirth=request.getParameter("Date of birth");
		String inputAddress=request.getParameter("Address");
		String inputSalary=request.getParameter("Salary");
		String inputDescription=request.getParameter("Description");
		String inputPhone=request.getParameter("Phone");
		String inputEmail=request.getParameter("Email");
		out.println(inputName);
		out.println(inputAge);
		out.println(inputAddress);
		out.println(inputSalary);		
		out.println(inputDescription);
	    out.println(inputEmail);
	    out.println(inputPhone);
		Connection connection = null;
		
		ResultSet resultSet = null;
		String sql = "insert into details(Name,Age,date_of_birth,addresss,salary,Description,Email,phone)values(?,?,?,?,?,?,?,?)";
		
		PreparedStatement prepareStatement = null;
		try{
		connection  = DButill.getConnection();
		connection.setAutoCommit(false);
		prepareStatement = connection.prepareStatement(sql);
		
		
	
			
			prepareStatement.setString(1,inputName);
			prepareStatement.setString(2,inputAge);
			prepareStatement.setString(3,inputdataofbirth);
			prepareStatement.setString(4,inputAddress);
			prepareStatement.setString(5,inputSalary);
			prepareStatement.setString(6,inputDescription);
			prepareStatement.setString(7,inputEmail);
			prepareStatement.setString(8,inputPhone);
			prepareStatement.executeUpdate();
			connection.commit();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}out.close();
}
}
