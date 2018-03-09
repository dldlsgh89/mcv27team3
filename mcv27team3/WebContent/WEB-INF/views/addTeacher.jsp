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
	$(document).ready(function(){
		$(".form").hide()
		$("#btn2").click(function(){
			$(".form").show()
			$("#btn").click(function(){			
				if($("#teacherId").val().length < 5){
					$("#helper").html("아이디 5자 이상");
				}else if($("#teacherPw").val().length < 5){
					$("#helper").html("비밀번호 5자 이상")
				}else if($("#teacherPwCheck").val() != $("#teacherPw").val()){
					$("#helper").html("동일한 비밀번호를 입력하세요");
				}else{
					$("#myform").submit();
				}					
			});
		});
	});

</script>
</head>

<body>
	<button type="button" id="btn2" class="btn btn-default">가입하기</button>
		<form id="myform" class="form-horizontal form" method="post" action="<%=request.getContextPath()%>/addTeacher.lee">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h2 class="panel-title">addteacher</h2>
				</div>
				<div class="panel-body">
					<div class="form-group" >
						<label for="teacherId" class="col-sm-3 control-label">teacher_id</label>
						<div class="col-sm-8" >
							<input type="text" class="form-control" id="teacherId" name="teacherId" placeholder="id를 입력해주세요">
	
						</div>
					</div>
					<div class="form-group" >
						<label for="teacherPw" class="col-sm-3 control-label">teacher_pw</label>
						<div class="col-sm-8">
							<input type="password" class="form-control" id="teacherPw" name="teacherPw" placeholder="pw를 입력해주세요">
	
						</div>
					</div>
					<div class="form-group" >
						<label for="teacherPwCheck" class="col-sm-3 control-label">teacher_pw확인</label>
						<div class="col-sm-8">
							<input type="password" class="form-control" id="teacherPwCheck" placeholder="pw를 다시 입력해주세요">
	
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<div>
					    	<span id="helper"></span>
					    	</div>		  
							<button type="button" id="btn" class="btn btn-default">확인</button>
						</div>
					</div>
				</div>
			</div>
		</form>	
	
	<%-- <form id="myform" class="form-horizontal" method="post" action="<%=request.getContextPath()%>/addTeacher.lee">
	  <div class="form-group">
	    <label for="teacherid" class="col-sm-3 control-label">teacher_id :</label>
	    <div class="col-sm-5">
	      <input type="text" class="form-control" id="teacherid" name="teacherid" placeholder="id">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="teacherpw" class="col-sm-3 control-label">teacher_pw :</label>
	    <div class="col-sm-5">
	      <input type="password" class="form-control" id="teacherpw" name="teacherpw" placeholder="Password">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="teacherpwcheck" class="col-sm-3 control-label">teacher_pw확인 : </label>
	    <div class="col-sm-5">
	      <input type="password" class="form-control" id="teacherpwcheck" placeholder="Passwordcheck">
	    </div>
	  </div>	
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	    	<div>
	    	<span id="helper"></span>
	    	</div>		  
	      	<button id="btn" type="button" class="btn btn-default" >Sign in</button>
	    </div>
	  </div> --%>
	</form>

</body>
</html>