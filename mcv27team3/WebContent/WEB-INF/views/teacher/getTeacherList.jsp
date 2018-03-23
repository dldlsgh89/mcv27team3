<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- taglib java code-> 태그처럼 표현  -->

<%-- 
<%= %> 
EL 사용
<%=request.getAttribute("x")%>  --> ${x}
<%=session.getAttribute("x")%>  --> ${y}
<%=m.getNo()%>  -->  ${m.No}--%>

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
	<button><a href="${pageContext.request.contextPath}/addTeacher.team3">가입하기</a></button>  <!-- 가입입력화면인 addTeacher.jsp로 forward해주는 addTeacherController로 연결시킨 버튼 -->
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
			<c:forEach var="teacher" items="${arrayTeacher}">	<!-- jstl사용 GetTeacherListController에서 setAttribute한  arrayTeacher를 가져와 arrayTeacher.size만큼 for문을 돌려주고 각 참조값을  Teacher참조타입변수 teacher에 담는다 -->
				<tbody>
					<tr class="active">
						<th scope="row">${teacher.teacherNo}</th> <!-- 참조된 teacher에 접근해  내부에 setting된 teacherNo변수를 가져온다-->
						<td>${teacher.teacherId}</td>
						<td>****</td>       
						<td><a href="${pageContext.request.contextPath}/GetTeacherAddrListController.team3?sendNO=${teacher.teacherNo}">주소List</a></td>  <!-- teacher객체의 teacherNo변수 값을 sendNO에 담아 model에 속하는 selectTeacherAddr메서드를 실행해 해당teacherNo가 포함된 teacher_addr테이블을 전부 select하고 veiw에 속하는 getTeacherAddrList.jsp로 forward해주는 GetTeacherAddrListController로 보낸다 -->
						<td><a href="${pageContext.request.contextPath}/UpdateTeacherController.team3?sendNO=${teacher.teacherNo}">수정</a></td>	<!-- teacher객체의 teacherNo변수 값을 sendNO에 담아 model에 속하는 teacherSelectforUpdate메서드를 실행해 해당 teacherNo에 데이터만 select하고 veiw에 속하는 updateTeacherForm.jsp로 forward해주는 UpdateTeacherController로 보낸다 -->
						<td><a href="${pageContext.request.contextPath}/DeleteTeacherController.team3?sendNO=${teacher.teacherNo}">삭제</a></td>	<!-- teacher객체의 teacherNo변수 값을 sendNO에 담아 model에 속하는 deleteTeacher메서드를 실행해 해당 teacherNo의 데이터를 delete하고 veiw에 속하는 getTeacherList.jsp로 redirect해주는 DeleteTeacherController로 보낸다 -->
					</tr>       
				</tbody>
			</c:forEach>
	    </table>
		<a href="${pageContext.request.contextPath}/getTeacherList.team3?currentPage=${currentPage-1}">처음으로</a>
		<c:if test="${currentPage > 1}">
			<button><a href="${pageContext.request.contextPath}/getTeacherList.team3?currentPage=${currentPage-1}">이전</a></button>
		</c:if>
		<%-- <c:if test="${currentPage < lastPage}"> --%>
			<button><a href="${pageContext.request.contextPath}/getTeacherList.team3?currentPage=${currentPage+1}">다음</a></button>
		<%-- </c:if> --%>
		<a href="${pageContext.request.contextPath}/getTeacherList.team3?currentPage=${currentPage-1}">마지막으로</a>
	</div>
</body>
</html>