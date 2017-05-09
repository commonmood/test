<%@ page contentType="text/html;charset=gb2312" %>

<jsp:useBean id="userinfo" class="edu.cugb.xg.javaee.bean.Users" scope="request" />
    
<jsp:setProperty name="userinfo" property="username" param="user"/>
<jsp:setProperty name="userinfo" property="password" param="pass"/>

<html>
<body>
<%     
    boolean success = userinfo.isLegalUser(userinfo);
    if(success)
    {
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