package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeAddrDao {

	Connection connection = null;
	PreparedStatement preparedstatement = null;
	ResultSet resultset = null;
	
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
}
