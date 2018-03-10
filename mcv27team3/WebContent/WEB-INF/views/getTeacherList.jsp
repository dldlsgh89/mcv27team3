<%@page import="model.Teacher"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%
	
	 ArrayList<Teacher> list = (ArrayList<Teacher>)request.getAttribute("arrayTeacher");
%>
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
	
</script>

</head>
<body>
	<h1>Teacher List</h1>
	<div class="bs-example" data-example-id="contextual-table">
    <table class="table">
      <thead>
        <tr class="active">
          <th>Column heading</th>
          <th>Column heading</th>
          <th>Column heading</th>
        </tr>
      </thead>
<%
	for(int i = 0; i<list.size(); i++){
		Teacher teacher = list.get(i);
%>
      <tbody>
        <tr class="active">
          <th scope="row"><%= teacher.getTeacherNo() %></th>
          <td><%=teacher.getTeacherId() %></td>
          <td><%=teacher.getTeacherPw() %></td>
        </tr>       
      </tbody>
<%
	}
%>
    </table>
  </div>
</body>
</html>