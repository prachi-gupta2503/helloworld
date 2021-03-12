<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel='stylesheet' href='css/bootstrap.css'>
<link rel='stylesheet' href='css/product.css'>
</head>

<body>

	<%
  if(request.getQueryString()!=null)
  {
	  String msg=request.getParameter("msg");
	  if(msg.equalsIgnoreCase("nullValue"))
	  {
	  %>
	<h4>product Id can not be Blank</h4>

	<%}
	 else if(msg.equalsIgnoreCase("DuplicateId"))
	  {
	 %>
	<h4>product id can not be duplicate</h4>
	<%  
	  }
	}
	  %>
	<h1 id=heading>Add Product</h1>
	<div class="productForm">

		<form action="servlet/ProductController">
			<div>
				<label class=>Product Id </label><br /> 
				<input type=number name=product_id class=input placeholder="Product id" />
			</div>
			<div>
				<label class=>Product Name </label><br /> 
				<input type=text name=product_name class=input placeholder="Product name" />
			</div>
			<div>
				<label class=>Product Price </label><br /> <input type=Number
					name=product_price class=input placeholder="Product price" />
			</div>
			<div>
				<label class=>Product stock </label><br /> <input type=number
					name=product_stock class=input placeholder="Product stock" />
			</div>
			<div>
				<input type=submit name=action value="Add Product">
			</div>
		</form>
	</div>

</body>
</html>