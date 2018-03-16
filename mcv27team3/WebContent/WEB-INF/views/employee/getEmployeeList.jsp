<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "model.Employee" %>
<%@ page import = "model.EmployeeDao" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
	<h1>직원목록</h1>
		<table border="1" type = "text" value = "">
			<tr>
			<td>직원No</td>
			<td>직원ID</td>
			<td>수정</td><!-- GuestDao.updateGuest() -->
			<td>삭제</td><!-- GuestDAo,deleteGuest() -->
			<td>ADD Guest_ADDR</td><!-- GuestAddrDao.insertGuestAddr() -->
			</tr>
			<%
				ArrayList<Employee> arrayEmployee = (ArrayList<Employee>)request.getAttribute("arrayEmployee");
				for(Employee employee : arrayEmployee) {
					
				
			%>			
				<tr>
					<td><%=employee.getEmployeeNo() %></td>
					<td><%=employee.getEmployeeId() %></td>
					<td>*****</td>
					<td><a href="<%=request.getContextPath()%>/AddEmployeeAddrController.pjh?employeeNo=<%=employee.getEmployeeNo() %>">주소추가</a></td>
					<td><a href="<%=request.getContextPath()%>/UpdateEmployeeController.pjh?employeeNo=<%=employee.getEmployeeNo() %>">수정</a></td>
					<td><a href="<%=request.getContextPath()%>/modifyEmployee.jjdev?employeeNo>=">삭제</a></td>
					
				</tr>
			<%
				}
			%>
			
	
	</table>
</html>