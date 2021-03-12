
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel=stylesheet href=css/bootstrap.css />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<link rel=stylesheet href='transactionList.css'>
</head>
<body>

<table class='table table-striped table-hover '>
<thead>
<th>Transaction Id</th>
<th>Product Name</th>
<th>Product Price</th>
<th>Transaction type</th>
<th>Quantity</th>

</thead>
<tbody>

<c:forEach items="${map}"  var="transaction">
<tr>
 <td> <c:out value="${transaction.key.transactionId}" /></td>
  <td><c:out value="${transaction.value.productName}" /></td>
 
  <td><c:out value="${transaction.value.productPrice}" /></td>
  <td><c:out value="${transaction.key.transactionType}" /></td>
   <td><c:out value="${transaction.key.quantity}" /></td>
   </tr>
</c:forEach>   
<tr>
<%-- 
<%
    try{
    Service service=new Service();
    ResultSet resultset=service.getTransactions();
    while(resultset.next())
    {
    %>
    <tr>
    <td><%=resultset.getString(1)%></td>
    <td><%=resultset.getString(2)%></td>
    <td><%=resultset.getString(3)%></td>
    <td><%=resultset.getString(4)%></td>
     <td><%=resultset.getString(5)%></td>
    </tr>
    <% 
    }
    }catch(Exception e)
    {
    	e.printStackTrace();
    }

   %>
   --%>
</tbody>
</table>
</body>
</html>