<!-- 27기 3팀 임가현 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "model.Student" %>
<%@ page import = "model.StudentDao" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Student List</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style type="text/css"> 
 		body{
 			margin: 0 auto; 
 			padding: 10px 10px 10px 10px; 
			width: 50%; 
 			background-color: #ffffff;
 			text-align: center;
 			} 
 </style> 

</head>
<body>
	
	<% 
		StudentDao studentdao = new StudentDao();
	%>
	<h1>Student List</h1>
	<div class="bs-example" data-example-id="bordered-table">
		<table class="table table-bordered">
			<thead>
				<tr >
					<th style="text-align: center">student No</th>
					<th style="text-align: center">student ID</th>
				</tr>
			</thead>
			<%
				ArrayList<Student> arraylist = new ArrayList<Student>();
				for(Student student : arraylist) {
			%>
			<tbody>
				<tr>
					<td><%= student.getStudentId() %></td>
					<td><%= student.getStudentPw()%></td>
				</tr>
				<%
				}
				%> 
			</tbody>
		</table>
	</div>
</body>
</html>