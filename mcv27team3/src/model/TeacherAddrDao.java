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
	ArrayList<Teacher> arrayTeacher;
	Teacher teacher;
	
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
}
