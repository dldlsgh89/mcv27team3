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
		arrayTeacherAddr = new ArrayList<TeacherAddr>(); //�̸� �����ص� ���� arrayTeacherAddr�� TeacherAddrŸ���� ArrayList��ü�� ����� �������� �Ҵ��Ѵ�
		try {
			connection = DriveDB.driverdbCon(); //����̺� �ε�
			
			preparedstatement = connection.prepareStatement("select * from teacher_addr WHERE teacher_no=?"); //teacher���̺� ��� �÷��� select �ϴ� �������� �غ��Ѵ�
			preparedstatement.setInt(1, sendNO);
			
			resultset = preparedstatement.executeQuery(); //������ ������ �������� �̸������ص� resultset������ ��´�
			
			while(resultset.next()) { //while �ݺ����� ������ ������ ������ �������� ���� ���� resultset�� next�޼��尡 false�ϰ����� �ݺ��Ѵ�. next �޼���� ������� �˻��� ���� ������ true, ������ false�� �����ϴ� �޼����
				teacherAddr = new TeacherAddr();  //������ �ż���� Teacher��ü ������ teacher�� ������ �Ҵ� 
				teacherAddr.setTeacherAddrNo(resultset.getInt("teacher_addr_no")); //���� �������� �������� ��� resultset�� ã�ư� ���� ���� ��� �÷����� teacher_no�ΰ��� ���� �����ؿͼ� teacher�������� setTeacherNo�޼����� �Էµ����ͷ� �Է��Ѵ�
				System.out.println(teacherAddr.getTeacherAddrNo());
				teacherAddr.setTeacherNo(resultset.getInt("teacher_no")); //���� �������� �������� ��� resultset�� ã�ư� ���� ���� ��� �÷����� teacher_id�ΰ��� ���� �����ؿͼ� teacher�������� setTeacherId�޼����� �Էµ����ͷ� �Է��Ѵ�
				teacherAddr.setAddress(resultset.getString("address")); //���� �������� �������� ��� resultset�� ã�ư� ���� ���� ��� �÷����� teacher_pw�ΰ��� ���� �����ؿͼ� teacher�������� setTeacherPw�޼����� �Էµ����ͷ� �Է��Ѵ�
				arrayTeacherAddr.add(teacherAddr); //���� ó���� �Ϸ��ϰ� �̸� �����ص� ArrayListŸ���� �������� arrayTeacher�� add�޼��带 �Էµ����ͷ� ������ ���� teacher���������� �־� ������ ȣ���Ѵ�;
				
				//������� false�϶����� ó���� ��� �ݺ��Ѵ�
			}
			
			return arrayTeacherAddr;	//resultset.next()�޼����� ����� false �϶� while ���� ���������� �������� ArrayList�� �߰�(add)�� �������� arrayTeacher�� �����Ѵ�
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
