<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>增加雇员</title>
</head>
<body>
<div align="center"><span>增加雇员</span>
<form action="employeeServlet?action=add" method="post">
<table>
<tr><td>雇员姓名：</td><td><input type="text" name="name"/></td></tr>
<tr><td>雇员性别：</td><td><input type="radio" checked="checked" name="sex" value="1"/>男
<input type="radio" name="sex" value="2"/>女</td></tr>
<tr><td>雇员年龄：</td><td><input type="text" name="age"/></td></tr>
<tr><td>雇员部门：</td><td><input type="text" name="dept"/></td></tr>
<tr><td><input type="submit" value="增加"/></td><td><input type="reset" value="取消"/></td></tr>
</table>
</form>
</div>
</body>
</html>