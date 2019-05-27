<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ include file="UserHeader.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title></title>
</head>
<body>
<div class="container-fluid">
<div class="row">
<c:forEach items="${prolist}" var="pro">
  <div class="col-sm-2" style="background-color:white;">
 <img src="resources/product-images/${pro.productId}.jpg" height="100" width="100">
 </br>
 ProductId:- <td>${pro.productId}</td>
</br>
ProductName:- <td>${pro.productName}</td>
</br>
ProductDescription:- <td>${pro.productDescription}</td>
</br>
ProductPrice:- <td>${pro.productPrice}</td>
</br>
<td><a href="viewdetails?proid=${pro.productId}">View Details</a>
</br>
 </div>
</c:forEach>
 </div>
</div>
</body>
</html>