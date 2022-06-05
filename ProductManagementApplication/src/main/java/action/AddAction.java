package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.ProductManagementDAO;
import pojo.Product;

public class AddAction extends ActionSupport{
	
	private String productId;
	private String productName;
	private String productCategory;
	private Integer productPrice;
	
	public String execute() {
		
		String statusCode = "";
		
		Product product = new Product(productId, productName, productCategory, productPrice);
		int recordAdded = ProductManagementDAO.addProduct(product);
		
		if(recordAdded == 1) {
			statusCode = ActionSupport.SUCCESS;
		} else {
			statusCode = ActionSupport.ERROR;
		}
		
		return statusCode;
		
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

}
