<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:useBean id= "bean" class="edu.cugb.xg.javaee.bean.Simplebean"
scope="request" />
<jsp:setProperty name= "bean" property="name" value="${param.name}" />
<jsp:setProperty name= "bean" property="age" value= "25" />

</head>
<body>
姓名：${bean.name}    <br />
年龄：${bean.age} 
</body>
</html>