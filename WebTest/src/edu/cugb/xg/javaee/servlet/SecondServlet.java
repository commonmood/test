package edu.cugb.xg.javaee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String username = req.getParameter("username");		
		if(username.equals("test")){
		    Cookie userCookie = new Cookie("user", username);
//		    Cookie passCookie = new Cookie("pass", pass);
		    resp.addCookie(userCookie);
//		    response.addCookie(passCookie);

			req.setAttribute("user", username);
			req.getRequestDispatcher("/success").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	

}
