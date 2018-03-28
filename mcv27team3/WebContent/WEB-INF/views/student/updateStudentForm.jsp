<!-- 27기 3팀 임가현 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>m_update_form.jsp</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/UpdateStudentController.team3" method="post">
		<table border="1">
			<tr>
				<td>학생번호</td>
				<td><input type="text" name="studentNo" size="20" value="${student.studentNo}" readonly></td>
			<tr>
			<tr>
				<td>학생아이디</td>
				<td><input type="text" name="studentId" size="20" value="${student.studentId}"></td>
			<tr>
			<tr>
				<td>학생비밀번호</td>
				<td><input type="text" name="studentPw" size="20" value="${student.studentPw}"></td>
			<tr>
			<tr>
				<td colspan="4"><input type="submit" value="회원수정버튼"></td>
			</tr>
		</table>
	</form>

</body>
</html>