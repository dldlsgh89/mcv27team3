<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>addEmployee</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script type="text/javascript">

	$(document).ready(function() {
		$("#btn").click(function() {
			if($("#employeeid").val() != null) {
				
				if($("#employeeid").val().length < 5) {
					$("#nameHelper").text("5자이상 작성해주십시요.");
					return;
				}else if($("#employeeid").val().length >= 5) {
					$("#nameHelper").text("");
				}
				}if($("#pwd").val() != null){
					var getPwd = document.getElementById("pwd").value;
					console.log("getPwd: + getPwd");
					}else if($("#pwdch").val()!=null){
					getPwd!=getPwdCh
					document.getElementById("txt").innerHTML = "<font color = 'Red'>비밀번호가 일치하지 않습니다</font>";
					}else{
						document.getElementById("txt").innerHTML = "";	
					}
			});
		});
	/* $(document).ready(function(){
		$("#btn").click(function(){
			if($("#name").val().length <3) {
				$("#nameHelper").text("이름은 3자 이상");
				return;
			
			}else if{			
	function aa(){}
		var getPwd = document.getElementById("pwd").value;
		console.log("getPwd : + getPwd");
			}else if{(getPwd!=getPwdCh){
			document.getElementById("txt").innerHTML = "<font color='Red'>비밀번호가 일치하지 않습니다.</font>";
			}else{
				document.getElementById("txt").innerHTML = "";
		}
	}
		} */
	
</script>
</head>
<body>

	 <h1>addEmployee</h1>
	<form method="post" action="<%=request.getContextPath()%>/addEmployee.pjh">
	<div>
		employee_id:
		<input type="text" id="employeeid" class="">
		<span id="nameHelper"></span>
	</div> 
	employee_pw:
	<input type="password" name="pw" id="pwd" class="">
	employee_pw확인:
	<input type="password" name="pwdCh" id="pwdch" class="" onkeyup="aa()">
	<p>
	<span id="txt"></span>
	</p>
	<button type="button"id="btn">직원추가</button>
	</form> 
</body>
</html>