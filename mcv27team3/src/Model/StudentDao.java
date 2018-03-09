package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDao {

	Connection connection;
	PreparedStatement preparedstatement;
	
	public void insertStudent(Student student) {
		String studentId = student.getStudentId();
		System.out.println(studentId + "<--insertStudent ID");
		String studentPw = student.getStudentPw();
		System.out.println(studentPw + "<--insertStudent PW");
		
		DriveDB drivedb = new DriveDB();
		
		try {
			connection = drivedb.driverdbcon();
			
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
	
}
