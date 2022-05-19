import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class CRUDTest {

	public static void main(String args[]) {

		try {
			System.out.println("Connecting to the database");
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##strutsdeveloper",
					"strutsdeveloper");

			/*
			 * Statement in JDBC
			 * 
			 * Statement st = con.createStatement();
			 * 
			 * 
			 * int n = st.
			 * executeUpdate("create table employee(emp_id int, emp_name varchar2(30), emp_salary int)"
			 * );
			 * 
			 * 
			 * int n =
			 * st.executeUpdate("insert into employee values(101, 'employeeA', 1000)");
			 * System.out.println("Number of rows affected : " + n);
			 * 
			 * n = st.executeUpdate("insert into employee values(102, 'employeeB', 3000)");
			 * System.out.println("Number of rows affected : " + n);
			 * 
			 * n = st.executeUpdate("insert into employee values(103, 'employeeC', 7000)");
			 * System.out.println("Number of rows affected : " + n);
			 * 
			 * n = st.
			 * executeUpdate("insert into employee(emp_id, emp_name) values(104, 'employeeD')"
			 * );
			 * 
			 * 
			 * 
			 * int n = st.
			 * executeUpdate("update employee set emp_salary = 5000 where emp_salary > 1000"
			 * );
			 * 
			 * 
			 * 
			 * int n = st.executeUpdate("delete from employee where emp_id = 104");
			 * 
			 * 
			 * int n = st.executeUpdate("delete from employee");
			 * 
			 * System.out.println("Number of rows affected : " + n);
			 */
			
			/*
			 * Prepared Statement in JDBC
			 */
			
			/*
			 * insert values using prepared statement
			 * 
			 * PreparedStatement ps =
			 * con.prepareStatement("insert into employee values(?,?,?)"); ps.setInt(1,
			 * 103); ps.setString(2, "employeeC"); ps.setInt(3, 10000); int n =
			 * ps.executeUpdate(); System.out.println("Number of rows affected : " + n);
			 */
			
			/*
			 * update values using prepared statement
			 * 
			 * PreparedStatement ps =
			 * con.prepareStatement("update employee set emp_salary = ? where emp_id = ?");
			 * ps.setInt(1, 20000); ps.setInt(2, 102); int n = ps.executeUpdate();
			 * System.out.println("Number of rows affected : " + n);
			 */
			
			PreparedStatement ps = con.prepareStatement("delete from employee where emp_salary >= ?");
			ps.setInt(1, 1000);
			int n = ps.executeUpdate();
			System.out.println("Number of rows affected : " + n);
			
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
