<%@ page contentType="text/html;charset=gb2312" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
<body>
<jsp:useBean id="user" class="edu.cugb.xg.javaee.bean.Users" scope="request">
</jsp:useBean>
<jsp:setProperty property="username" name="user" param="user"/>
username:${user.username }
<jsp:setProperty property="password" name="user" param="pass"/> 
password:${user.password }
<c:if test="${user.valid}">
      <jsp:forward page="success.jsp" />
</c:if>
<c:if test="${!user.valid}">
     <jsp:forward page="login.html" />
</c:if>

<%-- <% 
    //String user = request.getParameter("user");
    //String password = request.getParameter("pass");
    //boolean success = false;
    
    if(user.equals("alan") && password.equals("1234"))
    {
    	request.setAttribute("message","success- alan");
        success = true;
    }
    if(success)
    {
%>
        <jsp:forward page="success.jsp"/>
<%
    }else
    {
%>
        error
        <a href="login.html">try again</a>
<%
    }
%> --%>
</body>
</html>