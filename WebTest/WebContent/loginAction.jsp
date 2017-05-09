<%@ page contentType="text/html;charset=gb2312" 
         import="alan.User" errorPage="error.jsp"%>

<jsp:useBean id="userinfo" class="edu.cugb.xg.javaee.bean.Users" scope="page" >
    <jsp:setProperty name="userinfo" property="*"/>
</jsp:useBean>

<jsp:useBean id="userBean" class="edu.cugb.xg.javaee.bean.Users" scope="application" />

<%
    String action = request.getParameter("action");
    if(action == null)
    {
        response.sendRedirect(request.getContextPath() + "/actionEmpty.jsp");
        return;
    }
    
    String nextPage = "";
    
    if(action.equalsIgnoreCase("login"))
    {
        boolean success = userBean.isLegalUser(userinfo);
        if(success)
        {
            request.setAttribute("user", userinfo);
            nextPage = "show.jsp";
        }else
        {
            nextPage = "error.jsp";
        }
     }else if(action.equalsIgnoreCase("findUser"))
     {
        User[] users = userBean.findUser(userinfo);
        request.setAttribute("users", users);
        nextPage = "showUsers.jsp";
     }else if(action.equalsIgnoreCase("addUser"))
     {
        userBean.addUser(userinfo);
        request.setAttribute("message", "添加成功！");
        nextPage = "success.jsp";
        //You should considered the effect of refresh!
     }else if(action.equalsIgnoreCase("modifyUser"))
     {
        userBean.modifyUser(userinfo);
        request.setAttribute("message", "修改成功！");
        nextPage = "success.jsp";
        //You should considered the effect of refresh!
     }else if(action.equalsIgnoreCase("removeUser"))
     {
        userBean.removeUser(userinfo.getId());
        request.setAttribute("message", "删除成功！");
        //query database
        //setAttribute
        nextPage = "showUsers.jsp";
        //You should considered the effect of refresh!
     }else
     {
        request.setAttribute("message", "不能处理该请求:" + action);
        nextPage = "success.jsp";    
     }
%>
<jsp:forward page="<%= nextPage%>" />  