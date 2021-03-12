package com.adj.proandtran.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

import com.adj.proandtran.dao.DbConnection;
import com.adj.proandtran.dao.TransactionDao;
import com.adj.proandtran.modal.Product;
import com.adj.proandtran.modal.Transaction;

public class TransactionDaoImp implements TransactionDao{
 
	private static TransactionDaoImp transactionDao;
	
	private TransactionDaoImp(){}
	
	public static TransactionDaoImp getTransactionDaoInstanse() {
		if(transactionDao == null)
		{
			transactionDao=new TransactionDaoImp();
		}
		return transactionDao;
	}
	@Override
   public void insertTransaction(int productId,int quantity,String transactionType) throws SQLException {
	 Connection connection=null;
	 try {
		 connection=DbConnection.connection();
		 PreparedStatement	pinsert=connection.prepareStatement("insert into transaction(product_id,transaction_type,quantity) values(?,?,?) ");
			pinsert.setInt(1,productId);
			pinsert.setInt(3, quantity);
			pinsert.setString(2,transactionType);
			pinsert.executeUpdate();
		 
	 }catch(SQLException | ClassNotFoundException e) {
		 e.printStackTrace();
	 }finally {
		 connection.close();
	 }
		
	}
	@Override
	public Map<Transaction,Product> getTransactions() throws SQLException {
		
		Statement statement=null;
		Connection connection=null;
		Map<Transaction,Product> map=null;
		try {
			connection=DbConnection.connection();
			statement=connection.createStatement();
			ResultSet resultset=statement.executeQuery("select transaction.id,transaction.transaction_type,transaction.quantity,product.id,product.name,product.price,product.stock from transaction inner join product on product.id=transaction.product_id");
			 map=new LinkedHashMap<>();
			while(resultset.next())
		    {
		    	
		    	Transaction transaction=new Transaction();
		    	Product product=new Product();
		    	transaction.setTransactionId(resultset.getInt(1));
		    	transaction.setQuantity(resultset.getInt(3));
		    	transaction.setTransactionType(resultset.getString(2));
		    	transaction.setProductId(resultset.getInt(4));
		    	product.setProductId(resultset.getInt(4));
		    	product.setProductName(resultset.getString(5));
		    	product.setProductPrice(resultset.getInt(6));
		    	product.setProductStock(resultset.getInt(7));
		    	map.put(transaction, product);
		    }
		}catch(ClassNotFoundException e) {
			
		}finally {
			if(connection!=null)
				connection.close();
		}
		
		return map;
	}
	
	@Override
	public Product getProduct(int id) throws SQLException
	{
		Statement statement=null;
		Connection connection=null;
		Product product=null;
		try {
			connection=DbConnection.connection();
			statement=connection.createStatement();
			ResultSet resultset=statement.executeQuery("select * from product where id="+id);
			if(resultset.next())
			{
				 product=new Product(id,resultset.getInt(4),resultset.getInt(3),resultset.getString(2));
				
			}
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}finally {
				if(connection !=null)
					connection.close();
			}
		
			return product;	
	}
	@Override
	public void updateProductStock(int id,String name,int price,int stock) throws SQLException
	{
		Connection connection=null;
		try {
			connection =DbConnection.connection();
			PreparedStatement pupdate=connection.prepareStatement("update  product set name=?,price=?,stock=? where id=?");
			pupdate.setString(1, name);
			pupdate.setInt(2, price);
			pupdate.setInt(3, stock);
			pupdate.setInt(4, id);
			pupdate.executeUpdate();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			
			if(connection!=null)
				connection.close();
		}
		
		
		
	}
}
