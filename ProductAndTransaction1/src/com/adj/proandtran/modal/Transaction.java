package com.adj.proandtran.modal;

public class Transaction {

	
	private int productId,quantity,transactionId;
	private  String transactionType;
	
	public Transaction( int productId, int quantity, String transactionType) {
		super();
		
		this.productId = productId;
		this.quantity = quantity;
		this.transactionType = transactionType;
	}
	public Transaction() {}
	
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	
}
