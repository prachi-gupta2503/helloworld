package com.adj.proandtran.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.adj.proandtran.dao.DbConnection;
import com.adj.proandtran.dao.ProductDao;
import com.adj.proandtran.modal.Product;

public class ProductDaoImp implements ProductDao{
	
	private static ProductDaoImp productDao;
	
	private ProductDaoImp() {
		
	}
	public static ProductDaoImp getProductDaoInstance() {
		
		if(productDao == null) {
			productDao=new ProductDaoImp();
		}
		return productDao;
	}
    @Override
	public void insertProduct(int id,String name,int price,int stock) throws SQLException {
		Connection connection=null;
		try {
			connection=DbConnection.connection();
			PreparedStatement	pinsert=connection.prepareStatement("insert into product(id,name,price,stock) values(?,?,?,?) ");
			pinsert.setInt(1,id);
			pinsert.setString(2, name);
			pinsert.setInt(3,price);
			pinsert.setInt(4,stock);
			pinsert.executeUpdate();
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		 finally {
			if(connection!=null)
				connection.close();
			
		}
	}
		@Override
		public List<Product> getProducts() throws SQLException
		{   Connection connection=null;
		    Statement statement = null;
		    List<Product> productList=null;
		    try {
		      connection=DbConnection.connection();
		      statement=connection.createStatement();
		      productList=new ArrayList<>();
				ResultSet resultset=statement.executeQuery("select * from product ");
				while(resultset.next())
				{
					Product product=new Product();
					product.setProductId(resultset.getInt(1));
					product.setProductName(resultset.getString(2));
					product.setProductPrice(resultset.getInt(3));
					product.setProductStock(resultset.getInt(4));
					productList.add(product);
					
				}
		    }catch(Exception e) {
		    	e.printStackTrace();
		    }finally {
		    	if(connection!=null)
		    		connection.close();
		    }
		
			return  productList;
		}
	
		public boolean isProductAvailable(int id) throws SQLException
		{
			 Connection connection=null;
			 Statement statement=null;
			 try {
			      connection=DbConnection.connection();
			      statement=connection.createStatement();
			      ResultSet resultset=statement.executeQuery("select * from product where id="+id);
			      if(resultset.next())
			      {
			    	 return true; 
			      }
			 }catch(Exception e) {
				 e.printStackTrace();
			 }finally {
				 connection.close();
			 }
			 return false;
		}
}
