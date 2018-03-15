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
		<td>선생님번호</td>
		<td><input type="text" name="teacherNo" size="20" value="<%= teacher.getTeacherNo() %>" readonly></td>
	<tr>
	<tr>
		<td>선생님이름</td>
		<td><input type="text" name="teacherId" size="20" value="<%= teacher.getTeacherId() %>"></td>
	<tr>
	<tr>
		<td>선생님비밀번호</td>
		<td><input type="text" name="teacherPw" size="20" value="<%= teacher.getTeacherPw() %>"></td>
	<tr>
	<tr>
		<td colspan="4"><input type="submit" value="회원수정버튼"></td>
	</tr>
	</table>
	</form>

</body>
</html>