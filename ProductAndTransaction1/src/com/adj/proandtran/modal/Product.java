package com.adj.proandtran.modal;

public class Product {

	private int productId,productStock,productPrice;
    private	String productName;
	public Product(int productId, int productStock, int productPrice, String productName) {
		super();
		this.productId = productId;
		this.productStock = productStock;
		this.productPrice = productPrice;
		this.productName = productName;
	}
	public Product() {}
	public Product(Product product) {
		
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductStock() {
		return productStock;
	}
	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
}
