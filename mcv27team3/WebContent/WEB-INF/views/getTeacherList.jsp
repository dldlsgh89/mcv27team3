<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="model.Teacher"%>
<%@page import="java.util.ArrayList"%>
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
</head>
<body>
	<h1>Teacher List</h1>
	<div class="bs-example" data-example-id="contextual-table">
    <table class="table">
      <thead>
        <tr class="active">
          <th>teacher number</th>
          <th>teacher ID</th>
          <th>teacher PW</th>
          <th>수정</th><!-- teacher num 넘겨줄때 뭘로 넘겨줄것인가  -->
          <th>삭제</th>
          <th>ADD 주소 입력</th>
        </tr>
      </thead>
<%
	ArrayList<Teacher> arrayTeacher = (ArrayList<Teacher>)request.getAttribute("arrayTeacher");
		for(Teacher teacher : arrayTeacher){
%>
      <tbody>
        <tr class="active">
          <th scope="row"><%= teacher.getTeacherNo() %></th>
          <td><%=teacher.getTeacherId() %></td>
          <td>****</td>
          <td><a href="<%= request.getContextPath()%>/UpdateTeacherController.lee?sendNO=<%= teacher.getTeacherNo() %>">수정</a></td>
          <td><a href="<%= request.getContextPath()%>/DeleteTeacherController.lee?sendNO=<%= teacher.getTeacherNo() %>">삭제</a></td>
          <td><a href="<%= request.getContextPath()%>/controller/UpdateTeacherController?sendNO=<%= teacher.getTeacherNo() %>">삭제</a></td>
        </tr>       
      </tbody>
<%
	}
%>
    </table>
  </div>
</body>
</html>