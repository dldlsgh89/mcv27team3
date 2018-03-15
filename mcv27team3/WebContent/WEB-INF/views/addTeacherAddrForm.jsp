<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import= "model.Teacher"  %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<%
	int teacherNo = (int)request.getAttribute("teacherNo");
%>
</head>
<body>
	<form action="<%= request.getContextPath() %>/AddTeacherAddrController.lee" method="post">
		<table border="1">
			<tr>
				<td>teacherNo</td>
				<td><input type="text" name="teacherNo" size="20" value="<%= teacherNo %>" readonly></td>
			<tr>
			<tr>
				<td>teacherAddr</td>
				<td><input type="text" name="teacherAddr" size="20" value=""></td>
			<tr>
			<tr>
				<td colspan="4"><input type="submit" value="회원수정버튼"></td>
			</tr>
		</table>
	</form>
</body>
</html>