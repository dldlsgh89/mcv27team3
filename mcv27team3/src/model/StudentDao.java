//27기 3팀 임가현
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDao {

	Connection connection = null;
	PreparedStatement preparedstatement = null;
	ResultSet resultset = null;
	
	public void insertStudent(Student student) {
		String studentId = student.getStudentId();
		System.out.println(studentId + "<--insertStudent ID");
		String studentPw = student.getStudentPw();
		System.out.println(studentPw + "<--insertStudent PW");
		
		
		try {
			connection = DriveDB.driverdbCon();
			
			preparedstatement = connection.prepareStatement("INSERT INTO student(student_no, student_id, student_pw) VALUES (null, ?, ?)");
			preparedstatement.setString(1, studentId);
			preparedstatement.setString(2, studentPw);
			
			preparedstatement.executeUpdate();
		
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			if(preparedstatement != null) try{preparedstatement.close();} catch(SQLException ex) {}
			if(connection != null) try{connection.close();} catch(SQLException ex) {}			
		}
		
	}
	
	public ArrayList<Student> selectStudent() {
		ArrayList<Student> arraylist = new ArrayList<Student>();
		
		try {
			connection = DriveDB.driverdbCon();
			
			preparedstatement = connection.prepareStatement("select * from student");
			resultset = preparedstatement.executeQuery();			
			
			while(resultset.next()) {
				System.out.println("selectStudent 연결");
				Student student = new Student();
				student.setStudentId(resultset.getString("studentId"));
				student.setStudentId(resultset.getString("studentPw"));
				arraylist.add(student);	
				System.out.println(arraylist + "<-- arraylist 출력");
			}
			for(Student student : arraylist) {
				System.out.println(student.getStudentId());
				System.out.println(student.getStudentPw());
			}
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
		return arraylist;
		
	}
	
}
