<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import= "model.TeacherAddr" %>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
<script>

<%	ArrayList<TeacherAddr> arrayTeacherAddr = (ArrayList<TeacherAddr>)request.getAttribute("arrayTeacherAddr"); 
	int arrayTeacherAddrSize= arrayTeacherAddr.size();
%>
	var arrayTeacherAddrSize = <%=arrayTeacherAddrSize%>;
	$(document).ready(function(){				
		if(arrayTeacherAddrSize<5){
			$(".addressAdd").show();
		}else if(arrayTeacherAddrSize>5)	
			$(".addressAdd").hide();
		}			
	});
</script>
</head>
<body>
	<h1>Teacher List</h1>
	<div class="bs-example" data-example-id="contextual-table">
	    <table class="table">
	      <thead>
	        <tr class="active">
	          <th>teacher number</th>
	          <th>teacher addr number</th>
	          <th>address</th>
	          <th>주소수정</th><!-- teacher num 넘겨줄때 뭘로 넘겨줄것인가  -->
	        </tr>
	      </thead>
<%			
		for(TeacherAddr teacherAddr : arrayTeacherAddr){
%>
	      <tbody>
	        <tr class="active">
	          <th scop e="row"><%= teacherAddr.getTeacherNo() %></th>
	          <td><%=teacherAddr.getTeacherAddrNo() %></td>
	          <td><%=teacherAddr.getAddress() %></td>          
	          <td><a href="<%= request.getContextPath()%>/AddTeacherAddrController.lee?sendNO=<%= arrayTeacherAddr.get(0).getTeacherNo() %>">주소 추가</a></td>
	        </tr>       
	      </tbody>	     
<%
		}	
%>	
		</table>  
  	</div>
  	<div class="addressAdd">
  		<td><a href="<%= request.getContextPath()%>/AddTeacherAddrController.lee?sendNO=<%= arrayTeacherAddr.get(0).getTeacherNo() %>">주소 추가</a></td>
	</div>
</body>
</html>