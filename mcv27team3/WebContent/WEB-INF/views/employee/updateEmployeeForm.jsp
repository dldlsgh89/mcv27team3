<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%-- <%
	Employee employee = (Employee)request.getAttribute("employee");
%> --%>
</head>
<body>
	<form action="${pageContext.request.contextPath}/UpdateEmployeeController.pjh" method="post">
		<table border="1">
			<tr>
				<td>직원번호</td>
				<td><input type="text" name="employeeNo" size="20" value="${employee.employeeNo}" readonly></td>
			<tr>
			<tr>
				<td>직원이름</td>
				<td><input type="text" name="employeeId" size="20" value="${employee.employeeId}"></td>
			<tr>
			<tr>
				<td>직원비밀번호</td>
				<td><input type="text" name="employeePw" size="20" value="${employee.employeePw}"></td>
			<tr>
			<tr>
				<td colspan="4"><input type="submit" value="직원수정버튼"></td>
			</tr>
		</table>
	</form>
</body>
</html>