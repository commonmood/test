<%@ page contentType="text/html;charset=gb2312" %>
<jsp:useBean id="userinfo" class="edu.cugb.xg.javaee.bean.Users" scope="session" />
    
<jsp:setProperty name="userinfo" property="user" param="user"/>
<jsp:setProperty name="userinfo" property="pass" value="1234"/>

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