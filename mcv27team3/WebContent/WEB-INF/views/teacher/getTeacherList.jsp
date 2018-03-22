<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- taglib java code-> 태그처럼 표현  -->

<%-- <!--  

<%= %> 
EL 사용
<%=request.getAttribute("x")%>  --> ${x}
<%=session.getAttribute("x")%>  --> ${y}
<%=m.getNo()%>  -->  ${m.No}

--> --%>

<!DOCTYPE html>
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
<body>
	<h1>Teacher List</h1>
	<button><a href="${pageContext.request.contextPath}/addTeacher.lee">가입하기</a></button>
	<div class="bs-example" data-example-id="contextual-table">
	    <table class="table">
			<thead>
				<tr class="active">
					<th>teacher number</th>
					<th>teacher ID</th>
					<th>teacher PW</th>
					<th>주소</th><!-- teacher num 넘겨줄때 뭘로 넘겨줄것인가  -->
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>

	<%--  //ArrayList<Teacher> arrayTeacher = (ArrayList<Teacher>)request.getAttribute("arrayTeacher");
	// ${list}
	for(Teacher teacher : arrayTeacher){ --%>
			<c:forEach var="teacher" items="${arrayTeacher}">
				<tbody>
					<tr class="active">
						<th scope="row">${teacher.teacherNo}</th>
						<td>${teacher.teacherId}</td>
						<td>****</td>       
						<td><a href="${pageContext.request.contextPath}/GetTeacherAddrListController.lee?sendNO=${teacher.teacherNo}">주소List</a></td>
						<td><a href="${pageContext.request.contextPath}/UpdateTeacherController.lee?sendNO=${teacher.teacherNo}">수정</a></td>
						<td><a href="${pageContext.request.contextPath}/DeleteTeacherController.lee?sendNO=${teacher.teacherNo}">삭제</a></td>
					</tr>       
				</tbody>
			</c:forEach>
	    </table>
	</div>
</body>
</html>