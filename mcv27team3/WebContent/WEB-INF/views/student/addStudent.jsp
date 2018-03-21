<!-- 27기 3팀 임가현 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addStudent</title>
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


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			$("#btn").click(function() {	
				if($("#studentId").val().length < 5) {
					$("#studentIdHelper").text("5자이상 작성해주십시요.");
					return;
				}else $("#studentidHelper").text("");
	
				if($("#studentPw").val().length < 5) {
					$("#studentPwHelper").text("5자이상 작성해주십시요.");
					return;
				}else $("#studentPwHelper").text("");
				
				if($("#studentPwCheck").val() != $("#studentPw").val()) {
					$("#studenPpwCheckHelper").text("pw가 일치하지 않습니다.");
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
						<input type="text" class="form-control" id="studentId" name="studentId" placeholder="id를 입력해주세요">
						<span id="studentIdHelper"></span>
					</div>
				</div>
				<div class="form-group" >
					<label for="studentPw" class="col-sm-3 control-label">student_pw</label>
					<div class="col-sm-8">
						<input type="password" class="form-control" id="studentPw" name="studentPw"  placeholder="pw를 입력해주세요">
						<span id="studentPwHelper"></span>
					</div>
				</div>
				<div class="form-group" >
					<label for="studentPwcheck" class="col-sm-3 control-label">student_pw확인</label>
					<div class="col-sm-8">
						<input type="password" class="form-control" id="studentPwCheck" placeholder="pw를 다시 입력해주세요">
						<span id="studentPwCheckHelper"></span>
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

