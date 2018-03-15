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
	Teacher teacher;
	
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
	
	public ArrayList<Teacher> selectTeacher() {
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
	
	
	public Teacher teacherSelectforUpdate(int teacherNo){
		System.out.println("teacherNo : "+teacherNo+"<------mSelectforUpdate");

		try {
		connection = DriveDB.driverdbCon();
		preparedstatement = connection.prepareStatement("select * from teacher WHERE teacher_no=?");
		preparedstatement.setInt(1, teacherNo);
		resultset = preparedstatement.executeQuery();
		if(resultset.next()) {
			teacher = new Teacher();
			teacher.setTeacherNo(resultset.getInt("teacher_no"));
			teacher.setTeacherId(resultset.getString("teacher_id"));
			teacher.setTeacherPw(resultset.getString("teacher_pw"));
		} 
			return teacher;		
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
	
	
	
	public void updateTeacher(Teacher teacher) {
		System.out.println("teacherNo : "+teacher.getTeacherNo()+"<------updateTeacher");
		
		try {
		connection = DriveDB.driverdbCon();
		preparedstatement = connection.prepareStatement("UPDATE teacher SET teacher_id=?, teacher_pw=? WHERE teacher_no = ?");
		preparedstatement.setString(1, teacher.getTeacherId());
		preparedstatement.setString(2, teacher.getTeacherPw());
		preparedstatement.setInt(3, teacher.getTeacherNo());
		
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
	
	public void deleteTeacher(int teacherNo) { //입력데이터는 아무거나 선택
		
		System.out.println("teacherNo : "+teacherNo+"<------deleteTeacher");
		
		try {
		connection = DriveDB.driverdbCon();
		preparedstatement = connection.prepareStatement("DELETE FROM teacher WHERE teacher_no=?");
		preparedstatement.setInt(1, teacherNo);
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
