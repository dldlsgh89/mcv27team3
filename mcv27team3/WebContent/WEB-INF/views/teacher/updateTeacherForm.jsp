<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/UpdateTeacherController.lee" method="post">
		<table border="1">
			<tr>
				<td>teacherNo</td>
				<td><input type="text" name="teacherNo" size="20" value="${teacher.teacherNo}" readonly></td>
			<tr>
			<tr>
				<td>teacherId</td>
				<td><input type="text" name="teacherId" size="20" value="${teacher.teacherId}"></td>
			<tr>
			<tr>
				<td>teacherPw</td>
				<td><input type="text" name="teacherPw" size="20" value="${teacher.teacherPw}"></td>
			<tr>
			<tr>
				<td colspan="4"><input type="submit" value="회원수정버튼"></td>
			</tr>
		</table>
	</form>
</body>
</html>