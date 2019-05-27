package com.naresh.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {
@Id	
int productId;
String productName;
int productPrice;
String productDescription;
String productCategory;
String productSupplier;
@Transient
private MultipartFile proimage;
public MultipartFile getProimage() {
	return proimage;
}
public void setProimage(MultipartFile proimage) {
	this.proimage = proimage;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public int getProductPrice() {
	return productPrice;
}
public void setProductPrice(int productPrice) {
	this.productPrice = productPrice;
}
public String getProductDescription() {
	return productDescription;
}
public void setProductDescription(String productDescription) {
	this.productDescription = productDescription;
}
public String getProductCategory() {
	return productCategory;
}
public void setProductCategory(String productCategory) {
	this.productCategory = productCategory;
}
public String getProductSupplier() {
	return productSupplier;
}
public void setProductSupplier(String productSupplier) {
	this.productSupplier = productSupplier;
}


}
