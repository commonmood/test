/*
 * Created on 2004-11-24
 *
 * By Alan, All rights reserved.
 */
package edu.cugb.xg.javaee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Add description here .
 * 
 * @author Alan
 * @version 1.0
 */
public class SafeCounterServlet extends HttpServlet {
	private int count = 0;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<HTML>\n");
		out.println("<HEAD><TITLE>Thread Safe ServletCounter</TITLE></HEAD>\n");
		out.println("<BODY>\n");

		synchronized (this) {
			int temp = count;
			temp = temp + 1;
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
			}
			count = temp;
		}

		out.println("You are the " + count + " st one who has visited me!\n");
		out.println("</BODY>\n");
		out.println("</HTML>");
	}
}