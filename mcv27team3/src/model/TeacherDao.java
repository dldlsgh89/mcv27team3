package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TeacherDao {
	
	Connection connection;
	PreparedStatement preparedstatement;
	ResultSet resultset;
	ArrayList<Teacher> arrayTeacher;
	
	public void insertTeacher(Teacher teacher) {
		
		
		String teacherId = teacher.getTeacherId();
		System.out.println(teacherId+"<----insertTeacher");
		String teacherPw = teacher.getTeacherPw();
			
		
		try {
			connection = DriveDB.driverdbCon();
			
			preparedstatement = connection.prepareStatement("INSERT INTO teacher(teacher_no, teacher_id, teacher_pw) VALUES (null, ?, ?)");
			preparedstatement.setString(1, teacherId);
			preparedstatement.setString(2, teacherPw);
			
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
	
	public ArrayList<Teacher> searchTeacherList() {
		arrayTeacher = new ArrayList<Teacher>();
		try {
			connection = DriveDB.driverdbCon();
			
			preparedstatement = connection.prepareStatement("select * from teacher");
			
			resultset = preparedstatement.executeQuery();
			
			while(resultset.next()) {
				Teacher teacher = new Teacher();
				teacher.setTeacherNo(resultset.getInt("teacher_no"));
				teacher.setTeacherId(resultset.getString("teacher_id"));
				teacher.setTeacherPw(resultset.getString("teacher_pw"));
				arrayTeacher.add(teacher);
			}
			
			return arrayTeacher;
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
	
	
	
}
