<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>addStudent</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		//폼 유효성 검사 후 폼을 submit
	});

</script>

</head>
<body>
	<h1>addStudent</h1>
	<form method="post" action="<%=request.getContextPath()%>/addStudent.Lim">
		student_id :
		<input type="text" id="studentid" name="studentid" class="">
		student_pw :
		<input type="password" id="studentpw" name="studentpw" class="">
		student_pw확인 : 
		<input type="password" id="studentpw" name="studentpw" class="">
		<button type="button">학생 추가</button>
	</form>
</body>
</html>