/*package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeAddrDao {

	Connection connection = null;
	PreparedStatement preparedstatement = null;
	ResultSet resultset = null;
	ArrayList<EmployeeAddr> arrayEmployeeAddr;
	Employee employee;
	
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
	
	public ArrayList<EmployeeAddr> selectEmployeeAddr() {
		arrayEmployeeAddr = new ArrayList<EmployeeAddr>();
		
		try {
			connection = DriveDB.driverdbCon();
			
			preparedstatement = connection.prepareStatement("select * from employee_addr");
			resultset = preparedstatement.executeQuery();			
			
			while(resultset.next()) {
				
				StudentAddr studentAddr = new StudentAddr();
				studentAddr.setStuedentAddrNo(resultset.getInt("student_addr_no"));
				studentAddr.setStudentNo(resultset.getInt("student_no"));
				studentAddr.setAddress(resultset.getString("address"));
				arrayStudentAddr.add(studentAddr);	
				
			}
			return arrayStudentAddr;
			
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

}
}

*/