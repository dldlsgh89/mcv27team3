package Model;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDao {

Connection connection = null;
PreparedStatement preparedstatement = null;
ResultSet resultset = null;
Employee e = null;

public void InsertEmployee(Employee employee) {
	//3�ܰ� ���������غ� ���� ����
	DriveDB drivedb = new DriveDB();
	try {
		connection = drivedb.driverdbcon();
		System.out.println("01_01 ȸ������ ó�� �޼��� ����Employee Mdao.java");
		preparedstatement = connection.prepareStatement("INSERT INTO tb_member VALUES (?, ?, ?, ?, ?)");
		//insert into tb_member values('id001','pw001','������','ȫ01','email01');
		 e = new Employee();
		preparedstatement.setString(1, e.getM_id());
		preparedstatement.setString(2, e.getM_pw());
		
		preparedstatement.executeUpdate();
			
		} catch (SQLException ex) {	
			ex.getMessage();
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			if(preparedstatement != null) try{preparedstatement.close();} catch(SQLException ex) {}
			if(connection != null) try{connection.close();} catch(SQLException ex) {}			
		}
	}
}
