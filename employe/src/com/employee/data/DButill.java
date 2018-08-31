package com.employee.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.net.ConnectException;

public class DButill {
	public static Connection getConnection()
	{
		Connection Connection=null;
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");

		     Connection = DriverManager.getConnection("jdbc:mysql://localhost/mysql", "root", "root");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		return Connection;
	}
	public static void  close(Connection Connection,ResultSet result,PreparedStatement statement)
	{
		
			try {
				if(Connection != null) {
				Connection.close();
				}
				if(result != null) {
					result.close();
				}
				if(statement != null)
				{
					result.close();
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}

	
	}

