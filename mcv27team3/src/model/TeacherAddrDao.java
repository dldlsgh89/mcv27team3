//27기 3팀 이인호
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TeacherAddrDao {
	Connection connection;
	PreparedStatement preparedstatement;
	ResultSet resultset;
	TeacherAddr teacherAddr;
	ArrayList<TeacherAddr> arrayTeacherAddr;
	
	public void addTeacherAddress(int teacherNo, String teacherAddr) {
		System.out.println(teacherNo+"<---------addTeacherAddress");
		try {
			connection = DriveDB.driverdbCon();
			
			preparedstatement = connection.prepareStatement("INSERT INTO teacher_addr(teacher_addr_no, teacher_no, address) VALUES (null, ?, ?)");
			preparedstatement.setInt(1, teacherNo);
			preparedstatement.setString(2, teacherAddr);
			
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
	
	public ArrayList<TeacherAddr> selectTeacherAddr(int teacherNo) {
		
		System.out.println(teacherNo+"<---- selectTeacherAddr");
		arrayTeacherAddr = new ArrayList<TeacherAddr>(); 
		try {
			connection = DriveDB.driverdbCon();
			
			preparedstatement = connection.prepareStatement("select * from teacher_addr WHERE teacher_no=?"); 
			preparedstatement.setInt(1, teacherNo);
			
			resultset = preparedstatement.executeQuery(); 
			
			while(resultset.next()) { 
				teacherAddr = new TeacherAddr();  
				teacherAddr.setTeacherAddrNo(resultset.getInt("teacher_addr_no")); 
				System.out.println(teacherAddr.getTeacherAddrNo());
				teacherAddr.setTeacherNo(resultset.getInt("teacher_no"));
				teacherAddr.setAddress(resultset.getString("address")); 
				arrayTeacherAddr.add(teacherAddr); 				
			}			
			return arrayTeacherAddr;	
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
	
	public void deleteTeacherAddr(int teacherAddrNo) { 
		
		System.out.println("teacherAddrNo : "+teacherAddrNo+"<------deleteTeacherAddr");
		
		try {
		connection = DriveDB.driverdbCon();
				
		preparedstatement = connection.prepareStatement("DELETE FROM teacher_addr WHERE teacher_addr_no=?");
		preparedstatement.setInt(1, teacherAddrNo);
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
	
	public TeacherAddr teacherAddrSelectforUpdate(int teacherAddrNo){
		System.out.println("teacherAddrNo : "+teacherAddrNo+"<------teacherAddrSelectforUpdate");

		try {
		connection = DriveDB.driverdbCon();
		preparedstatement = connection.prepareStatement("select * from teacher_addr WHERE teacher_addr_no=?");
		preparedstatement.setInt(1, teacherAddrNo);
		resultset = preparedstatement.executeQuery();
		if(resultset.next()) {
			teacherAddr = new TeacherAddr();
			teacherAddr.setTeacherAddrNo(resultset.getInt("teacher_addr_no"));
			teacherAddr.setTeacherNo(resultset.getInt("teacher_no"));
			teacherAddr.setAddress(resultset.getString("address"));
		} 
			return teacherAddr;		
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
	
	public void updateTeacherAddr(TeacherAddr teacherAddr) {
		System.out.println("TeacherAddrNo : "+teacherAddr.getTeacherAddrNo()+"<------updateTeacherAddr");
		
		try {
		connection = DriveDB.driverdbCon();
		preparedstatement = connection.prepareStatement("UPDATE teacher_addr SET address=? WHERE teacher_addr_no = ?");
		preparedstatement.setString(1, teacherAddr.getAddress());
		preparedstatement.setInt(2, teacherAddr.getTeacherAddrNo());
		
		
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
