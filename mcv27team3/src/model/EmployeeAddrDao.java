package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeAddrDao {

	Connection connection;
	PreparedStatement preparedstatement;
	ResultSet resultset;
	EmployeeAddr employeeAddr;
	ArrayList<EmployeeAddr> arrayEmployeeAddr;
	Employee employee;
	
	public void InsertEmployeeAddr(int EmployeeNo, String employeeAddr) {
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
		
	}
	
	public ArrayList<EmployeeAddr> selectEmployeeAddr(int sendNO) {
		
		System.out.println(sendNO+"<---- selectEmployeeAddr");
		arrayEmployeeAddr = new ArrayList<EmployeeAddr>();
		
		try {
			connection =  DriveDB.driverdbCon();
			
			preparedstatement = connection.prepareStatement("select * from employee_addr WHERE employee_no=?");
			preparedstatement.setInt(1, sendNO);
			
			resultset = preparedstatement.executeQuery();			
			
			while(resultset.next()) {
				employeeAddr = new EmployeeAddr();
				employeeAddr.setEmployeeAddrNo(resultset.getInt("employee_addr_no"));
				System.out.println(employeeAddr.getEmployeeAddrNo());
				employeeAddr.setEmployeeNo(resultset.getInt("employee_no"));
				employeeAddr.setAddress(resultset.getString("address"));
				arrayEmployeeAddr.add(employeeAddr);
			
			}
			
			return arrayEmployeeAddr;
			
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
	
	public void deleteEmployee(int employeeAddrNo) {
		
		System.out.println("employeeAddrNo: : "+employeeAddrNo+"<-------deleteEmployeeAddr");
		
		try {
		connection =  DriveDB.driverdbCon();
		
		preparedstatement = connection.prepareStatement("DELETE FROM employee_addr WHERE employee_addr_no=?");
		preparedstatement.setInt(1, employeeAddrNo);
		preparedstatement.executeUpdate();
		
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
	}
	public EmployeeAddr employeeAddrSelectforUpdate(int employeeAddrNo) {
		System.out.println("employeeAddrNo : "+ employeeAddrNo+"<---- employeeAddrSelectforUpdate");
		
		try {
			connection = DriveDB.driverdbCon();
			preparedstatement = connection.prepareStatement("select * from employee_addr WHERE employee_addr_no=?");
			preparedstatement.setInt(1, employeeAddrNo);
			resultset =  preparedstatement.executeQuery();
			if(resultset.next()) {
				employeeAddr = new EmployeeAddr();
				employeeAddr.setEmployeeAddrNo(resultset.getInt("employee_addr_no"));;
				employeeAddr.setEmployeeNo(resultset.getInt("employee_no"));
				employeeAddr.setAddress(resultset.getString("address"));
		}
			 return employeeAddr;
		} catch (ClassNotFoundException classEX) {			
			classEX.printStackTrace();
		} catch (SQLException sqlEX) {			
			sqlEX.printStackTrace();
		} finally {
			if(preparedstatement != null) try{preparedstatement.close();} catch(SQLException sqlEX) {}
			if(connection != null) try{connection.close();} catch(SQLException sqlEX) {}			
		}
	
		return null;
	}
	
	public void updateEmployeeAddr(EmployeeAddr employeeaddr) {
		
		System.out.println("EmployeeAddrNo : "+employeeAddr.getEmployeeAddrNo()+"<-------updateEmployeeAddr");
		
		try {
			connection = DriveDB.driverdbCon();
			preparedstatement = connection.prepareStatement("UPDATE employee_addr SET address=? WHERE employee_addr_no = ?");
			preparedstatement.setString(1, employeeAddr.getAddress());
			preparedstatement.setInt(2, employeeAddr.getEmployeeAddrNo());
			
			preparedstatement.executeUpdate();
			
		} catch (ClassNotFoundException classEX) {			
			classEX.printStackTrace();
		} catch (SQLException sqlEX) {			
			sqlEX.printStackTrace();
		} finally {
			if(preparedstatement != null) try{preparedstatement.close();} catch(SQLException sqlEX) {}
			if(connection != null) try{connection.close();} catch(SQLException sqlEX) {}			
		}
	}
}


