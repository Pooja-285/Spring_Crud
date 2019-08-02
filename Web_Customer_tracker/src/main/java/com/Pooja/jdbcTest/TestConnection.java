package com.Pooja.jdbcTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestConnection
 */
public class TestConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="jdbc:mysql://localhost:3306/web_customer_tracker";
		String user = "springstudent";
		String pass="springstudent";
		
		try
		{
			PrintWriter out = response.getWriter();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,user,pass);
			
			out.println("CONNECTED SUCCESFULLY  to " +url);
			
			con.close();
		}
	catch(Exception e)
	{
		System.out.println("---------EXCEPTION OCCURED----------\n" + e);
	}

	}
}
