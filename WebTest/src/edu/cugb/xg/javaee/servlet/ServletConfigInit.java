package edu.cugb.xg.javaee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigInit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>\n");
        out.println("<body bgcolor=\"white\">\n");
        out.println("<head>\n");
        out.println("     <title>Init Parameters</title>\n");
        out.println("</head>\n");
        out.println("<body>\n");
        out.print("<h3 align=\"center\">All init parameters from web.xml for InitParamServlet</h3>");
        out.println("<hr/>");
        Enumeration initParams = getServletConfig().getInitParameterNames();
        while (initParams.hasMoreElements())
        {
            String initParamName = initParams.nextElement().toString();
            out.println(initParamName);
            out.print(" = " + getServletConfig().getInitParameter(initParamName) + "\n");
            out.println("<br/>\n");
        }
        out.println("</body>\n");
        out.println("</html>");
        out.close();

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
