<%@page import="edu.cugb.xg.javaee.bean.Users"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h4>遍历数组</h4>
<%
	String [] arrs = {"张三","李四","王五"};
	request.setAttribute("arrs", arrs);
%>
<!-- for(String s : arrs){ }  -->
<c:forEach var="s" items="${ arrs }">
	${ s }
</c:forEach>

<h4>遍历集合</h4>
<%
	List<String> list = new ArrayList<String>();
	list.add("张三");
	list.add("李四");
	list.add("王五");
	request.setAttribute("list", list);
%>
<c:forEach var="l" items="${list }">
	${l }
</c:forEach>

<h4>遍历Map集合</h4>
<%
	Map<String,String> map = new HashMap<String,String>();
	map.put("aa", "张三");
	map.put("bb", "李四");
	map.put("cc", "王五");
	request.setAttribute("map", map);
%>
<c:forEach var="entry" items="${ map }">
	${ entry.key } -- ${ entry.value }
</c:forEach>

<h4>遍历对象的集合</h4>
<%
	List<Users> uList = new ArrayList<Users>();
	uList.add(new Users("张三","123"));
	uList.add(new Users("李四","234"));
	uList.add(new Users("王五","345"));
	request.setAttribute("uList", uList);
%>
<c:forEach var="user" items="${ uList }">
	${ user.username } -- ${ user.password }
</c:forEach>

<h4>迭代数据</h4>
<h4>迭代从1到10</h4>
<c:forEach var="i" begin="1" end="10" step="2">
	${ i }
</c:forEach>


<h4>计算从1加到100的和</h4>
<c:set var="sum" value="0" scope="page"></c:set>
<c:forEach var="i" begin="1" end="100" step="1" varStatus="status">
	<c:set var="sum" value="${ sum + i }"></c:set>
</c:forEach>
${ sum }
</body>
</html>







