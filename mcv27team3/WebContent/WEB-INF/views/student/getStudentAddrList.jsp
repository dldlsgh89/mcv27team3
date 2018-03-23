<!-- 27기 3팀 임가현 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Student List</title>
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
			var arrayStudentAddrSize = ${fn:length(arrayStudentAddr)}
			$(document).ready(function(){			
				if(arrayStudentAddrSize<5){
					$(".addressAdd").show();
					$(".addressAddText").hide();
				}else{	
					$(".addressAdd").hide();
					$(".addressAddText").show();
				}	
			});
			
			$(document).ready(function(){
				$("#btn").click(function(){
					$('input[name="checkbox[]"]:checked').each(function(){							
						var text = $(this).val();
						alert("StudentAddrNo"+text+"삭제");					
						$("#form1").submit();				
					});
				});
			});
			
			$(document).ready(function(){
				$("#checkboxAll").click(function(){
					if($(this).prop("checked")){
						$("input[type=checkbox]").prop("checked",true);
					}else{
						$("input[type=checkbox]").prop("checked",false);
					}
				});
			});
			
		</script>
	</head>
	<body>
		<h1>Student Addr List</h1>
		<ul class="nav nav-pills">
			<li role="presentation"><a href="${pageContext.request.contextPath}/getStudentList.team3">회원리스트</a></li>
		</ul>
		<div class="bs-example" data-example-id="contextual-table">
			<table class="table">
				<thead>
					<tr class="active">
						<th><input type="checkbox" id="checkboxAll" value="">전체선택</th>
						<th>학생번호</th>
						<th>주소번호</th>
						<th>학생주소</th>
						<th>수정</th><!-- StudentDao.update / studentNO=? -->
					</tr>
				</thead>
				<form id="form1" name="form1" method="post" action="${pageContext.request.contextPath}/DeleteStudentAddrController.team3">
					<c:forEach var="studentAddr" items="${arrayStudentAddr}">
						<tbody>
							<tr class="active">
								<th scop e="row"><input type="checkbox" name="checkbox[]" value="${studentAddr.studentAddrNo}"></th>
								<td>${studentAddr.studentNo}</td>
								<td>${studentAddr.studentAddrNo}</td>
								<td>${studentAddr.address}</td>
								<td><a href="${pageContext.request.contextPath}/UpdateStudentAddrController.team3?sendNo=${studentAddr.studentAddrNo}">수정</a></td>
							</tr>
						</tbody>
					</c:forEach>
				</form>
			</table>
		</div>
		<div class="addressAdd">
			<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/AddStudentAddrController.team3?sendNO=${studentNo}'">주소추가</button>
	  	</div>
		<div class="addressAddText">
			더 이상 주소를 추가할수 없습니다. 주소를 삭제해주세요
		</div>
		<div class="addressdelete">
	  		<button type="button" class="btn btn-default" id="btn">주소 삭제</button>
		</div>
	</body>
</html>