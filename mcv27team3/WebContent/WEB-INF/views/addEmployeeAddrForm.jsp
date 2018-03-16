<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import= "model.Student"  %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>addEmployeeAddrForm.jsp</title>
<%
	int EmployeeNo = (int)request.getAttribute("EmployeeNo");
%>
</head>
<body>

<form action="<%= request.getContextPath() %>/AddStudentAddrController.lim" method="post">
		<table border="1">
			<tr>
				<td>"employeeNo"</td>
				<td><input type="text" name="StudentNo" size="20" value="<%= EmployeeNo %>" readonly></td>
			<tr>
			<tr>
				<td>studentAddr</td>
				<td><input type="text" name="studentAddr" size="20" value=""></td>
			<tr>
			<tr>
				<td colspan="4"><input type="submit" value="직원주소수정"></td>
			</tr>
		</table>
	</form>

</body>
</html>