//27기 3팀 임가현
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDao {

	Connection connection;
	PreparedStatement preparedstatement;
	ResultSet resultset;
	Student student;
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
	
	public int studentRowCount() {
		int count = 0;
		try {
			connection = DriveDB.driverdbCon();
			preparedstatement = connection.prepareStatement("select count(*) as count from student");
									
			resultset = preparedstatement.executeQuery();
			if(resultset.next()) {
			count = resultset.getInt("count");
			}
			return count;
		} catch (ClassNotFoundException classEX) {			
			classEX.printStackTrace();
		} catch (SQLException sqlEX) {			
			sqlEX.printStackTrace();
		} finally {
			if(preparedstatement != null) try{preparedstatement.close();} catch(SQLException sqlEX) {}
			if(connection != null) try{connection.close();} catch(SQLException sqlEX) {}			
		}		
		return 0;
	}
	//ArrayList<Student> selectStudent
	/*
	 * 매개변수 : startRow -> select 결과물의 시작행
	 * 매개변수 int pagePerRow -> select 결과물의 객수
	 * return : student List
	 */
	public ArrayList<Student> selectStudent(int startRow, int pagePerRow) {
		arrayStudent = new ArrayList<Student>();
		System.out.println(startRow+"selectStudent");
		try {
			connection = DriveDB.driverdbCon();
			
			preparedstatement = connection.prepareStatement("select * from student limit ?, ?");
			preparedstatement.setInt(1,startRow);
			preparedstatement.setInt(2, pagePerRow);
			resultset = preparedstatement.executeQuery();			
			
			while(resultset.next()) {
				Student student = new Student();
				student.setStudentNo(resultset.getInt("student_no"));
				student.setStudentId(resultset.getString("student_id"));
				student.setStudentPw(resultset.getString("student_pw"));
				arrayStudent.add(student);	
			}
			return arrayStudent;
		}catch (SQLException ex) {
			ex.getStackTrace();
			System.out.println(ex.getMessage());	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			//if(resultset != null) try {resultset.close();} catch(SQLException ex) {}
			if(preparedstatement == null) try {preparedstatement.close();} catch(SQLException ex) {}
			if(connection == null) try {connection.close();} catch(SQLException ex) {}
		}
		return null;
	}
	
	private PreparedStatement setInt(int i, int startRow) {
		// TODO Auto-generated method stub
		return null;
	}

	//SelectforUpdate
	public Student SelectforUpdate(int studentNo){
		System.out.println("studentNo : "+studentNo+"<------StudentDao.java/SelectforUpdate");
		
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
	
	
	public void updateStudent(Student student) {
		System.out.println("studentNo : "+student.getStudentNo()+"<------StudentDao.java/updatestudentNo");
		
		try {
		connection = DriveDB.driverdbCon();
		preparedstatement = connection.prepareStatement("UPDATE student SET student_id=?, student_pw=? WHERE student_no=?");
		preparedstatement.setString(1, student.getStudentId());
		preparedstatement.setString(2, student.getStudentPw());
		preparedstatement.setInt(3, student.getStudentNo());
		
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
	
	public void deleteStudent(int studentNo) {
		System.out.println("studentNo : " + studentNo + "<------StudentDao.java/deleteStudent");
		
		try {
		connection = DriveDB.driverdbCon();
		preparedstatement = connection.prepareStatement("DELETE FROM student WHERE student_no=?");
		preparedstatement.setInt(1, studentNo);
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