<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import= "model.Student"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
				<td>�л���ȣ</td>
				<td><input type="text" name="studentNo" size="20" value="<%= student.getStudentNo() %>" readonly></td>
			<tr>
			<tr>
				<td>�л����̵�</td>
				<td><input type="text" name="studentId" size="20" value="<%= student.getStudentId() %>"></td>
			<tr>
			<tr>
				<td>�л���й�ȣ</td>
				<td><input type="text" name="studentPw" size="20" value="<%= student.getStudentPw() %>"></td>
			<tr>
			<tr>
				<td colspan="4"><input type="submit" value="ȸ��������ư"></td>
			</tr>
		</table>
	</form>

</body>
</html>