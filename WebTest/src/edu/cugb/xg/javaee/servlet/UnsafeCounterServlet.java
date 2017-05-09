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
import javax.servlet.http.HttpSession;

/**
 * Add description here .
 * 
 * @author Alan
 * @version 1.0
 */
public class UnsafeCounterServlet extends HttpServlet
{
//    private int count = 0;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<HTML>\n");
        out.println("<HEAD><TITLE>Thread Unsafe ServletCounter</TITLE></HEAD>\n");
        out.println("<BODY>\n");
        HttpSession session = request.getSession(true);
        Object count = null;
		int counter = 0;
		synchronized(this){
		count = session.getAttribute("COUNTER");
		if (count == null) {
			counter = 1;
			// 将第一次计数存入session
			 try {
				Thread.sleep(3000);
				session.setAttribute("COUNTER", new Integer(1));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			counter = ((Integer) count).intValue();
			counter++;// 计数加一
			// 将计数存入session
			 try {
				Thread.sleep(3000);
				session.setAttribute("COUNTER", new Integer(counter));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		}

// int temp = count;
// temp = temp + 1;
// try
// {
// System.out.println("Thread.currentThread():" +
// Thread.currentThread().toString());
//        	System.out.println("Thread.activeCount:" + Thread.activeCount());
//            Thread.sleep(3000);
//        } catch (Exception e)
//        {
//        }
//        count = temp;
        out.println("You are the " + count + " st one who has visited me!\n");
        out.println("</BODY>\n");
        out.println("</HTML>");
    }
}