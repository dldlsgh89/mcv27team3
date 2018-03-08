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
			$("#btn").click(function() {
				if($("#studentid").val() != null) {
					
					if($("#studentid").val().length < 5) {
						$("#studentidHelper").text("5���̻� �ۼ����ֽʽÿ�.");
						return;
					}else if($("#studentid").val().length >= 5) {
						$("#studentidHelper").text("");
					}

				if($("#studentpw").val() != null) {
					if($("#studentpw").val().length < 10) {
						$("#studentpwHelper").text("10���̻� �ۼ����ֽʽÿ�.");
					}else if($("#studentpw").val().length >= 10) {
						$("#studentpwHelper").text("");
					}
				if($("#studentpwcheck").val() != $("#studentpw").val()) {
					$("#studentpwcheckHelper").text("pw�� ��ġ���� �ʽ��ϴ�..");
					return;
				}else {
					$("#myform").submit();
						} 
					}		
				}
			});	
		}); 				
	</script>

</head>
<body>
	<h1>addStudent</h1>
	
	<form class="form-horizontal" method="post" action="<%=request.getContextPath()%>/addStudent.lim">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">student_id</label>
    <div class="col-sm-5">
      <input type="text" class="form-control" id="studentid" placeholder="id�� �Է����ּ���">
      <span id="studentidHelper"></span>
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">student_pw</label>
    <div class="col-sm-5">
      <input type="password" class="form-control" id="studentpw" placeholder="pw�� �Է����ּ���">
      <span id="studentpwHelper"></span>
    </div>
  </div>
    <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">student_pwȮ��</label>
    <div class="col-sm-5">
      <input type="password" class="form-control" id="studentpwcheck" placeholder="pw�� �ٽ� �Է����ּ���">
      <span id="studentpwcheckHelper"></span>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="button" id="btn" class="btn btn-default">�л�Ȯ��</button>
    </div>
  </div>
</form>
	
	
	
	
	<%-- <form method="post" action="<%=request.getContextPath()%>/addStudent.Lim">
		student_id :
		<input type="text" id="studentid" name="studentid" class=""><span id="studentidHelp"></span>
		student_pw :
		<input type="password" id="studentpw" name="studentpw" class=""><span id="studentpwHelp"></span>
		student_pwȮ�� : 
		<input type="password" id="studentpw" name="studentpw" class=""><span id="studentpwHelp"></span>
		<button type="button" id="btn">�л� �߰�</button>
	</form> --%>
	
	
	
</body>
</html>