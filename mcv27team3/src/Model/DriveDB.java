package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DriveDB {
	public Connection driverdbcon() throws ClassNotFoundException, SQLException {
		System.out.println("드라이브 로딩 확인");
		Connection recon = null;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String jdbcDriver = "jdbc:mysql://localhost:3306/mvc?" +
				"useUnicode=true&characterEncoding=euckr";
		String dbUser = "root";
		String dbPass = "java0000";
		
		recon = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		
		
		return recon;
	}
}
