package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeAddrDao {

	Connection connection = null;
	PreparedStatement preparedstatement = null;
	ResultSet resultset = null;
	
	public int InsertEmployeeAddr(int EmployeeNo, String employeeAddr) {
		System.out.println(EmployeeNo+"<---------addTeacherAddress");
		try {
			connection = DriveDB.driverdbCon();
			preparedstatement = connection.prepareStatement("INSERT INTO employee_addr(employee_addr_no, employee_no, address) VALUES (null, ?, ?)");
			preparedstatement.setInt(1, EmployeeNo);
			preparedstatement.setString(2, employeeAddr);
			preparedstatement.executeUpdate();
			
				
		} catch (SQLException ex) {	
				ex.getMessage();
		} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
		} finally {
		if(preparedstatement != null) try{preparedstatement.close();} catch(SQLException ex) {}
		if(connection != null) try{connection.close();} catch(SQLException ex) {}	
		
		}
		return EmployeeNo;
	}
}
