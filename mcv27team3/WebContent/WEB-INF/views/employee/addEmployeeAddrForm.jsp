<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<%@ page import= "model.Student"  %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addEmployeeAddrForm.jsp</title>
<%-- <%
	int EmployeeNo = (int)request.getAttribute("EmployeeNo");
%> --%>
</head>
<body>

<form action="${pageContext.request.contextPath}/AddEmployeeAddrController.pjh" method="post">
		<table border="1">
			<tr>
				<td>"employeeNo"</td>
				<td><input type="text" name="EmployeeNo" size="20" value="${employeeNo}" readonly></td>
			<tr>
			<tr>
				<td>studentAddr</td>
				<td><input type="text" name="employeeAddr" size="20" value=""></td>
			<tr>
			<tr>
				<td colspan="4"><input type="submit" value="직원주소수정"></td>
			</tr>
		</table>
	</form>
</body>
</html>