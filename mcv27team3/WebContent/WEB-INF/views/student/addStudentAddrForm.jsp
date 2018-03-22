<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addStudentAddrForm.jsp</title>
<%-- <%
	int studentNo = (int)request.getAttribute("studentNo");
%> --%>
</head>
<body>

<form action="${pageContext.request.contextPath}/AddStudentAddrController.lim" method="post">
		<table border="1">
			<tr>
				<td>studentNo</td>
				<td><input type="text" name="studentNo" size="20" value="${studentNo}" readonly></td>
			<tr>
			<tr>
				<td>studentAddr</td>
				<td><input type="text" name="studentAddr" size="20" value=""></td>
			<tr>
			<tr>
				<td colspan="4"><input type="submit" value="회원주소수정"></td>
			</tr>
		</table>
	</form>

</body>
</html>