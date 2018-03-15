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
		
		
		String teacherId = teacher.getTeacherId(); //�Էµ� �������� ã�ư� �̸� ���õǾ��ִ� teacherId�� �����ؼ� StringŸ���� teacherId������ ��´�
		System.out.println(teacherId+"<----insertTeacher");
		String teacherPw = teacher.getTeacherPw(); //�Էµ� �������� ã�ư� �̸� ���õǾ��ִ� teacherPw�� �����ؼ� StringŸ���� teacherPw������ ��´�
			
		
		try {
			connection = DriveDB.driverdbCon(); //����̺� �ε�
			
			preparedstatement = connection.prepareStatement("INSERT INTO teacher(teacher_no, teacher_id, teacher_pw) VALUES (null, ?, ?)");
			//teacher���̺���  ���� teacher_no,teacher_id,teacher_pw �÷��� null, ?, ? ���� �־��ִ� insert ���������� �غ��Ѵ�  
			//teacher_no�� null�� ������ �����ͺ��̽��󿡼� auto increment�̱� ������ �ڵ����� �����Ǿ� �ԷµǱ� �����̴� 
			preparedstatement.setString(1, teacherId); //ù��° ?�� �ش�Ǵ� �÷� teacher_id�� teacherId������ �Է��Ѵ�
			preparedstatement.setString(2, teacherPw); //ù��° ?�� �ش�Ǵ� �÷� teacher_id�� teacherId������ �Է��Ѵ�
			
			preparedstatement.executeUpdate(); //�������� �������ش� 
			
		} catch (ClassNotFoundException classEX) {			
			classEX.printStackTrace();
		} catch (SQLException sqlEX) {			
			sqlEX.printStackTrace();
		} finally {
			if(preparedstatement != null) try{preparedstatement.close();} catch(SQLException sqlEX) {}
			if(connection != null) try{connection.close();} catch(SQLException sqlEX) {}			
		}
		 //�� ���ϰ� ���� 
	}
	
	public ArrayList<Teacher> selectTeacher() {
		arrayTeacher = new ArrayList<Teacher>(); //�̸� �����ص� ���� arrayTeacher�� TeacherŸ���� ArrayList��ü�� ����� �������� �Ҵ��Ѵ�
		try {
			connection = DriveDB.driverdbCon(); //����̺� �ε�
			
			preparedstatement = connection.prepareStatement("select * from teacher"); //teacher���̺� ��� �÷��� select �ϴ� �������� �غ��Ѵ�
			
			resultset = preparedstatement.executeQuery(); //������ ������ �������� �̸������ص� resultset������ ��´�
			
			while(resultset.next()) { //while �ݺ����� ������ ������ ������ �������� ���� ���� resultset�� next�޼��尡 false�ϰ����� �ݺ��Ѵ�. next �޼���� ������� �˻��� ���� ������ true, ������ false�� �����ϴ� �޼����
				Teacher teacher = new Teacher();  //������ �ż���� Teacher��ü ������ teacher�� ������ �Ҵ� 
				teacher.setTeacherNo(resultset.getInt("teacher_no")); //���� �������� �������� ��� resultset�� ã�ư� ���� ���� ��� �÷����� teacher_no�ΰ��� ���� �����ؿͼ� teacher�������� setTeacherNo�޼����� �Էµ����ͷ� �Է��Ѵ�
				teacher.setTeacherId(resultset.getString("teacher_id")); //���� �������� �������� ��� resultset�� ã�ư� ���� ���� ��� �÷����� teacher_id�ΰ��� ���� �����ؿͼ� teacher�������� setTeacherId�޼����� �Էµ����ͷ� �Է��Ѵ�
				teacher.setTeacherPw(resultset.getString("teacher_pw")); //���� �������� �������� ��� resultset�� ã�ư� ���� ���� ��� �÷����� teacher_pw�ΰ��� ���� �����ؿͼ� teacher�������� setTeacherPw�޼����� �Էµ����ͷ� �Է��Ѵ�
				arrayTeacher.add(teacher); //���� ó���� �Ϸ��ϰ� �̸� �����ص� ArrayListŸ���� �������� arrayTeacher�� add�޼��带 �Էµ����ͷ� ������ ���� teacher���������� �־� ������ ȣ���Ѵ�;
				
				//������� false�϶����� ó���� ��� �ݺ��Ѵ�
			}
			
			return arrayTeacher;	//resultset.next()�޼����� ����� false �϶� while ���� ���������� �������� ArrayList�� �߰�(add)�� �������� arrayTeacher�� �����Ѵ�
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
	
	public void deleteTeacher(int teacherNo) { //�Էµ����ʹ� �ƹ��ų� ����
		
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
