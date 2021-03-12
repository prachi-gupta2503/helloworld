package com.adj.proandtra.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.adj.proandtran.dao.imp.ProductDaoImp;
import com.adj.proandtran.modal.Product;
import com.adj.proandtran.service.ProductService;


public class ProductServiceImp implements ProductService{

	
	private ProductDaoImp productDao;
	
	
	public ProductServiceImp()  {
		
		 productDao=ProductDaoImp.getProductDaoInstance();
	}
	@Override
	public void insertProduct(Product product) throws SQLException {
		int productId=product.getProductId();
		String productName=product.getProductName();
		int productPrice=product.getProductPrice();
		int productStock=product.getProductStock();
	    productDao.insertProduct(productId, productName, productPrice, productStock);
		
	}
	@Override
	public List<Product> getProducts() throws SQLException {
		
		return productDao.getProducts();
		
	}
	@Override
	public boolean isProductAvailable(int id) throws SQLException {
		
		return productDao.isProductAvailable(id);
	}
}
