<html>
<head>
	<title>student</title>
</head>
<body>
	学生信息：<br>
	学号：${student.id}&nbsp;&nbsp;&nbsp;&nbsp;
	姓名：${student.name}&nbsp;&nbsp;&nbsp;&nbsp;
	年龄：${student.age}&nbsp;&nbsp;&nbsp;&nbsp;
	地址：${student.address}<br>
	
	学生列表：
	<table border="1">
		<tr>
			<th>序号</th>
			<th>学号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>地址</th>
		</tr>
		
		<#list students as student>
			<#if student_index % 2 ==0>
			<tr bgcolor="red">
			<#else>
			<tr bgcolor="blue">
			</#if>>
				<th>${student_index}</th>
				<th>${student.id}</th>
				<th>${student.name}</th>
				<th>${student.age}</th>
				<th>${student.address}</th>
			</tr>
		</#list>
	</table>
	<br>
	
	当前日期：${date?string("yyyy/MM/dd HH:mm:ss")}
	<br>
	
	null值的处理：${val!"此值为null"}
	<br>
	<#if val??>
	有
	<#else>
	无
	</#if>
	<br>
	
	引用模板测试：<br>
	<#include "hello.ftl">
	
</body>
</html>