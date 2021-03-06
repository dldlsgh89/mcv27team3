<!-- 27기 3팀 임가현 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--	
	<c:img>
 --%>
<%-- taglib java code -> 태그 --%>
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
		<!-- <a href="<%=request.getContextPath()%> -->
		<li role="presentation"><a href="${pageContext.request.contextPath}/addStudent.team3">회원가입</a></li>
	</ul>
	
	<div class="bs-example" data-example-id="contextual-table">
		<table class="table">
			<thead>
				<tr class="active">
					<th>student No</th>
					<th>student ID</th>
					<th>student PW</th>
					<th>Add student_Addr</th> <!-- StudentAddrDao.insertStudentAddr -->
					<th>수정</th><!-- StudentDao.update / studentNO=? -->
					<th>삭제</th><!-- StudentDao.delete -->
				</tr>
			</thead>
			<c:forEach var="student" items="${arrayStudent}">
				<tbody>
					<tr class="active">
						<td scope="row">${student.studentNo}</td>
						<td>${student.studentId}</td>
						<td>****</td>
						<td><a href="${pageContext.request.contextPath}/GetStudentAddrListController.team3?sendNO=${student.studentNo}">주소확인</a></td>
						<td><a href="${pageContext.request.contextPath}/UpdateStudentController.team3?sendNO=${student.studentNo}">수정</a></td>
						<td><a href="${pageContext.request.contextPath}/DeleteStudentController.team3?sendNO=${student.studentNo}">삭제</a></td>
					</tr>
				</tbody>
			</c:forEach>	
		</table>
		
		<button><a href="${pageContext.request.contextPath}/getStudentList.team3">처음으로</a></button>
		<c:if test="${currentPage > 1}">
		<button><a href="${pageContext.request.contextPath}/getStudentList.team3?currentPage=${currentPage-1}">이전</a></button> <!-- 현재페이지 -1 -->
		</c:if>
		
		<c:forEach var="iCount" begin="${startPage}" end="${endPage}">
			<button><a href="${pageContext.request.contextPath}/getStudentList.team3?currentPage=${iCount}">${iCount}</a></button>	
		</c:forEach>
		
		<c:if test="${currentPage < totalPage}">
		<button><a href="${pageContext.request.contextPath}/getStudentList.team3?currentPage=${currentPage+1}">다음</a></button> <!-- 현재페이지 +1 -->
		<button><a href="${pageContext.request.contextPath}/getStudentList.team3?currentPage=${totalPage}">마지막으로</a></button>
		</c:if>
	</div>
</body>
</html>