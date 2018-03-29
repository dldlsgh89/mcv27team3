<!-- 27기 3팀 이인호 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/UpdateTeacherAddrController.team3" method="post">
		<table border="1">
			<tr>
				<td>teacherAddrNo</td>
				<td><input type="text" name="teacherAddrNo" size="20" value="${teacherAddr.teacherAddrNo}" readonly></td>
			<tr>
			<tr>
				<td>teacherNo</td>
				<td><input type="text" name="teacherNo" size="20" value="${teacherAddr.teacherNo}" readonly></td>
			<tr>
			<tr>
				<td>teacherAddress</td>
				<td><input type="text" name="teacherAddress" size="20" value="${teacherAddr.address}"></td>
			<tr>
			<tr>
				<td colspan="4"><input type="submit" value="선생님주소수정버튼"></td>
			</tr>
		</table>
	</form>
</body>
</html>