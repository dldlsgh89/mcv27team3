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
	$(document).ready(function(){
		$("#btn").click(function(){			
			if($("#teacherid").val().length < 8){
				$("#teacheridhelper").html("아이디 9자 이상");
			}else if($("#teacherid").val().length > 8){
				$("#teacheridhelper").html("");					
				if($("#teacherpw").val().length < 8){
					$("#teacherpwhelper").html("비밀번호 9자 이상")
				}else if($("#teacherpw").val().length > 8){
					$("#teacherpwhelper").html("");
					if($("#teacherpwcheck").val() != $("#teacherpw").val()){
						$("#teacherpwcheckhelper").html("동일한 비밀번호를 입력하세요");
					}else{
						$("#myform").submit();
					}					
				}					
			}			
		});
	});

</script>
</head>

<body>
	<h1>addTeacher</h1>
	<form id="myform" class="form-horizontal" method="post" action="<%=request.getContextPath()%>/addTeacher.lee">
	  <div class="form-group">
	    <label for="teacherid" class="col-sm-2 control-label">teacher_id :</label>
	    <div class="col-sm-5">
	      <input type="text" class="form-control" id="teacherid" placeholder="id"><span id="teacheridhelper"></span>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="teacherpw" class="col-sm-2 control-label">teacher_pw :</label>
	    <div class="col-sm-5">
	      <input type="password" class="form-control" id="teacherpw" placeholder="Password"><span id="teacherpwhelper"></span>
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="teacherpwcheck" class="col-sm-2 control-label">teacher_pw확인 : </label>
	    <div class="col-sm-5">
	      <input type="password" class="form-control" id="teacherpwcheck" placeholder="Passwordcheck"><span id="teacherpwcheckhelper"></span>
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	      <button id="btn" type="button" class="btn btn-default" >Sign in</button>
	    </div>
	  </div>
	</form>



	<%-- <h1>addTeacher</h1>
	<form method="post" action="<%=request.getContextPath()%>/addTeacher.lee">
		teacher_id :
		<input type="text" id="teacherid" name="teacherid" class="">
		teacher_pw :
		<input type="password" id="teacherpw" name="teacherpw" class="">
		teacher_pw확인 : 
		<input type="password" id="teacherpwcheck" name="teacherpwcheck" class="">
		<button type="button">교사 추가</button>
	</form> --%>
</body>
</html>