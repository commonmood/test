<%@ page contentType="text/html;charset=gb2312" %>

<jsp:useBean id="userinfo" class="edu.cugb.xg.javaee.bean.Users" scope="page" >
    <jsp:setProperty name="userinfo" property="*"/>
</jsp:useBean>

<jsp:useBean id="userBean" class="edu.cugb.xg.javaee.bean.Users" scope="application" />

<html>
<body>
<%     
    boolean success = userBean.isLegalUser(userinfo);
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