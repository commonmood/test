/*
 * Created on 2004-11-25
 *
 * By Alan, All rights reserved.
 */
package edu.cugb.xg.javaee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Alan
 * @version 1.0
 */
public class ContextParameterServlet extends HttpServlet
{
    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        ServletContext ctx = getServletContext();

        out.println("<HTML>\n");
        out.println("<HEAD><TITLE>Context parameter</TITLE></HEAD>\n");
        out.println("<BODY>\n");
        out.println("<h3 align=\"center\">init parameters of ServletContext</h3>\n");
        out.println("<hr/>\n");

        Enumeration enum1 = ctx.getInitParameterNames();

        while (enum1.hasMoreElements())
        {
            String key = (String) enum1.nextElement();
            Object value = ctx.getInitParameter(key);
            out.println(key + " = " + value + " <br/>\n");
        }

        out.println("</BODY>\n");
        out.println("</HTML>");
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException
    {
        doGet(request, response);
    }
}