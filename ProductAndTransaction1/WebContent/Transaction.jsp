
 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel='stylesheet' href='css/bootstrap.css'>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<link rel='stylesheet' href='transaction.css'>
<style>

  
</style>
</head>
<body>
 
   
   <h1 id=heading> Transaction </h1>
  <div class="transactionForm">
 
   <form action="TransactionController" >
   <label >Choose product</label>
  <select name=product >
  
   <c:forEach items="${productsName}" var="product">
    <option value=<c:out value="${product.getProductId()}" />><c:out value="${product.getProductName()}" /></option>
   </c:forEach>
   </select>
   <div>
    <label>Product quantity </label>
   <input type=number name=quantity class=input placeholder="quantity"   />
   </div>
    <div>
    <label>choose option</label>
   <select name=transactionType>
   <option value=sale>sale</option>
    <option value=purchase>purchase</option>
   </select>
   </div>
    
    <div>
    <input type=submit  name=action value="Transaction">
    </div>
   </form>
   </div>
   
</body>
</html>