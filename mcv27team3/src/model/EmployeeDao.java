package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeDao {
// 초기화
Connection connection = null;
PreparedStatement preparedstatement = null;
ResultSet resultset = null;

//Insert try catch 문 사용
public void InsertEmployee(Employee employee) {
	//3단계 쿼리실행준비 부터 시작
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
	public ArrayList<Employee> selectEmployee() {
		ArrayList<Employee> arraylist = new ArrayList<Employee>();
		
		try {
			connection = DriveDB.driverdbCon();
			
			preparedstatement = connection.prepareStatement("select * from employee");
			resultset = preparedstatement.executeQuery();			
			
			while(resultset.next()) {
				System.out.println("selectemployee 연결");
				Employee employee = new Employee();
				employee.setEmployeeNo(Integer.parseInt(resultset.getString("employee_no")));
				employee.setEmployeeId(resultset.getString("employee_id"));
				employee.setEmployeePw(resultset.getString("employee_pw"));
				arraylist.add(employee);	
				System.out.println(arraylist + "<-- arraylist 출력");
			}
			for(Employee employee : arraylist) {
				System.out.println(employee.getEmployeeId());
				System.out.println(employee.getEmployeePw());
			}
		}catch (SQLException ex) {
			ex.getStackTrace();
			System.out.println(ex.getMessage());	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			if(resultset != null) try {resultset.close();} catch(SQLException ex) {}
			if(preparedstatement == null) try {preparedstatement.close();} catch(SQLException ex) {}
			if(connection == null) try {connection.close();} catch(SQLException ex) {}
		}
		return arraylist;

	}
	public int updateEmployee(Employee employee) {
		return 0;
	}
		
	public int deleteEmployee(int employee) {
		return 0;
	}
		

	}

