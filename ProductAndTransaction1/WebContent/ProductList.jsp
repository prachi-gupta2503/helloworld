 
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<link rel=stylesheet href='productList.css' >

</head>
<body>

<table class='table table-striped table-hover '>
<thead>
<th>Product Id</th>
<th>Product Name</th>
<th>Product Price</th>
<th>Product Stock</th>

</thead>
<tbody>

    <c:forEach items="${productList}" var="product" >
    <tr>
    <td><c:out value="${product.getProductId()}" /></td>
    <td><c:out value="${product.getProductName()}" /></td> 
     <td><c:out value="${product.getProductPrice()}" /></td>
    <td><c:out value="${product.getProductStock()}" /></td>
    </tr>
    </c:forEach>
</tbody>
</table>
</body>
</html>