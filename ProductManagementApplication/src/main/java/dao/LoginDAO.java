package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dbutil.DBUtil;
import pojo.LoginInfo;

public class LoginDAO {
	
	public static boolean isValid(LoginInfo userDetails) {
		boolean validStatus = false;
		
		try {
			Connection con = DBUtil.getConnection();
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select * from login_info where user_name = '" + userDetails.getUsername() + "' and password = '" + userDetails.getPassword() + "'");
						
			while(rs.next()) {
				validStatus = true;
			}
			
			DBUtil.closeConnection(con);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Valid status : " + validStatus); 
		
		return validStatus;
	}

}
