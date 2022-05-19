import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class JDBCTest {
	
	public static void main(String args[]) {
				
		try {
			
			System.out.println("Connecting to the database..");

			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##strutsdeveloper", "strutsdeveloper");
						
			System.out.println("Connection established!!!");
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM student");
			
			while(rs.next()) {
				System.out.println(rs.getInt("ID") + " ----> " + rs.getString("NAME"));
			}
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}