<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>addStudent</title>
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
		$(document).ready(function() {
			$("#btn").click(function() {	
				if($("#studentid").val().length < 5) {
					$("#studentidHelper").text("5자이상 작성해주십시요.");
					return;
				}else $("#studentidHelper").text("");
	
				if($("#studentpw").val().length < 8) {
					$("#studentpwHelper").text("8자이상 작성해주십시요.");
					return;
				}else $("#studentpwHelper").text("");
				
				if($("#studentpwcheck").val() != $("#studentpw").val()) {
					$("#studentpwcheckHelper").text("pw가 일치하지 않습니다.");
				}else {
					$("#myform").submit();
					} 
						
		});	
	}); 				
	</script>

</head>
<body>
	
	<form id="myform" class="form-horizontal form" method="post" action="<%=request.getContextPath()%>/addStudent.lim">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h2 class="panel-title">addStudent</h2>
			</div>
			<div class="panel-body">
				<div class="form-group" >
					<label for="studentId" class="col-sm-3 control-label">student_id</label>
					<div class="col-sm-8" >
						<input type="text" class="form-control" id="studentid" placeholder="id를 입력해주세요">
						<span id="studentidHelper"></span>
					</div>
				</div>
				<div class="form-group" >
					<label for="studentPw" class="col-sm-3 control-label">student_pw</label>
					<div class="col-sm-8">
						<input type="password" class="form-control" id="studentpw" placeholder="pw를 입력해주세요">
						<span id="studentpwHelper"></span>
					</div>
				</div>
				<div class="form-group" >
					<label for="studentPwcheck" class="col-sm-3 control-label">student_pw확인</label>
					<div class="col-sm-8">
						<input type="password" class="form-control" id="studentpwcheck" placeholder="pw를 다시 입력해주세요">
						<span id="studentpwcheckHelper"></span>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="button" id="btn" class="btn btn-default">학생확인</button>
					</div>
				</div>
			</div>
		</div>
	</form>	
</body>
</html>

