package action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.ProductManagementDAO;
import pojo.Product;

public class WelcomeAction extends ActionSupport{
	
	List<Product> products;
	private String productName;
	private String productCategory;
	private Date createdDate;
	
	private void initializeProducts() {
		System.out.println("**** Filter Data *****");
		System.out.println(productName);
		System.out.println(productCategory);
		System.out.println(createdDate);
		String createdDateStr = "";
		if(createdDate != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
			createdDateStr = formatter.format(createdDate);
		}
		products = ProductManagementDAO.getAllProducts(productName, productCategory, createdDateStr);
	}
	
	public String execute() {
		
		initializeProducts();
		System.out.println("returning success");
		
		return "success";
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
