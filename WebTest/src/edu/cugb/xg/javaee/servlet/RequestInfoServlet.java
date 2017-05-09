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
 * 
 * @author Alan
 * @version 1.0
 */
public class RequestInfoServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<HTML>\n");
        out.println("<HEAD><TITLE>Request Information</TITLE></HEAD>\n");
        out.println("<BODY>\n");
        out.println("     <h3 align=\"center\">Request Related Information</h3>\n");
        out.println("     <hr/>\n");
        out.println("     requestMethod = " + request.getMethod()+ "<br/>\n");        
        out.println("     requestURI = " + request.getRequestURI() + "<br/>\n");    
        out.println("     requestURL = " + request.getRequestURL() + "<br/>\n");        
        out.println("     contextPath = " + request.getContextPath() + "<br/>\n");
        out.println("     servletPath = " + request.getServletPath() + "<br/>\n");
        out.println("     pathInfo = " + request.getPathInfo() + "<br/>\n");
        out.println("     <hr/>\n");
        out.println("     pathTranslated = " + request.getPathTranslated() + "<br/>\n");
            out.println("     <hr/>\n");
        out.println("     contentType = " + request.getContentType() + "<br/>\n");
        out.println("     protocol = " + request.getProtocol() + "<br/>\n");
        out.println("     serverName = " + request.getServerName() + "<br/>\n");
        out.println("     serverPort = " + request.getServerPort() + "<br/>\n");
        out.println("     remoteAddress = " + request.getRemoteAddr() + "<br/>\n");
        out.println("     remotHost = " + request.getRemoteHost() + "<br/>\n");
        out.println("</BODY>\n");
        out.println("</HTML>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException
    {
        doGet(request, response);
    }
}