package edu.cugb.xg.javaee.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cugb.xg.javaee.util.JDBCUtils;

/**
 * Servlet implementation class HTTPServletTest
 */

public class HTTPServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HTTPServletTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//			String url = "jdbc:mysql://localhost:3306/test";
		//			String user = "root";
		//			String password = "root";
		//			Class.forName("com.mysql.jdbc.Driver");
		//			Connection conn = DriverManager.getConnection(url, user, password);
					Connection conn = JDBCUtils.getConnection();
					System.out.println(conn);
					System.out.println("JNDI connection :" + conn.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
