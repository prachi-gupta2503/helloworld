package com.adj.proandtran.dao;

import java.sql.SQLException;
import java.util.List;

import com.adj.proandtran.modal.Product;

public interface ProductDao {

	
	void insertProduct(int id,String name,int price,int stock)throws SQLException ;
	 List<Product> getProducts()throws SQLException ;
	 boolean isProductAvailable(int id) throws SQLException;
	
}
