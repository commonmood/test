package edu.cugb.xg.javaee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Welcome extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		if (cookies != null && cookies.length != 0) {
			for(int i=0;i<cookies.length;i++){
				String cookiename = cookies[i].getName();
				if(cookiename.equals("user")){
					String username = cookies[i].getValue().toString();
					if(username.equals("test")){
						PrintWriter out = resp.getWriter();
//						String username = req.getAttribute("user").toString();
						out.println("welcome " + username);						
					}
					
				}
			}
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
