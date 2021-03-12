package com.adj.proandtran.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adj.proandtra.service.imp.ProductServiceImp;
import com.adj.proandtran.modal.Product;





@WebServlet("/servlet/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try {
		if(request.getQueryString()!=null)
		{
			String action=request.getParameter("action");
			
			switch(action)
			{
			case "Add Product":
				
				
				addProduct(request,response);
				break;
				
				
			case "productList":
				showList(response, request);
				break;
			}
				
				
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}

	
	private void addProduct(HttpServletRequest request,HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException, ServletException {
		ProductServiceImp productServie=new ProductServiceImp();
		String productId=request.getParameter("product_id");
		
		if(productId=="") {
			
			response.sendRedirect("../Product.jsp?msg=nullValue");
		}
		else if( productServie.isProductAvailable(Integer.parseInt(productId)))
			response.sendRedirect("../Product.jsp?msg=duplicateId");
		else {
		String productName=request.getParameter("product_name");
		int productPrice=Integer.parseInt(request.getParameter("product_price"));
		int productStock=Integer.parseInt(request.getParameter("product_stock"));
		Product product=new Product(Integer.parseInt(productId), productStock, productPrice, productName);
	
		productServie.insertProduct(product);
		showList(response, request);
		}
	}
	
	private void showList( HttpServletResponse response, HttpServletRequest request) throws SQLException, ServletException, IOException, ClassNotFoundException {
		ProductServiceImp productService=new ProductServiceImp();
		List<Product> productList=productService.getProducts();
		request.setAttribute("productList", productList);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("../ProductList.jsp");
		requestDispatcher.forward(request, response);
		
	}
}
