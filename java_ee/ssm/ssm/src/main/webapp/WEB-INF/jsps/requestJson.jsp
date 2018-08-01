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

<title>My JSP 'requestJson.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript">
	function requestJson() {
		var jsonUser = JSON.stringify({
			"username" : "you",
			"age" : "34",
			"address" : "wuhan"
		});

		$.ajax({
			type : 'post',
			url : '${pageContext.request.contextPath}/user/requestJson.do',
			contentType : 'application/json;charset=utf-8',
			data : jsonUser,
			success : function(data) {
				alert(data)
			}
		})

	}
	
	function requestPojo(){
	$.ajax({
			type : 'post',
			url : '${pageContext.request.contextPath}/user/requestPojo.do',
			data : 'username=ye&age=23&address=wuhan',
			success : function(data) {
				alert(data)
			}
		})
	}
</script>
</head>

<body>
	<input type="button" value="请求json，返回json" onclick="requestJson();">
	<input type="button" value="请求pojo，返回json" onclick="requestPojo();">
</body>
</html>
