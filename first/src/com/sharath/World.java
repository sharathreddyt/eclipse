package com.sharath;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class World
 */
@WebServlet("/World")
public class World extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public World() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		String username =  request.getParameter("userName");
		String password = request.getParameter("userPass");
		
		 Connection con = null;  
		  Statement stmt = null;
		  ResultSet rs = null;
		
		  try {
				Class.forName("com.mysql.jdbc.Driver");
				con =(Connection) DriverManager.getConnection ("jdbc:mysql://127.0.0.1:3306/users", "root", "Sharath123");
				stmt = (Statement) con.createStatement();
			String sql = "INSERT INTO users (username,password) VALUES (username ,password)";
			
			stmt.executeUpdate(sql);
			} catch (SQLException e) {
				throw new ServletException("Servlet Could not display records.", e);
			  } catch (ClassNotFoundException e) {
				  throw new ServletException("JDBC Driver not found.", e);
				} finally {
					try {
						if(rs != null) {
							rs.close();
							rs = null;
						}
						if(stmt != null) {
							stmt.close();
							stmt = null;
						}
						if(con != null) {
							con.close();
							con = null;
						}
					} catch (SQLException e) {}
				}
		  
		

		
		
		out.print("welcome ");out.print(username);
		response.getWriter().append("Served at:test ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	

		doGet(request, response);
	}

}
