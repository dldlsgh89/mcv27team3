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
	ArrayList<Student> arrayStudent;
	Teacher teacher;
	
	public void insertStudentAddr(int StudentNo, String StudentAddr) {
		System.out.println(StudentNo+"<--------- StudentAddrDao.java/insertStudentAddr");
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
}

