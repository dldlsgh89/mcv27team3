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
	TeacherAddr teacherAddr;
	ArrayList<TeacherAddr> arrayTeacherAddr;
	
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
	
	public ArrayList<TeacherAddr> selectTeacherAddr(int sendNO) {
		
		System.out.println(sendNO+"<---- selectTeacherAddr");
		arrayTeacherAddr = new ArrayList<TeacherAddr>(); //미리 선언해둔 변수 arrayTeacherAddr에 TeacherAddr타입의 ArrayList객체를 만들어 참조값을 할당한다
		try {
			connection = DriveDB.driverdbCon(); //드라이브 로딩
			
			preparedstatement = connection.prepareStatement("select * from teacher_addr WHERE teacher_no=?"); //teacher테이블에 모든 컬럼을 select 하는 쿼리문을 준비한다
			preparedstatement.setInt(1, sendNO);
			
			resultset = preparedstatement.executeQuery(); //쿼리문 실행후 참조값을 미리선언해둔 resultset변수에 담는다
			
			while(resultset.next()) { //while 반복문을 실행해 쿼리문 실행후 참조값을 담은 변수 resultset의 next메서드가 false일경우까지 반복한다. next 메서드는 결과값을 검색해 값이 잇으면 true, 없으면 false를 리턴하는 메서드다
				teacherAddr = new TeacherAddr();  //생성자 매서드로 Teacher객체 생성후 teacher에 참조값 할당 
				teacherAddr.setTeacherAddrNo(resultset.getInt("teacher_addr_no")); //쿼리 실행결과의 참조값이 담근 resultset에 찾아가 쿼리 실행 결과 컬럼명이 teacher_no인것의 값을 겟팅해와서 teacher참조값의 setTeacherNo메서드의 입력데이터로 입력한다
				System.out.println(teacherAddr.getTeacherAddrNo());
				teacherAddr.setTeacherNo(resultset.getInt("teacher_no")); //쿼리 실행결과의 참조값이 담근 resultset에 찾아가 쿼리 실행 결과 컬럼명이 teacher_id인것의 값을 겟팅해와서 teacher참조값의 setTeacherId메서드의 입력데이터로 입력한다
				teacherAddr.setAddress(resultset.getString("address")); //쿼리 실행결과의 참조값이 담근 resultset에 찾아가 쿼리 실행 결과 컬럼명이 teacher_pw인것의 값을 겟팅해와서 teacher참조값의 setTeacherPw메서드의 입력데이터로 입력한다
				arrayTeacherAddr.add(teacherAddr); //위의 처리를 완료하고 미리 선언해둔 ArrayList타입의 참조변수 arrayTeacher에 add메서드를 입력데이터로 셋팅이 끝난 teacher참조변수를 넣어 실행해 호출한다;
				
				//결과값이 false일때까지 처리를 계속 반복한다
			}
			
			return arrayTeacherAddr;	//resultset.next()메서드의 결과가 false 일때 while 문을 빠져나오고 이제까지 ArrayList를 추가(add)한 참조변수 arrayTeacher를 리턴한다
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
