<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ include file="UserHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<td><img src="resources/product-images/${prolist.productId}.jpg" height="300" width="300"></td>
</br>
ProductName:- ${prolist.productName}
</br>
ProductDescription:- <td>${prolist.productDescription}
</br>
ProductPrice:- ${prolist.productPrice}
</br>
ProductSupplier:- ${prolist.productSupplier}
</br>
<form action="Cart">
ProductId <input type="number" value="${prolist.productId}" name="id"/>
Quantity <input type="number" name="Quantity"/>
<input type="submit" value="AddToCart"/>
</form>
<a href="AddToCart?proid=${prolist.productId}">AddToCart</a>
</br>
<a href="#">BuyNow</a>
</br>
</body>
</html>