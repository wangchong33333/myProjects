<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is my JSP page. <br>
    
    <table border="1">
    <tr>
    <td>姓名</td>
    <td>年龄</td>
    <td>生日</td>
    <td>地址</td>
    <td>操作</td>
    </tr>
    
    <c:forEach items="${userList}" var="user">
    <tr>
    <td>${user.username}</td>
    <td>${user.age}</td>
    <td>${user.birthday}</td>
    <td>${user.address}</td>
    <td><a href="${pageContext.request.contextPath}/rest/user/update/${user.id}">修改</a></td>
    </tr>
    
    </c:forEach>
    
    </table>
  </body>
</html>
