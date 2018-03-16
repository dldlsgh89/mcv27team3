<!-- 27기 3팀 임가현 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "model.StudentAddr" %>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
<script>
<%
ArrayList<StudentAddr> arrayStudentAddr = (ArrayList<StudentAddr>)request.getAttribute("arrayStudentAddr");
	int arrayStudentAddrSize = arrayStudentAddr.size();
%>
	var arrayStudentAddrSize = <%=arrayStudentAddrSize%>;
	$(document).ready(function(){				
		if(arrayStudentAddrSize<5){
			$(".addressAdd").show();
		}else if(arrayStudentAddrSize>5)	
			$(".addressAdd").hide();
		}			
	);
</script> 

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
		int sendNO = (int)session.getAttribute("sendNO");
		for(StudentAddr studentAddr : arrayStudentAddr){
%>
			<tbody>
				<tr class="active">
					<th scop e="row"><%= studentAddr.getStudentNo() %></th>
					<td><%= studentAddr.getStuedentAddrNo() %></td>
					<td><%= studentAddr.getStudentNo() %></td>
					<td><%= studentAddr.getAddress() %></td>
					<td><a href="<%=request.getContextPath()%>/AddStudentAddrController.lim?sendNO=<%=studentAddr.getStudentNo()%>">수정</a></td>
				</tr>
			</tbody>
		<%
		}	
		%>	
			
		</table>	
	</div>
	<div class="addressAdd">
  		<td><a href="<%= request.getContextPath()%>/AddStudentAddrController.lim?sendNo=<%=sendNO%>">주소 추가</a></td>
	</div>
</body>
</html>