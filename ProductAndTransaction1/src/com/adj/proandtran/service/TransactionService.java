package com.adj.proandtran.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.adj.proandtran.modal.Product;
import com.adj.proandtran.modal.Transaction;

public interface TransactionService {

	void insertTransaction(Transaction transaction) throws SQLException;
	Map<Transaction, Product> getTransactions() throws SQLException;
	List<Product> getProducts() throws  SQLException;
	boolean setStock(Transaction transaction) throws SQLException ;
}
