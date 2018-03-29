//27기 3팀 이인호
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
	PreparedStatement preparedstatement2;
	public void insertTeacher(Teacher teacher) {
		//AddTeacherController 클래스의 doPost메서드 실행시 실행
		//입력데이터로 AddTeacherController에서 미리 setting된 teacher객체참조변수를 받음
		
		String teacherId = teacher.getTeacherId(); //teacher객체에서 teacherId를 getting해서 teacherId변수에 담음
		System.out.println(teacherId+"<----insertTeacher");
		String teacherPw = teacher.getTeacherPw(); 	//teacher객체에서 teacherPw를 getting해서 teacherPw변수에 담음
		try {
			connection = DriveDB.driverdbCon(); 
			
			preparedstatement = connection.prepareStatement("INSERT INTO teacher(teacher_no, teacher_id, teacher_pw) VALUES (null, ?, ?)");
			                                               //teacher테이블에 teacher_no column은 auto_increment해기때문에 null, teacher_id, teacher_pw에는 입력값을 setting하고 insert해주는 query문을 준비
			preparedstatement.setString(1, teacherId); //각 column에 맞은 teacherId와 teacherPw를 setting
			preparedstatement.setString(2, teacherPw); 
			
			preparedstatement.executeUpdate(); //query 실행 return은 없다
			
		} catch (ClassNotFoundException classEX) {			
			classEX.printStackTrace();
		} catch (SQLException sqlEX) {			
			sqlEX.printStackTrace();
		} finally {
			if(preparedstatement != null) try{preparedstatement.close();} catch(SQLException sqlEX) {}
			if(connection != null) try{connection.close();} catch(SQLException sqlEX) {}			
		}
		 
	}
	
	public ArrayList<Teacher> selectTeacher(int starrow, int pagePerRow) {
		//GetTeacherListController.java실행시 호출되는 메서드이다
		//입력데이터는  GetTeacherListController.java에서 넘어온 int starrow와 int pagePerRow이다
		arrayTeacher = new ArrayList<Teacher>(); //리턴 데이터 타입이 ArrayList<Teacher>임으로 미리 ArrayList<Teacher>타입의 참조객체변수 선언
		try {
			connection = DriveDB.driverdbCon(); //드라이브 로딩
			
			preparedstatement = connection.prepareStatement("select * from teacher limit ?, ?"); //teacher테이블의 ?번쨰부터 ?번 select하는 qurey문 
			preparedstatement.setInt(1, starrow);	//select를 시작하는 행이 몇번째부터인지
			preparedstatement.setInt(2, pagePerRow);	//시작행부터 몇번 select할것인지 
			resultset = preparedstatement.executeQuery(); //query문장 실행후 리턴데이터를 resultset변수에 담는다
			
			while(resultset.next()) { //query문 실행결과가 담긴 resultset변수에 접근해 결과값이 있으면 true 없으면 false가 리턴되는 메서드를 while 반복문의 조건값으로 넣어 반복문을 실행한다
				Teacher teacher = new Teacher(); //Teacher클래스 타입teacher객체참조변수 선언
				teacher.setTeacherNo(resultset.getInt("teacher_no")); //resultset변수에 접근해 column명이 "teacher_no"에 해당되는 것을 가져와서 teacher객체참조변수에 setting, 단 column의 데이터유형이 int이므로 getint로 받아준다 
				teacher.setTeacherId(resultset.getString("teacher_id")); //resultset변수에 접근해 column명이 "teacher_id"에 해당되는 것을 가져와서 teacher객체참조변수에 setting
				teacher.setTeacherPw(resultset.getString("teacher_pw"));//resultset변수에 접근해 column명이 "teacher_pw"에 해당되는 것을 가져와서 teacher객체참조변수에 setting
				arrayTeacher.add(teacher); //setting된 teacher 객체를 미리 선언해둔 ArrayList<Teacher>타입의 arrayTeacher 객체에 입력값으로 add해준다
				
				//resultset.next()의 리턴값이 false일때(데이터가 없을때까지)까지 반복
			}
			
			return arrayTeacher;	//teacher가 add된 arrayTeacher객체 참조변수를 리턴해준다
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
	
	
	public int teacherRowCount() {
		//teacher테이블에 있는 총게시물을 select하고 select한 숫자만큼 count를 메겨 그 count를 return해주는 메서드이다
		//GetTeacherListController.java 클래스 실행시 호출되며 입력데이터는 없다
		int Count = 0; //qurey문으로 Count숫자를 담을 int형 변수 Count선언
				
		try {
			connection = DriveDB.driverdbCon();
			preparedstatement = connection.prepareStatement("select count(*) as count from teacher");	//teacher테이블을 select하고 그 숫자를								
			resultset = preparedstatement.executeQuery();
			if(resultset.next()) {
			Count = resultset.getInt("count");
			}
			return Count;
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
	
	public Teacher teacherSelectforUpdate(int teacherNo){
		//UpdateTeacherController클래스의 doGet메서드 실행시 호출되는 메서드
		//입력데이터로는 getTeacherList.jsp에서 넘어온 데이터를 int타입으로 형변환한 teacherNo변수 받고 return데이터는 Teacher클래스타입으로 return한다
		System.out.println("teacherNo : "+teacherNo+"<------mSelectforUpdate");

		try {
		connection = DriveDB.driverdbCon();
		preparedstatement = connection.prepareStatement("select * from teacher WHERE teacher_no=?");
		//teacher테이블에서 teacher_no에 해당되는 column을 입력받아 select하는 query문 준비
		
		preparedstatement.setInt(1, teacherNo);
		//teacherNo를 setting
		resultset = preparedstatement.executeQuery(); //query 실행후 결과를 resultset에 리턴 
		if(resultset.next()) { //if문을 실행하고 조건값으로 resultset에 접근해 next메서드 호출을 넣는다
			teacher = new Teacher(); //teacher객체참조변수에 Teacher클래스타입객체 할당
			teacher.setTeacherNo(resultset.getInt("teacher_no")); //resultset에 접근해 column명이 teacher_no에 해당되는 값을 getting해서 teacher객체참조변수에 접근해 setting
			teacher.setTeacherId(resultset.getString("teacher_id")); //resultset에 접근해 column명이 teacher_id에 해당되는 값을 getting해서 teacher객체참조변수에 접근해 setting
			teacher.setTeacherPw(resultset.getString("teacher_pw")); //resultset에 접근해 column명이 teacher_pws에 해당되는 값을 getting해서 teacher객체참조변수에 접근해 setting
		} 
			return teacher;	//setting된 teacher 객체참조변수를 return
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
		//UpdateTeacherController.java의 doPost메서드 실행시 호출되는 메서드
		//입력데이터로는 Teacher클래스 타입의 변수를 받는다
		System.out.println("teacherNo : "+teacher.getTeacherNo()+"<------updateTeacher");
		
		try {
		connection = DriveDB.driverdbCon();
		preparedstatement = connection.prepareStatement("UPDATE teacher SET teacher_id=?, teacher_pw=? WHERE teacher_no = ?");
		//입력된 데이터가 teacher테이블에 teacher_no column과 일치하는 데이터가 있을경우 teacher_id column과 teacher_pw column에 입력데이터를 set하고 update하는 query문을 준비한다
		preparedstatement.setString(1, teacher.getTeacherId());
		//teacher객체참조변수에 TeacherIdf를 getting해서 query문에 setting
		preparedstatement.setString(2, teacher.getTeacherPw());
		//teacher객체참조변수에 TeacherPw를 getting해서 query문에 setting
		preparedstatement.setInt(3, teacher.getTeacherNo());
		//teacher객체참조변수에 TeacherNo를 getting해서 query문에 setting
		
		preparedstatement.executeUpdate();
		//query 실행
		
		} catch (ClassNotFoundException classEX) {			
			classEX.printStackTrace();
		} catch (SQLException sqlEX) {			
			sqlEX.printStackTrace();
		} finally {
			if(preparedstatement != null) try{preparedstatement.close();} catch(SQLException sqlEX) {}
			if(connection != null) try{connection.close();} catch(SQLException sqlEX) {}			
		}
		
		
	}
	
	public void deleteTeacher(int teacherNo) { 
		//DeleteTeacherController.java 클래스에서 doGet메서드 실행시 if문의 조건이 0<teacherAddrDao.selectTeacherAddr(teacherNo).size()가 true가 아닐때만 호출되는 메서드이다
		//입력데이터로는 getTeacherList.jsp에서 DeleteTeacherController.java로 넘어와 형변환된 int타입 변수 teacherNo를 받는다
		
		System.out.println("teacherNo : "+teacherNo+"<------deleteTeacher");
		
		try {
		connection = DriveDB.driverdbCon();
		preparedstatement = connection.prepareStatement("DELETE FROM teacher WHERE teacher_no=?");
		//teacher에서 teacher_no column에 일치하는 데이터가 있을때 delete해주는 query문장을 준비한다
		preparedstatement.setInt(1, teacherNo);
		//teacherNo변수 query문에 setting한다
		preparedstatement.executeUpdate();
		//query실행
		
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
