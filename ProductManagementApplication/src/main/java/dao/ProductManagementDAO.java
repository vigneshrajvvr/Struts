package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbutil.DBUtil;
import pojo.Product;

public class ProductManagementDAO {
	
	public static List<Product> getAllProducts(String productName, String productCategory, String createdDate) {
		
		List<Product> productList = new ArrayList<>();
		String whereClause = "";
		if((productName == null || productName.equals(""))
				&& (productCategory == null || productCategory.equals(""))
				&& (createdDate == null || createdDate.equals(""))) {
			whereClause = "";
		} else  {
			whereClause = " WHERE ";
		}
		int count = 0;
		if(productName != null && !productName.equals("")) {
			count++;
			if(count != 1) {
				whereClause += " AND ";
			}
			
			whereClause += "prod_name = " + "'" + productName + "'";
		}
		
		if(productCategory != null && !productCategory.equals("")) {
			count++;
			if(count != 1) {
				whereClause += " AND ";
			}
			
			whereClause += "prod_category = " + "'" + productCategory + "'";
		}
		
		if(createdDate != null && !createdDate.equals("")) {
			count++;
			if(count != 1) {
				whereClause += " AND ";
			}
			
			whereClause += "created_date = " + "'" + createdDate + "'";
		}
		
		try {
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from product" + whereClause);
			
			while(rs.next()) {
				Product product = new Product(rs.getString("prod_id"), rs.getString("prod_name"), rs.getString("prod_category"), rs.getInt("prod_price"), rs.getString("created_date"));
				productList.add(product);
			}
			
			DBUtil.closeConnection(conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return productList;
		
	}
	
	public static int addProduct(Product product) {
		int status = 0;
		
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into product values (?,?,?,?,?)");
			ps.setString(1, product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getProductCategory());
			ps.setInt(4, product.getProductPrice());
			ps.setString(5, product.getCreatedDate());
			status = ps.executeUpdate();
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return status;
	}
	
	public static Product getProductById(String productId) {
		
		Product product = null;
		
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement st = con.prepareStatement("select * from product where prod_id=?");
			st.setString(1, productId);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				product = new Product(rs.getString("prod_id"),
									  rs.getString("prod_name"),
									  rs.getString("prod_category"),
									  rs.getInt("prod_price"),
									  rs.getString("created_date"));
			}
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return product;
	}
	
	public static int updateProduct(Product product) {
		
		int status = 0;
		
		try {
			
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("update product set prod_name = ?, prod_category = ?, prod_price = ? where prod_id = ?");
			ps.setString(1,product.getProductName());
			ps.setString(2, product.getProductCategory());
			ps.setInt(3, product.getProductPrice());
			ps.setString(4, product.getProductId());
			status = ps.executeUpdate();
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return status;		
	}
	
	public static int deleteProduct(String productId) {
		
		int status = 0;
		
		try {
			
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from product where prod_id = ?");
			ps.setString(1, productId);
			status = ps.executeUpdate();
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return status;		
	}

}
