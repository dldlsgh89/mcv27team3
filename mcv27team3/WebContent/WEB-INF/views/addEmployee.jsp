<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>addEmployee</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
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

	<script>

/* 	$(document).ready(function() {
		$("#btn").click(function() {
				if($("#employeeId").val().length < 5) {
					$("#nameHelper").text("5���̻� �ۼ����ֽʽÿ�.");
					
				}else if($("#employeeId").val().length >= 5) {
					$("#nameHelper").text("");
				//var check = $("#pwd").val();
					if ($("#pwdch").val() != $("#pwd").val())){
					$("#pwHelper").text("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
					} else {
						$("#pwHelper").text("");
						$("#myform").submit();
					}
				}
			});
		});
		 */
		$(document).ready(function(){
				$("#btn").click(function(){			
					if($("#employeeId").val().length < 5){
						$("#nameHelper").html("���̵� 5�� �̻�");
					}else if($("#pwd").val().length < 5){
						$("#nameHelper").html("��й�ȣ 5�� �̻�")
					}else if($("#pwdch").val() != $("#pwd").val()){
						$("#pwHelper").html("������ ��й�ȣ�� �Է��ϼ���");
					}else{
						$("#myform").submit();
					}					
				});
			
		});
	</script>
</head>
<body>
	<form id="myform" class="form-horizontal form" method="post" action="<%=request.getContextPath()%>/addEmployee.pjh">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h1 class="panel-title">addEmployee</h1>
			</div>
			<div class="panel-body">
				<div class="form-group" >
					<label for="studentId" class="col-sm-3 control-label">employee_id</label>
					<div class="col-sm-8" >
						<input type="text" class="form-control" id="employeeId" name="employeeId" placeholder="id�� �Է����ּ���">
						<span id="nameHelper"></span>
					</div>
				</div>
				<div class="form-group" >
					<label for="studentPw" class="col-sm-3 control-label">employee_pw</label>
					<div class="col-sm-8">
						<input type="password" class="form-control" name="pwd" id="pwd" placeholder="pw�� �Է����ּ���">
						
					</div>
				</div>
				<div class="form-group" >
					<label for="pwdch" class="col-sm-3 control-label">employee_pwȮ��</label>
					<div class="col-sm-8">
						<input type="password" class="form-control" id="pwdch" placeholder="pw�� �ٽ� �Է����ּ���">
						<span id="pwHelper"></span>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="button" id="btn" class="btn btn-default">����Ȯ��</button>
					</div>
				</div>
			</div>
		</div>
	</form>	

	 <%--  <h1>addEmployee</h1>
	<form method="post" action="<%=request.getContextPath()%>/addEmployee.pjh">
		employee_id:
			<input type="text" id="employeeid" class="">
			<span id="nameHelper"></span>
		employee_pw:
			<input type="password" name="pwd" id="pwd" class="">
		employee_pwȮ��:
			<input type="password" name="pwdCh" id="pwdch" class="">
			<span id="pwHelper"></span>
			
		<button type="button"id="btn">�����߰�</button>
	</form>  --%>
</body>
</html>