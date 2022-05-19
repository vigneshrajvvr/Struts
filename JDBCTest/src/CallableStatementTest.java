import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CallableStatementTest {
	
	public static void main(String args[]) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##strutsdeveloper", "strutsdeveloper");
			
			/*
			 * insert statement using callable statement
			 * 
			 * CallableStatement stmt = con.prepareCall("{call insertEmployee(?,?,?)}");
			 * stmt.setInt(1, 101); stmt.setString(2, "employeeA"); stmt.setInt(3, 9000);
			 * int n = stmt.executeUpdate(); System.out.println("Number of rows affected : "
			 * + n);
			 */
			
			CallableStatement stmt = con.prepareCall("{call getEmmployeeById(?,?,?)}");
			stmt.setInt(1, 101);
			stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			stmt.registerOutParameter(3, java.sql.Types.INTEGER);
			stmt.executeUpdate();
			System.out.println("Name : " + stmt.getString(2) + " Salary : " + stmt.getInt(3));
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
