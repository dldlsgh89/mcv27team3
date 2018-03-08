<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>addEmployee</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script>
	(document).ready(function() {
		//폼 유효성 검사 후 폼을 submit
	});
	</script>
</head>
<body>
	<h1>addEmployee</h1>
	<form method="post" action="<%=request.getContextPath()%>/addEmployee.pjh"]>
	employee_id:
	<input type="text" id="employeeid" name="employeeid" class="">
	employee_pw:
	<input type="password" id="employeepw" name="employeepw" class="">
	employee_pw확인:
	<input type="password" id="employeepwcheck" name="employeepwcheck" class="">
	<button type="button">직원추가</button>
	</form>
</body>
</html>