package com.adj.proandtra.service.imp;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;


import com.adj.proandtran.dao.imp.ProductDaoImp;
import com.adj.proandtran.dao.imp.TransactionDaoImp;
import com.adj.proandtran.modal.Product;
import com.adj.proandtran.modal.Transaction;;

public class TransactionServiceImp{

	
	private TransactionDaoImp transactionDao;

	
	public TransactionServiceImp()  {
		transactionDao = TransactionDaoImp.getTransactionDaoInstanse();
	}

	public void insertTransaction(Transaction transaction) throws SQLException {

		int productId = transaction.getProductId();
		int quantity = transaction.getQuantity();
		String transactionType = transaction.getTransactionType();
		transactionDao.insertTransaction(productId, quantity, transactionType);
	}

	public boolean setStock(Transaction transaction) throws SQLException {
		boolean flag = false;
		if (transaction.getTransactionType().equalsIgnoreCase("sale")) {
           
			Product product = transactionDao.getProduct(transaction.getProductId());
			int stock=product.getProductStock();
			
				if (stock >= transaction.getQuantity()) {
					stock = stock - transaction.getQuantity();
					transactionDao.updateProductStock(product.getProductId(), product.getProductName(), product.getProductPrice(),
							stock);
					flag = true;
				} else
					flag = false;
			
		} else if (transaction.getTransactionType().equalsIgnoreCase("purchase")) {
			  
			Product product = transactionDao.getProduct(transaction.getProductId());
			int stock=product.getProductStock();
			
				if (stock >= transaction.getQuantity()) {
					stock = stock + transaction.getQuantity();
					transactionDao.updateProductStock(product.getProductId(), product.getProductName(), product.getProductPrice(),
							stock);
				flag = true;

			}
         
		}
		return flag;
	}
	
	public Map<Transaction, Product> getTransactions() throws SQLException{
		
		Map<Transaction,Product> map=transactionDao.getTransactions();
		return map;
	}
	
	public List<Product> getProducts() throws  SQLException {
		
		ProductDaoImp productDao=ProductDaoImp.getProductDaoInstance();
		List<Product> product=productDao.getProducts();
		return product;
	}
}
