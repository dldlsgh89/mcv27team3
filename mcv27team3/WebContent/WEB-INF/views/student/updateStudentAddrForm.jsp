<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>updateStudentAddrForm.jsp</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/UpdateStudentAddrController.lim" method="post">
		<table border="1">
			<tr>
				<td>학생주소번호</td>
				<td><input type="text" name="teacherAddrNo" size="20" value="${studentAddr.studentAddrNo}" readonly></td>
			<tr>
			<tr>
				<td>학생번호</td>
				<td><input type="text" name="teacherNo" size="20" value="${studentAddr.StudentNo}" readonly></td>
			<tr>
			<tr>
				<td>학생주소</td>
				<td><input type="text" name="teacherAddress" size="20" value="${studentAddr.address}"></td>
			<tr>
			<tr>
				<td colspan="4"><input type="submit" value="주소수정"></td>
			</tr>
		</table>
	</form>
</body>
</html>