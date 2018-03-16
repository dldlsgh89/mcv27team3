<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import= "model.Teacher"  %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	Teacher teacher = (Teacher)request.getAttribute("teacher");
%>
</head>
<body>
	<form action="<%= request.getContextPath() %>/UpdateTeacherController.lee" method="post">
	<table border="1">
	<tr>
		<td>teacherNo</td>
		<td><input type="text" name="teacherNo" size="20" value="<%= teacher.getTeacherNo() %>" readonly></td>
	<tr>
	<tr>
		<td>teacherId</td>
		<td><input type="text" name="teacherId" size="20" value="<%= teacher.getTeacherId() %>"></td>
	<tr>
	<tr>
		<td>teacherPw</td>
		<td><input type="text" name="teacherPw" size="20" value="<%= teacher.getTeacherPw() %>"></td>
	<tr>
	<tr>
		<td colspan="4"><input type="submit" value="회원수정버튼"></td>
	</tr>
	</table>
	</form>

</body>
</html>