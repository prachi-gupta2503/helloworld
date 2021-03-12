package com.adj.proandtran.dao;

import java.sql.SQLException;
import java.util.Map;

import com.adj.proandtran.modal.Product;
import com.adj.proandtran.modal.Transaction;

public interface TransactionDao {

	void insertTransaction(int productId,int quantity,String transactionType) throws SQLException;
	Map<Transaction,Product> getTransactions()throws SQLException;
	Product getProduct(int id) throws SQLException;
	void updateProductStock(int id,String name,int price,int stock) throws SQLException;
}
