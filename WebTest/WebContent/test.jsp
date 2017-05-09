<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%   
    if (pageContext.getAttribute("pageCount")==null) 
        {
            pageContext.setAttribute("pageCount", new
            Integer(0));
        }
    if (session.getAttribute("sessionCount")==null) 
        {
            session.setAttribute("sessionCount",new
            Integer(0));
        }
    if (application.getAttribute("appCount")==null) 
        {
            application.setAttribute("appCount",new
            Integer(0));
        }
%>
        <h1>session、application 和 pageContext</h1>
        <% 
            Integer count = 
           (Integer)pageContext.getAttribute("pageCount");
            pageContext.setAttribute("pageCount", new 
            Integer(count.intValue()+1));
            Integer count2 = 
           (Integer)session.getAttribute("sessionCount");
            session.setAttribute("sessionCount",new 
            Integer(count2.intValue()+1));
            Integer count3 = 
           (Integer)application.getAttribute("appCount");
            application.setAttribute("appCount",new 
            Integer(count3.intValue()+1));
        %>
        <b>页面计数= </b>
        <%=pageContext.getAttribute("pageCount")%>
        <br/><b>会话计数= </b>
        <%=session.getAttribute("sessionCount")%>
        <br/><b>应用程序计数= </b>
        <%=application.getAttribute("appCount")%>
        <br/><b>时间= </b>
        <%=new java.sql.Time(System.currentTimeMillis()) %>


</body>
</html>