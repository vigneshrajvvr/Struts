package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	public static Connection getConnection() {
		
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Connecting to the database..");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##strutsdeveloper", "strutsdeveloper");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void closeConnection(Connection con) {
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
