<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'add.jsp' starting page</title>

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
	<form action="${pageContext.request.contextPath}/user/receiveUser.do"
		method="post">
		姓名：<input type="text" name="username" id="username"> 年龄：<input
			type="text" name="age" id="age"> 生日：<input type="text"
			name="birthday" id="birthday"> 地址：<input type="text"
			name="address" id="address"> <input type="submit" value="提交">
	</form>

	<hr color="blue" size="12">
	<form action="${pageContext.request.contextPath}/user/receiveInt.do"
		method="post">
		姓名：<input type="text" name="id" id="id"> <input type="submit"
			value="提交">
	</form>

	<hr color="blue" size="12">
	<form action="${pageContext.request.contextPath}/user/receiveStr.do"
		method="post">
		姓名：<input type="text" name="username" id="username"> <input
			type="submit" value="提交">
	</form>

	<hr color="blue" size="12">
	<form
		action="${pageContext.request.contextPath}/user/receiveUserCustom.do"
		method="post">
		姓名：<input type="text" name="user.username" id="username"> 年龄：<input
			type="text" name="user.age" id="age"> 生日：<input type="text"
			name="user.birthday" id="birthday"> 地址：<input type="text"
			name="user.address" id="address"> <input type="submit"
			value="提交">
	</form>

	<hr color="blue" size="12">
	<form action="${pageContext.request.contextPath}/user/receiveIds.do"
		method="post">
		ID:<input type="checkbox" name="ids" id="ids" value="1"> ID:<input
			type="checkbox" name="ids" id="ids" value="2"> ID:<input
			type="checkbox" name="ids" id="ids" value="3"> <input
			type="submit" value="提交">
	</form>
</body>
</html>
