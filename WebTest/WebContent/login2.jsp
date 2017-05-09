<%@ page contentType="text/html;charset=gb2312" %>

<jsp:useBean id="userinfo" class="edu.cugb.xg.javaee.bean.Users" scope="page" />

<jsp:setProperty name="userinfo" property="*"/>
<html>
<body>
<%     
    boolean success = false;
    if(userinfo.getUser().equals("alan") && userinfo.getPass().equals("1234"))
    {
        success = true;
    }
    
    if(success)
    {
         request.setAttribute("message","success- alan");
%>
        <jsp:forward page="success.jsp" />
<%
    }else
    {
%>
        error
        <a href="login.html">try again</a>
<%
    }
%>
</body>
</html>