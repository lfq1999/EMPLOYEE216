<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>雇员信息</title>
<style>
table,table tr th,table tr td{
	border:1px solid #000;
	text-align:center;
}
table{
	width:600px;
	border-collapse:collapse;
}
#addemp{
	width:600px;
	height:50px;
}
#addemp p{
	padding-top:5px;
	padding-left:480px;
}
a{
	text-decoration:none;
}
</style>
</head>
<body>
<div align="center">
<font size="5">雇员信息</font>
<div id="addemp"><p><a href="addEmployee.jsp">添加雇员</a></p></div>
<form method="post" action="">
<table>
<tr><td>雇员编号</td><td>雇员姓名</td><td>雇员性别</td><td>雇员年龄</td><td>所属部门</td><td>操作</td></tr>


<c:forEach items="${list }" var="emp">
<tr><td>${emp.emp_id }</td>
<td>${emp.emp_name }</td>
<td>${emp.emp_sex }</td>
<td>${emp.emp_age }</td>
<td>${emp.emp_depart }</td>
<td><a href="employeeServlet?action=queryByID&emp_id=${emp.emp_id }">修改</a>
&nbsp;&nbsp;<a href="employeeServlet?action=delete&emp_id=${emp.emp_id }" onclick="return confirm('是否确认删除？');">删除</a></td>
</tr>

</c:forEach>


</table>
</form>
</div>
</body>
</html>