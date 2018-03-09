package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeDao {
// �ʱ�ȭ
Connection connection;
PreparedStatement preparedstatement;

//Insert try catch �� ���
public void InsertEmployee(Employee employee) {
	//3�ܰ� ���������غ� ���� ����
	String employeeId = employee.getEmployeeId();
	System.out.println(employeeId+"<--insertEmployee");
	String employeePw = employee.getEmployeePw();
	
	
	try {
		connection = DriveDB.driverdbCon();
		
		preparedstatement = connection.prepareStatement("INSERT INTO employee(employee_no, employee_id, employee_pw)VALUES (0, ?, ?)");
		preparedstatement.setString(1, employeeId);
		preparedstatement.setString(2, employeePw);;
		
		preparedstatement.executeUpdate();
			
	} catch (SQLException ex) {	
			ex.getMessage();
	} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
	} finally {
		if(preparedstatement != null) try{preparedstatement.close();} catch(SQLException ex) {}
		if(connection != null) try{connection.close();} catch(SQLException ex) {}	
		
		}
	
	}
}
