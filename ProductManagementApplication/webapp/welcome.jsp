<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="style.css">
<sx:head/>
</head>
<body>

	<%@ include file="header.jsp" %>
	
	<div align="center">
		<h2>Welcome</h2>
		<s:form action="welcomeAction" class="filterPanel">
			<s:textfield name="productName" label="Product Name" class="formTextField"/>
			<s:textfield name="productCategory" label="Product Category" class="formTextField"/>
			<sx:datetimepicker name="createdDate" label="Create Date" displayFormat="dd-MMM-yyyy"/> 
			<s:submit value="Search Product" class="actionBtn"/>	
		</s:form>
	</div>
	
	<table width="750" class="productTable" align="center">
		<thead>
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Product Category</th>
				<th>Created Date</th>
				<th colspan="2">Actions</th>
			</tr>
		</thead>
		
		<s:iterator value="products" var="product">
			<tr>
				<td>
					<s:property value="#product.productId"/>
				</td>
				
				<td>
					<s:property value="#product.productName"/>
				</td>
				
				<td>
					<s:property value="#product.productCategory"/>
				</td>
				
				<td>
					<s:property value="#product.productPrice"/>
				</td>
				
				<td>
					<s:property value="#product.createdDate"/>
				</td>
				
				<td>
					<a href="updateDataAction?productId=<s:property value="#product.productId"/>">
						<button class="actionBtn">Update</button>
					</a>
				</td>
				
				<td>
					<a href="deleteAction?productId=<s:property value="#product.productId"/>">
						<button class="actionBtn">Delete</button>
					</a>
				</td>
				
			</tr>
		</s:iterator>
			
	</table>

</body>
</html>