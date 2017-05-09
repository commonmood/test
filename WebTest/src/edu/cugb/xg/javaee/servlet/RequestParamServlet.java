package edu.cugb.xg.javaee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestParamServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<HTML>\n");
        out.println("<HEAD><TITLE>All Request Parameters</TITLE></HEAD>\n");
        out.println("<BODY><h3 align=\"center\">All Request Parameters</h3>\n");
        out.println("<TABLE width=\"50%\" border=\"1\" align=\"center\">\n");
        out.println("   <TR>\n");
        out.println("       <TH>Parameter Name</TH>\n");
        out.println("       <TH>Parameter Value</TH>\n");
        out.println("   </TR>\n");

        Enumeration paramNames = request.getParameterNames();
       // Iterator itor = (Iterator)request.getParameterNames();
        while (paramNames.hasMoreElements())
        {
            String paramName = paramNames.nextElement().toString();

            out.println("<TR>\n");
            out.println("   <TD>" + paramName + "</TD>\n");
            out.println("   <TD>\n");

            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length == 1)
            {
                String paramValue = paramValues[0];
                if (paramValue == null || paramValue.length() == 0)
                {
                    out.print("<I>No Value</I>");
                } else
                {
                    out.print(paramValue);
                }
            } else
            {
                out.println("<UL>");
                for (int i = 0; i < paramValues.length; i++)
                {
                    out.println("<LI>" + paramValues[i] + "</LI>");
                }
                out.println("</UL>");
            }
            out.println("   </TD>\n");
            out.println("</TR>\n");
        }
        out.println("</TABLE>\n");

        out.println("<BR><hr/><B> The Query String is \n" + request.getQueryString());
        out.println("</BODY></HTML>");
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
