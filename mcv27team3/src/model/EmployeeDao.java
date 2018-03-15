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
Employee employee = null;

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
		}		return arraylist;
		}
		
	public Employee SelectforUpdate(int employeeNo){
		System.out.println("04 한명회원 조회 mSelectforUpdate Mdao.java");
		System.out.println("employeeNo : "+ employeeNo);
		
		try {
		connection = DriveDB.driverdbCon();
		preparedstatement = connection.prepareStatement("select * from employee WHERE employee_no=?");
		preparedstatement.setInt(1, employeeNo);
		resultset = preparedstatement.executeQuery();
		if(resultset.next()) {
			System.out.println("쿼리 실행 결과 있나? mSelectforUpdate Mdao.java");
			employee = new Employee();
			employee.setEmployeeNo(resultset.getInt("employee_no"));
			employee.setEmployeeId(resultset.getString("employee_id"));
			employee.setEmployeePw(resultset.getString("employee_pw"));
				
		}
			return employee;
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
		
		return null;
	}
		
		public void UpdateEmployee(Employee employee) {
			//3단계 쿼리실행준비 부터 시작
			String employeeId = employee.getEmployeeId();
			System.out.println(employeeId+"<--UpdateEmployee");
			String employeePw = employee.getEmployeePw();
			
			try {
				connection = DriveDB.driverdbCon();
				/*conn = ds.getConnection();
				pstmt = conn.prepareStatement("UPDATE ORACLE_MEMBER SET Ora_pw=?, Ora_level=?, Ora_name=?, Ora_email=? WHERE Ora_id= ?");
				pstmt.setString(1, m.getOra_pw());
				pstmt.setString(2, m.getOra_level());
				pstmt.setString(3, m.getOra_name());
				pstmt.setString(4, m.getOra_email());
				pstmt.setString(5, m.getOra_id());
				pstmt.executeUpdate();
				pstmt.close();
				conn.close();*/
				preparedstatement = connection.prepareStatement("UPDATE employee SET employee_id=?, employee_pw=? WHERE employee_no= ?");
				preparedstatement.setString(1, employee.getEmployeeId());
				preparedstatement.setString(2, employee.getEmployeePw());
				preparedstatement.setInt(3, employee.getEmployeeNo());
				
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
	
		
	public int deleteEmployee(int employee) {
		return 0;
	}
		

	}

