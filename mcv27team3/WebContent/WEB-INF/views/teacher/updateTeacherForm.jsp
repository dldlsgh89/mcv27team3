<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- UpdateTeacherController클래스의 doGet메서드 실행결과 넘어온 데이터를 사용 -->
	<form action="${pageContext.request.contextPath}/UpdateTeacherController.lee" method="post"> 
	<!-- form태그를 사용하고 post방식으로  UpdateTeacherController.java로 보낸다-->
		<table border="1">
			<tr>
				<td>teacherNo</td>
				<td><input type="text" name="teacherNo" size="20" value="${teacher.teacherNo}" readonly></td> 
				<!-- jstl사용 UpdateTeacherController.java의 doget메서드에서 setAttribute했던 teacher에 접근해 teacherNo를 getting하고 readonly하여 수정 불가능하게 한다  -->
			<tr>
			<tr>
				<td>teacherId</td>
				<td><input type="text" name="teacherId" size="20" value="${teacher.teacherId}"></td>
				<!-- jstl사용 UpdateTeacherController.java의 doget메서드에서 setAttribute했던 teacher에 접근해 teacherId를 getting한다  -->
			<tr>
			<tr>
				<td>teacherPw</td>
				<td><input type="text" name="teacherPw" size="20" value="${teacher.teacherPw}"></td>
				<!-- jstl사용 UpdateTeacherController.java의 doget메서드에서 setAttribute했던 teacher에 접근해 teacherPw를 getting한다  -->
			<tr>
			<tr>
				<td colspan="4"><input type="submit" value="회원수정버튼"></td> 
				<!-- submit시 UpdateTeacherController.java로 이동 -->
			</tr>
		</table>
	</form>
</body>
</html>