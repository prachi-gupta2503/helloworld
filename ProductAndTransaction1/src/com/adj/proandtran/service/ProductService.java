package com.adj.proandtran.service;

import java.sql.SQLException;
import java.util.List;

import com.adj.proandtran.modal.Product;

public interface ProductService {

	void insertProduct(Product product) throws SQLException;
	List<Product> getProducts() throws SQLException;
	boolean isProductAvailable(int id) throws SQLException;
}
