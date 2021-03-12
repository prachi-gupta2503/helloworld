package com.adj.proandtran.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adj.proandtra.service.imp.TransactionServiceImp;
import com.adj.proandtran.modal.Product;
import com.adj.proandtran.modal.Transaction;



@WebServlet("/servlet/TransactionController")
public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			

			if(request.getQueryString()!=null)
			{
				String action=request.getParameter("action");
				
				try {
				switch(action) {
				
				case "productName":
					getProductsName(request, response);
					break;
				case "Transaction":
					
					addTransaction(request,response);
					break;
				case "transactionList":
					showList(response, request);
					
					default:
						
				}
				
			
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			}
			
			
		}

	public void addTransaction(HttpServletRequest request,HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {

		int productId = Integer.parseInt(request.getParameter("product"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String transactionType = request.getParameter("transactionType");
		Transaction transaction = new Transaction(productId, quantity, transactionType);
		TransactionServiceImp transactionService = new TransactionServiceImp();
		boolean flag = transactionService.setStock(transaction);
		if (flag) {
			transactionService.insertTransaction(transaction);
			Map<Transaction,Product> map=transactionService.getTransactions();
			
			request.setAttribute("map",map );
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("../TransactionList.jsp");
		    
		    requestDispatcher.forward(request, response);
			
		}
		else 
			response.sendRedirect("../Transaction.jsp?msg=quantity is more than stock");
	}

	private void getProductsName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {

		TransactionServiceImp transactionService = new TransactionServiceImp();
		List<Product> productsName = transactionService.getProducts();

		request.setAttribute("productsName", productsName);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("../Transaction.jsp");
		requestDispatcher.forward(request, response);

		
	}
	
	private void showList(HttpServletResponse response, HttpServletRequest request) throws SQLException, ClassNotFoundException, ServletException, IOException{
		TransactionServiceImp transactionService=new TransactionServiceImp();
		Map<Transaction,Product> map=transactionService.getTransactions();
		
		request.setAttribute("map",map );
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("../TransactionList.jsp");
	    
	    requestDispatcher.forward(request, response);
	   
	}

}
