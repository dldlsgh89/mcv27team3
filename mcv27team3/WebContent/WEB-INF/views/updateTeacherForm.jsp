<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import= "model.Teacher"  %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<%
	Teacher teacher = (Teacher)request.getAttribute("teacher");
%>
</head>
<body>
	<form action="<%= request.getContextPath() %>/UpdateTeacherController.lee" method="post">
	<table border="1">
	<tr>
		<td>�����Թ�ȣ</td>
		<td><input type="text" name="teacherNo" size="20" value="<%= teacher.getTeacherNo() %>" readonly></td>
	<tr>
	<tr>
		<td>�������̸�</td>
		<td><input type="text" name="teacherId" size="20" value="<%= teacher.getTeacherId() %>"></td>
	<tr>
	<tr>
		<td>�����Ժ�й�ȣ</td>
		<td><input type="text" name="teacherPw" size="20" value="<%= teacher.getTeacherPw() %>"></td>
	<tr>
	<tr>
		<td colspan="4"><input type="submit" value="ȸ��������ư"></td>
	</tr>
	</table>
	</form>

</body>
</html>