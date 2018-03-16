<!-- 27기 3팀 임가현 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "model.StudentAddr" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Student List</title>
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
<body>
	<h1>Student Addr List</h1>
	<div class="bs-example" data-example-id="contextual-table">
		<table class="table">
			<thead>
				<tr class="active">
					<th style="text-align: center">student addr no</th>
					<th style="text-align: center">student no</th>
					<th style="text-align: center">address</th>
					<th style="text-align: center">수정</th><!-- StudentDao.update / studentNO=? -->
				</tr>
			</thead>
<%
ArrayList<StudentAddr> arrayStudentAddr = (ArrayList<StudentAddr>)request.getAttribute("arrayStudentAddr");
	for(StudentAddr studentAddr : arrayStudentAddr) {
%>
			<tbody>
				<tr class="active">
					<td><%= studentAddr.getStuedentAddrNo() %></td>
					<td><%= studentAddr.getStudentNo() %></td>
					<td><%= studentAddr.getAddress() %></td>
					<td><a href="<%=request.getContextPath()%>/AddStudentAddrController.lim?studentNO=<%=studentAddr.getStudentNo()%>">수정</a></td>
				</tr>
			</tbody>
				<%
					}
				%> 
			
		</table>
	</div>
</body>
</html>