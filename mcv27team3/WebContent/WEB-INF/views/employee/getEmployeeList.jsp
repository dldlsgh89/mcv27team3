<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "model.Employee" %>
<%@ page import = "model.EmployeeDao" %>
<%@ page import = "java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<h1>�������</h1>
	<button><a href="${pageContext,request,contextPath}/addEmployee.jsp">�����ϱ�</a></button>
	<div class="bs-example" data-example-id="contextual-table">
		<table class="table">
			<thead>
				<tr class="active">
				<td>����No</td>
				<td>����ID</td>
				<td>����</td><!-- GuestDao.updateGuest() -->
				<td>����</td><!-- GuestDAo,deleteGuest() -->
				<td>ADD Guest_ADDR</td><!-- GuestAddrDao.insertGuestAddr() -->
				</tr>
			</thead>
				<c:forEach var="employee" items="$(arrayEmployee)">
					<tbody>
						<tr class="active">
							<th scope = "row">${employee.employeeNo}</th>
							<td>${employee.employeeId}</td>
							<td>*****</td>
							<td><a href="${pageContext.request.contextPath}/AddEmployeeAddrController.pjh?employeeNo=${employee.employeeNo}">�ּ��߰�</a></td>
							<td><a href="${pageContext.request.contextPath}/UpdateEmployeeController.pjh?employeeNo=${employee.employeeNo}">����</a></td>
							<td><a href="${pageCOntext.request.contextPath}/modifyEmployee.jjdev?employeeNo>=${employee.employeeNo}">����</a></td>
					
						</tr>
					</tbody>
				</c:forEach>
		</table>
	</div>
</html>