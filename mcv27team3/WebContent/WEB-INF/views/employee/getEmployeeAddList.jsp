<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import= "model.EmployeeAddr" %>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
<%	
	ArrayList<EmployeeAddr> arrayEmployeeAddr = (ArrayList<EmployeeAddr>)request.getAttribute("arrayEmployeeAddr"); 
		int arrayTeacherAddrSize = arrayEmployeeAddr.size();	
%>
<script>
	var arrayEmployeeAddrSize = <%= arrayTeacherAddrSize %>;
	$(document).ready(function(){			
		if(arrayTeacherAddrSize<5){
			$(".addressAdd").show();
		}else{	
			$(".addressAdd").hide();
		}	
	});
	$(document).ready(function(){
		$("#btn").click(function(){
			$('input:checkbox[name="checkbox[]"]').each(function(){							
				if($(this).is(':checked')){				
					var text = $(this).val();
					alert("TeacherAddrNo"+text+"삭제");					
					$("#form1").submit();					
				}
			});
		});
	});
</script>
</head>
<body>
	<h1>Teacher addr List</h1>
	<div class="addressAdd">
  		<button><a href="<%= request.getContextPath()%>/getTeacherList.lee">리스트로 돌아가기</a></button>
	</div>	
	<div class="bs-example" data-example-id="contextual-table">
	    <table class="table">
	      <thead>
	        <tr class="active">
	          <th><input type="checkbox" name="subject" value="">전체선택</th>
	          <th>teacher number</th>
	          <th>teacher addr number</th>
	          <th>address</th>
	          <th>주소수정</th><!-- teacher num 넘겨줄때 뭘로 넘겨줄것인가  -->
	        </tr>
	      </thead>
	      <form form id="form1" name="form1" method="post" action="<%= request.getContextPath() %>/DeleteTeacherAddrController.lee">
<%				

		/* 버튼 만드는 순서  주소 리스트까지 간다
		주소 리스트에서 해당 주소를 클릭할 수 있는 체크 박스들을 만든다
		해당 체크 박스를 클릭했을때 삭제버튼을 누르면 해당 주소 넘버의 자료가 삭제될 수 있게 만든다
		전체 체크 박스를 체크할수 있는 체크 박스를 만든다
		삭제 버튼을 누르면 다수 체크 박스에 있는 데이터가 삭제될 수있게 만든다
		*/
		int teacherNo = (int)session.getAttribute("teacherNo");
		for(EmployeeAddr teacherAddr : arrayEmployeeAddr){
%>
	      <tbody>
	        <tr class="active">
	        <!-- form을 for문 안에 넣어 시도해봤지만 submit 했을때 controller까지 데이터가 넘어가지 않음  -->
	       	  <th><input type="checkbox" name="checkbox[]" value="<%= teacherAddr.getTeacherAddrNo()%>"></th>
	        
	          <td scop e="row"><%= EmployeeAddrAddrNo() %></td>
	          <td><%=teacherAddr.getTeacherAddrNo() %></td>
	          <td><%=teacherAddr.getAddress() %></td>          
	          <td><a href="<%= request.getContextPath()%>/AddTeacherAddrController.lee?sendNO=<%= teacherAddr.getTeacherNo() %>">주소 수정</a></td>
	        </tr>       
	      </tbody>	     
<%
		}	
%>	
		</form>
		</table>
		
  	</div>
  	<div class="addressAdd">
  		<button><a href="<%= request.getContextPath()%>/AddTeacherAddrController.lee?sendNO=<%= teacherNo %>">주소 추가</a></button>
	</div>
	<div class="addressdelete">
  		<button id="btn">주소 삭제</button>
	</div>
</body>
</html> --%>