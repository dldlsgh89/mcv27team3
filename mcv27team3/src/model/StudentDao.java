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
	Student student = null;
	ArrayList<Student> arrayStudent;
	
	//insertStudent
	public void insertStudent(Student student) {
		String studentId = student.getStudentId();
		System.out.println(studentId + "<-- StudentDao.java/insertStudent");
		String studentPw = student.getStudentPw();
		System.out.println(studentPw + "<-- StudentDao.java/insertStudent");
		
		
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
	//ArrayList<Student> selectStudent
	public ArrayList<Student> selectStudent() {
		arrayStudent = new ArrayList<Student>();
		
		try {
			connection = DriveDB.driverdbCon();
			
			preparedstatement = connection.prepareStatement("select * from student");
			resultset = preparedstatement.executeQuery();			
			
			while(resultset.next()) {
				System.out.println("StudentDao.java/selectStudent 연결");
				Student student = new Student();
				student.setStudentId(resultset.getString("student_no"));
				student.setStudentId(resultset.getString("student_id"));
				student.setStudentId(resultset.getString("student_pw"));
				arrayStudent.add(student);	
				System.out.println(arrayStudent + "<--StudentDao.java/arrayStudent 출력");
			}
			return arrayStudent;
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
	//mSelectforUpdate : 한명회원조회
	public Student SelectforUpdate(int studentNo){
		System.out.println("teacherNo : "+studentNo+"<------mSelectforUpdate");

		try {
		connection = DriveDB.driverdbCon();
		preparedstatement = connection.prepareStatement("select * from student WHERE student_no=?");
		preparedstatement.setInt(1, studentNo);
		resultset = preparedstatement.executeQuery();
		if(resultset.next()) {
			student = new Student();
			student.setStudentNo(resultset.getInt("student_no"));
			student.setStudentId(resultset.getString("student_id"));
			student.setStudentPw(resultset.getString("student_pw"));
		} 
			return student;
			
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
	
	
	public int updateStudent(Student student) {
		String studentId = student.getStudentId();
		System.out.println(studentId + "<-- StudentDao.java/insertStudent");
		String studentPw = student.getStudentPw();
		System.out.println(studentPw + "<-- StudentDao.java/insertStudent");
		
		
		
		return 0;
	}
	
	public int deleteStudent(int studentNo) {
		return 0;
	}
	
}
