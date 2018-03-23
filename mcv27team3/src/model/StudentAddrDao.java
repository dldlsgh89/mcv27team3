//27기 3팀 임가현
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentAddrDao {
	Connection connection;
	PreparedStatement preparedstatement;
	ResultSet resultset;
	ArrayList<StudentAddr> arrayStudentAddr;
	StudentAddr studentAddr;
	
	public void insertStudentAddr(int StudentNo, String StudentAddr) {
		System.out.println(StudentNo+"<--------- insertStudentAddr StudentAddrDao.java");
		try {
			connection = DriveDB.driverdbCon();
			
			preparedstatement = connection.prepareStatement("INSERT INTO student_addr(student_addr_no, student_no, address) VALUES (null, ?, ?)");
			preparedstatement.setInt(1, StudentNo);
			preparedstatement.setString(2, StudentAddr);
			
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
	
	//ArrayList<StudentAddr> selectStudentAddr
		public ArrayList<StudentAddr> selectStudentAddr(int sendNO) {
			System.out.println(sendNO+"<---- selectStudentAddr StudentAddrDao.java");
			arrayStudentAddr = new ArrayList<StudentAddr>();
			
			try {
				connection = DriveDB.driverdbCon();
				
				preparedstatement = connection.prepareStatement("select * from student_addr WHERE student_no=?");
				preparedstatement.setInt(1, sendNO);
				resultset = preparedstatement.executeQuery();			
				
				while(resultset.next()) {
					StudentAddr studentAddr = new StudentAddr();
					studentAddr.setStudentAddrNo(resultset.getInt("student_addr_no"));
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
		//deleteStudentAddr
		public void deleteStudentAddr(int studentAddrNo) { 
			System.out.println("studentAddrNo : " + studentAddrNo + "<------deleteStudentAddr StudentAddrDao.java");
			
			try {
			connection = DriveDB.driverdbCon();
					
			preparedstatement = connection.prepareStatement("DELETE FROM student_addr WHEREstudent_addr_no=?");
			preparedstatement.setInt(1, studentAddrNo);
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
		
		public StudentAddr studentAddrSelectforUpdate(int studentAddrNo){
			System.out.println("studentAddrNo : "+studentAddrNo+"<------studentAddrSelectforUpdate");

			try {
			connection = DriveDB.driverdbCon();
			preparedstatement = connection.prepareStatement("select * from student_addr WHERE student_addr_no=?");
			preparedstatement.setInt(1, studentAddrNo);
			resultset = preparedstatement.executeQuery();
			if(resultset.next()) {
				studentAddr = new StudentAddr();
				studentAddr.setStudentAddrNo(resultset.getInt("student_addr_no"));
				studentAddr.setStudentNo(resultset.getInt("student_no"));
				studentAddr.setAddress(resultset.getString("address"));
			} 
				return studentAddr;		
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
		
		public void updateStudentAddr(StudentAddr studentAddr) {
			System.out.println("StudentAddrNo : "+studentAddr.getStudentAddrNo()+"<------updateStudentAddr");
			
			try {
			connection = DriveDB.driverdbCon();
			preparedstatement = connection.prepareStatement("UPDATE student_addr SET address=? WHERE student_addr_no = ?");
			preparedstatement.setString(1, studentAddr.getAddress());
			preparedstatement.setInt(2, studentAddr.getStudentAddrNo());
			
			
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

