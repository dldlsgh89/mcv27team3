package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DriveDB {
	public static Connection driverdbCon() throws ClassNotFoundException, SQLException {
		System.out.println("����̺� �ε� Ȯ��");
		Connection reconnection = null;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String jdbcDriver = "jdbc:mysql://localhost:3306/mvc?useUnicode=true&characterEncoding=euckr";
		String dbUser = "root";
		String dbPass = "java0000";
		
		reconnection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		
		
		return reconnection;
	}
}
