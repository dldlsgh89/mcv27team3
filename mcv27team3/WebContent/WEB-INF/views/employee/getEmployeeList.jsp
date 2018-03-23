<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style type="text/css"> 
 		body{
 			padding: 250px;
 			background-image: url("https://images.unsplash.com/photo-1509210459313-17feefdff5cd?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=c5ddf153f3339e6ceffb94528f018a9d&w=1000&q=80");
			background-size: 1600px 800px;
 		}
		form{ 
 			margin: 0 auto; 
 			padding: 10px 10px 10px 10px; 
			width: 40%; 
 			background-color: #ffffff;
 			text-align: center;
 		} 
</style>  

</head>
	<h1>직원목록</h1>
	<button><a href="${pageContext.request.contextPath}/addEmployee.jsp">가입하기</a></button>
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
				<c:forEach var="employee" items="${arrayEmployee}">
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