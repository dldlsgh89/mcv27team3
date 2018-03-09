package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TeacherDao {
	
	Connection connection;
	PreparedStatement preparedstatement;

	public void insertTeacher(HttpServletRequest request, HttpServletResponse response) {
		String teacherId = request.getParameter("teacherid");
		System.out.println(teacherId+"<----insertTeacher");
		String teacherPw = request.getParameter("teacherpw");
			
		DriveDB drivedb = new DriveDB();
		try {
			connection = drivedb.driverdbcon();
			
			preparedstatement = connection.prepareStatement("INSERT INTO teacher(teacher_no, teacher_id, teacher_pw) VALUES (0, ?, ?)");
			preparedstatement.setString(1, teacherId);
			preparedstatement.setString(2, teacherPw);
			
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
