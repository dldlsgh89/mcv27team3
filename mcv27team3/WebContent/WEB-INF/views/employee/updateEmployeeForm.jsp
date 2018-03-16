<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import= "model.Employee"  %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<%
	Employee employee = (Employee)request.getAttribute("employee");
%>
</head>
<body>
	<form action="<%= request.getContextPath() %>/UpdateEmployeeController.pjh" method="post">
	<table border="1">
	<tr>
		<td>직원번호</td>
		<td><input type="text" name="employeeNo" size="20" value="<%= employee.getEmployeeNo() %>" readonly></td>
	<tr>
	<tr>
		<td>직원이름</td>
		<td><input type="text" name="employeeId" size="20" value="<%= employee.getEmployeeId() %>"></td>
	<tr>
	<tr>
		<td>직원비밀번호</td>
		<td><input type="text" name="employeePw" size="20" value="<%= employee.getEmployeePw() %>"></td>
	<tr>
	<tr>
		<td colspan="4"><input type="submit" value="직원수정버튼"></td>
	</tr>
	</table>
	</form>

</body>
</html>