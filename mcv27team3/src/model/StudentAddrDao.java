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
	ArrayList<Teacher> arrayTeacher;
	Teacher teacher;
	
	public int insertStudentAddr(int StudentNo, String studentAddr) {
		System.out.println(StudentNo+"<---------addTeacherAddress");
		try {
			connection = DriveDB.driverdbCon();
			
			preparedstatement = connection.prepareStatement("INSERT INTO student_addr(student_addr_no, Student_no, address) VALUES (null, ?, ?)");
			preparedstatement.setInt(1, StudentNo);
			preparedstatement.setString(2, studentAddr);
			
			preparedstatement.executeUpdate();
			
		} catch (ClassNotFoundException classEX) {			
			classEX.printStackTrace();
		} catch (SQLException sqlEX) {			
			sqlEX.printStackTrace();
		} finally {
			if(preparedstatement != null) try{preparedstatement.close();} catch(SQLException sqlEX) {}
			if(connection != null) try{connection.close();} catch(SQLException sqlEX) {}			
		}
		return StudentNo;
		
	}

}
