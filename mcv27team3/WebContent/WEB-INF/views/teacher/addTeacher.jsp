<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
		/* 기본적으로 class= form은 전체가 hide 되어있다가 버튼 btn2을 클릭하는 순간 show이벤트가 실행된다.
		input박스 teacherId는 AddTeacherController의  매개변수 teacherId로 가게되며 입력길이가 5자 이상 되지 않으면 
		#helper의 위치에 "아이디 5자 이상"이상이라는 텍스트가 띄워지게 된다.
		input박스 teacherPw는 AddTeacherController의  매개변수 teacherPw로 가게되며 입력길이가 5자 이상 되지 않으면 
		#helper의 위치에 "비밀번호 5자 이상"이상이라는 텍스트가 띄워지게 된다.
		input박스 teacherPwCheck는   teacherPw와 동일한 데이터를 받게 되며 입력데이터가 teacherPw와 일치 하지 않을시 
		#helper의 위치에 "동일한 비밀번호를 입력하세요"이상이라는 텍스트가 띄워지게 된다.
		 각각의 텍스트는 #helper라는 태그공간에 나타나기 때문에 조건이 맞지 않는 순서대로 나타나게 되며 동시에 존재할수 없다 
		 모든 조건에 일치할시 id가 "myform" form이 /addTeacher.lee로 submit하게 되는데 기본적으로 해당경로는 
		 controller.AddTeacherController.java로 맴핑해둔 상태기 때문에 AddTeacherController.java로 submit
		 되며 get 방식이 아닌 post 방식으로 전송한 상태기 때문에 doPost로 입력되게 된다		
		*/
			
</script>
</head>

<body>
		<form id="myform" class="form-horizontal form" method="post" action="${pageContext.request.contextPath}/addTeacher.team3">  <!--  -->
			<div class="panel panel-default">
				<div class="panel-heading">
					<h2 class="panel-title">teacher 가입양식</h2>
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
</body>
</html>