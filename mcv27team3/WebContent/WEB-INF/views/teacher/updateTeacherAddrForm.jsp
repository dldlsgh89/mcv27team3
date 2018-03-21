<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import= "model.TeacherAddr"  %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	TeacherAddr teacherAddr = (TeacherAddr)request.getAttribute("teacherAddr");
%>
</head>
<body>
	<form action="<%= request.getContextPath() %>/UpdateTeacherAddrController.lee" method="post">
		<table border="1">
			<tr>
				<td>teacherAddrNo</td>
				<td><input type="text" name="teacherAddrNo" size="20" value="<%= teacherAddr.getTeacherAddrNo() %>" readonly></td>
			<tr>
			<tr>
				<td>teacherNo</td>
				<td><input type="text" name="teacherNo" size="20" value="<%= teacherAddr.getTeacherNo() %>" readonly></td>
			<tr>
			<tr>
				<td>teacherAddress</td>
				<td><input type="text" name="teacherAddress" size="20" value="<%= teacherAddr.getAddress() %>"></td>
			<tr>
			<tr>
				<td colspan="4"><input type="submit" value="선생님주소수정버튼"></td>
			</tr>
		</table>
	</form>
</body>
</html>