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
	<h1>직원목록</h1>
	<button><a href="${pageContext,request,contextPath}/addEmployee.jsp">가입하기</a></button>
	<div class="bs-example" data-example-id="contextual-table">
		<table class="table">
			<thead>
				<tr class="active">
				<td>직원No</td>
				<td>직원ID</td>
				<td>수정</td><!-- GuestDao.updateGuest() -->
				<td>삭제</td><!-- GuestDAo,deleteGuest() -->
				<td>ADD Guest_ADDR</td><!-- GuestAddrDao.insertGuestAddr() -->
				</tr>
			</thead>
				<c:forEach var="employee" items="$(arrayEmployee)">
					<tbody>
						<tr class="active">
							<th scope = "row">${employee.employeeNo}</th>
							<td>${employee.employeeId}</td>
							<td>*****</td>
							<td><a href="${pageContext.request.contextPath}/AddEmployeeAddrController.pjh?employeeNo=${employee.employeeNo}">주소추가</a></td>
							<td><a href="${pageContext.request.contextPath}/UpdateEmployeeController.pjh?employeeNo=${employee.employeeNo}">수정</a></td>
							<td><a href="${pageCOntext.request.contextPath}/modifyEmployee.jjdev?employeeNo>=${employee.employeeNo}">삭제</a></td>
					
						</tr>
					</tbody>
				</c:forEach>
		</table>
	</div>
</html>