<!-- 27기 3팀 이인호 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> <!-- 배열의 사이즈를 가져올수 있는 jstl taglib -->
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
<%-- <%	
	ArrayList<TeacherAddr> arrayTeacherAddr = (ArrayList<TeacherAddr>)request.getAttribute("arrayTeacherAddr"); 
		int arrayTeacherAddrSize = arrayTeacherAddr.size();	
%> --%>
<script>
	var arrayTeacherAddrSize = ${fn:length(arrayTeacherAddr)}		/*taglib uri="http://java.sun.com/jsp/jstl/functions"를 fn의로 선언해주고*/
	$(document).ready(function(){										/* ArrayList타입의 변수 arrayTeacherAddr의 length를 가져와 변수 arrayTeacherAddrSize에 담는다 */
		if(arrayTeacherAddrSize<5){
			$(".addressAdd").show();
			$(".addressAddText").hide();
		}else{	
			$(".addressAdd").hide();
			$(".addressAddText").show();
			/* alert("주소가 5개 이상일 경우 더는 주소를 추가할수 없습니다. 주소를 삭제해주세요") */
		}	
	});
	
	$(document).ready(function(){
		$("#btn").click(function(){
			$('input[name="checkbox[]"]:checked').each(function(){							
				var text = $(this).val();
				alert("TeacherAddrNo"+text+"삭제");					
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
	<h1>Teacher addr List</h1>
	<div>
  		<button><a href="${pageContext.request.contextPath}/getTeacherList.team3">리스트로 돌아가기</a></button>
	</div>	
	<div class="bs-example" data-example-id="contextual-table">
	    <table class="table">
	      <thead>
	        <tr class="active">
	          <th><input type="checkbox" id="checkboxAll" value="">전체선택</th>
	          <th>teacher number</th>
	          <th>teacher addr number</th>
	          <th>address</th>
	          <th>주소수정</th><!-- teacher num 넘겨줄때 뭘로 넘겨줄것인가  -->
	        </tr>
	      </thead>
	      <form form id="form1" name="form1" method="post" action="${pageContext.request.contextPath}/DeleteTeacherAddrController.team3">
				

		<!-- /* 버튼 만드는 순서  주소 리스트까지 간다
		주소 리스트에서 해당 주소를 클릭할 수 있는 체크 박스들을 만든다
		해당 체크 박스를 클릭했을때 삭제버튼을 누르면 해당 주소 넘버의 자료가 삭제될 수 있게 만든다
		전체 체크 박스를 체크할수 있는 체크 박스를 만든다
		삭제 버튼을 누르면 다수 체크 박스에 있는 데이터가 삭제될 수있게 만든다
		*/
		int teacherNo = (int)session.getAttribute("teacherNo");
		for(TeacherAddr teacherAddr : arrayTeacherAddr){ -->
		
		<c:forEach var="teacherAddr" items="${arrayTeacherAddr}">
	      <tbody>
	        <tr class="active">
	        <!-- form을 for문 안에 넣어 시도해봤지만 submit 했을때 controller까지 데이터가 넘어가지 않음  -->
	       	  <th><input type="checkbox" name="checkbox[]" value="${teacherAddr.teacherAddrNo}"></th>
	        
	          <td scop e="row">${teacherAddr.teacherNo}</td>
	          <td>${teacherAddr.teacherAddrNo}</td>
	          <td>${teacherAddr.address}</td>          
	          <td><a href="${pageContext.request.contextPath}/UpdateTeacherAddrController.team3?sendNO=${teacherAddr.teacherAddrNo}">주소 수정</a></td>
	        </tr>       
	      </tbody>	     
		</c:forEach>
		</form>
		</table>		
  	</div>
  	<div class="addressAdd">
  		<button><a href="${pageContext.request.contextPath}/AddTeacherAddrController.team3?sendNO=${teacherNo}">주소 추가</a></button>
	</div>
	<div class="addressAddText">주소가 5개 이상일 경우 더는 주소를 추가할수 없습니다. 주소를 삭제해주세요</div>
	<div>
  		<button id="btn">주소 삭제</button>
	</div>
</body>
</html>