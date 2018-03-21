<!-- 27기 3팀 임가현 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "model.Student" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student List</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style type="text/css"> 
 		body{
 			padding: 250px;
 			background-color: #BDBDBD;
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
	<ul class="nav nav-pills">
		<li role="presentation"><a href="<%=request.getContextPath()%>/addStudent.lim">회원가입</a></li>
	</ul>
	<div class="bs-example" data-example-id="contextual-table">
		<table class="table">
			<thead>
				<tr class="active">
					<th style="text-align: center">student No</th>
					<th style="text-align: center">student ID</th>
					<th style="text-align: center">student PW</th>
					<th style="text-align: center">Add student_Addr</th> <!-- StudentAddrDao.insertStudentAddr -->
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
					<td><a href="<%=request.getContextPath()%>/GetStudentAddrListController.lim?sendNo=<%=student.getStudentNo()%>">주소확인</a></td>
					<td><a href="<%=request.getContextPath()%>/UpdateStudentController.lim?sendNO=<%=student.getStudentNo()%>">수정</a></td>
					<td><a href="<%=request.getContextPath()%>/DeleteStudentController.lim?sendNO=<%=student.getStudentNo()%>">삭제</a></td>
				</tr>
			</tbody>
				<%
					}
				%> 
			
		</table>
	</div>
</body>
</html>