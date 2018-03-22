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
			var arrayStudentAddrSize = ${fn:length(arrayStudentAddr)};
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
			<li role="presentation"><a href="${pageContext.request.contextPath}/getStudentList.lim">회원리스트</a></li>
		</ul>
		<div class="bs-example" data-example-id="contextual-table">
			<table class="table">
				<thead>
					<tr class="active">
						<th style="text-align: center">student addr no</th>
						<th style="text-align: center">student no</th>
						<th style="text-align: center">address</th>
						<th style="text-align: center">수정</th><!-- StudentDao.update / studentNO=? -->
					</tr>
				</thead>
				<form>
					<c:forEach var="StudentAddr" items="arrayStudentAddr">
						<tbody>
							<tr class="active">
								<th scop e="row">${studentAddr.StudentNo}</th>
								<td>${studentAddr.StudentNo}</td>
								<td>${studentAddr.address}</td>
								<td><a href="${pageContext.request.contextPath}/UpdateStudentAddrController.lim??sendNO=${studentAddr.StudentNo}">수정</a></td>
							</tr>
						</tbody>
					</c:forEach>
				</form>
			</table>	
		</div>
		<div class="addressAdd">
	  		<button><a href="${pageContext.request.contextPath}/AddStudentAddrController.lim?sendNo=${sendNO}">주소 추가</a></button>
		</div>
		<div class="addressAddText">
			주소가 5개 이상일 경우 더는 주소를 추가할수 없습니다. 주소를 삭제해주세요
		</div>
		<div class="addressdelete">
	  		<button id="btn">주소 삭제</button>
		</div>
	</body>
</html>