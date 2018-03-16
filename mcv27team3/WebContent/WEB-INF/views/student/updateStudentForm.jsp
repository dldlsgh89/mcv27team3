<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import= "model.Student"  %>
<!DOCTYPE html>

<%

Student student = (Student)request.getAttribute("student");
System.out.println(student + "<<---------- updateStudentForm.jsp");

%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>m_update_form.jsp</title>
</head>
<body>

	<form action="<%= request.getContextPath() %>/UpdateStudentController.lim" method="post">
		<table border="1">
			<tr>
				<td>학생번호</td>
				<td><input type="text" name="studentNo" size="20" value="<%= student.getStudentNo() %>" readonly></td>
			<tr>
			<tr>
				<td>학생아이디</td>
				<td><input type="text" name="studentId" size="20" value="<%= student.getStudentId() %>"></td>
			<tr>
			<tr>
				<td>학생비밀번호</td>
				<td><input type="text" name="studentPw" size="20" value="<%= student.getStudentPw() %>"></td>
			<tr>
			<tr>
				<td colspan="4"><input type="submit" value="회원수정버튼"></td>
			</tr>
		</table>
	</form>

</body>
</html>