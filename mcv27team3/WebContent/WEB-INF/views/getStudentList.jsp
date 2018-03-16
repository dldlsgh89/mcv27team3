<!-- 27기 3팀 임가현 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "model.Student" %>
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
	<h1>Student List</h1>
	<div class="bs-example" data-example-id="contextual-table">
		<table class="table">
			<thead>
				<tr class="active">
					<th style="text-align: center">student No</th>
					<th style="text-align: center">student ID</th>
					<th style="text-align: center">student PW</th>
					<th style="text-align: center">ADD student_ADDR</th> <!-- StudentAddrDao.insertStudentAddr -->
					<th style="text-align: center">수정</th><!-- StudentDao.update / studentNO=? -->
					<th style="text-align: center">삭제</th><!-- StudentDao.delete -->
				</tr>
			</thead>
<%
ArrayList<Student> arrayStudent = (ArrayList<Student>)request.getAttribute("arrayStudent");
	for(Student student : arrayStudent) {
%>
			<tbody>
				<tr class="active">
					<td><%= student.getStudentNo() %></td>
					<td><%= student.getStudentId() %></td>
					<td>****</td>
					<td><a href="<%=request.getContextPath()%>/AddStudentAddrController.lim?studentNO=<%=student.getStudentNo()%>">주소추가</a></td>
					<td><a href="<%=request.getContextPath()%>/UpdateStudentController.lim?studentNO=<%=student.getStudentNo()%>">수정</a></td>
					<td><a href="<%=request.getContextPath()%>/DeleteStudentController.lim?studentNO=<%=student.getStudentNo()%>">삭제</a></td>
				</tr>
			</tbody>
				<%
					}
				%> 
			
		</table>
	</div>
</body>
</html>