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
		
		
		String teacherId = teacher.getTeacherId(); //입력된 참조값을 찾아가 미리 셋팅되어있던 teacherId를 겟팅해서 String타입의 teacherId변수에 담는다
		System.out.println(teacherId+"<----insertTeacher");
		String teacherPw = teacher.getTeacherPw(); //입력된 참조값을 찾아가 미리 셋팅되어있던 teacherPw를 겟팅해서 String타입의 teacherPw변수에 담는다
			
		
		try {
			connection = DriveDB.driverdbCon(); //드라이브 로딩
			
			preparedstatement = connection.prepareStatement("INSERT INTO teacher(teacher_no, teacher_id, teacher_pw) VALUES (null, ?, ?)");
			//teacher테이블의  각각 teacher_no,teacher_id,teacher_pw 컬럼에 null, ?, ? 값을 넣어주는 insert 쿼리문장을 준비한다  
			//teacher_no이 null인 이유는 데이터베이스상에서 auto increment이기 때문에 자동으로 증가되어 입력되기 때문이다 
			preparedstatement.setString(1, teacherId); //첫번째 ?에 해당되는 컬럼 teacher_id에 teacherId변수를 입력한다
			preparedstatement.setString(2, teacherPw); //첫번째 ?에 해당되는 컬럼 teacher_id에 teacherId변수를 입력한다
			
			preparedstatement.executeUpdate(); //쿼리문을 실행해준다 
			
		} catch (ClassNotFoundException classEX) {			
			classEX.printStackTrace();
		} catch (SQLException sqlEX) {			
			sqlEX.printStackTrace();
		} finally {
			if(preparedstatement != null) try{preparedstatement.close();} catch(SQLException sqlEX) {}
			if(connection != null) try{connection.close();} catch(SQLException sqlEX) {}			
		}
		 //끝 리턴값 없음 
	}
	
	public ArrayList<Teacher> selectTeacher() {
		arrayTeacher = new ArrayList<Teacher>(); //미리 선언해둔 변수 arrayTeacher에 Teacher타입의 ArrayList객체를 만들어 참조값을 할당한다
		try {
			connection = DriveDB.driverdbCon(); //드라이브 로딩
			
			preparedstatement = connection.prepareStatement("select * from teacher"); //teacher테이블에 모든 컬럼을 select 하는 쿼리문을 준비한다
			
			resultset = preparedstatement.executeQuery(); //쿼리문 실행후 참조값을 미리선언해둔 resultset변수에 담는다
			
			while(resultset.next()) { //while 반복문을 실행해 쿼리문 실행후 참조값을 담은 변수 resultset의 next메서드가 false일경우까지 반복한다. next 메서드는 결과값을 검색해 값이 잇으면 true, 없으면 false를 리턴하는 메서드다
				Teacher teacher = new Teacher();  //생성자 매서드로 Teacher객체 생성후 teacher에 참조값 할당 
				teacher.setTeacherNo(resultset.getInt("teacher_no")); //쿼리 실행결과의 참조값이 담근 resultset에 찾아가 쿼리 실행 결과 컬럼명이 teacher_no인것의 값을 겟팅해와서 teacher참조값의 setTeacherNo메서드의 입력데이터로 입력한다
				teacher.setTeacherId(resultset.getString("teacher_id")); //쿼리 실행결과의 참조값이 담근 resultset에 찾아가 쿼리 실행 결과 컬럼명이 teacher_id인것의 값을 겟팅해와서 teacher참조값의 setTeacherId메서드의 입력데이터로 입력한다
				teacher.setTeacherPw(resultset.getString("teacher_pw")); //쿼리 실행결과의 참조값이 담근 resultset에 찾아가 쿼리 실행 결과 컬럼명이 teacher_pw인것의 값을 겟팅해와서 teacher참조값의 setTeacherPw메서드의 입력데이터로 입력한다
				arrayTeacher.add(teacher); //위의 처리를 완료하고 미리 선언해둔 ArrayList타입의 참조변수 arrayTeacher에 add메서드를 입력데이터로 셋팅이 끝난 teacher참조변수를 넣어 실행해 호출한다;
				
				//결과값이 false일때까지 처리를 계속 반복한다
			}
			
			return arrayTeacher;	//resultset.next()메서드의 결과가 false 일때 while 문을 빠져나오고 이제까지 ArrayList를 추가(add)한 참조변수 arrayTeacher를 리턴한다
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
