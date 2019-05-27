 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ include file="adminheader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table  border="1">
<tr>
<th>
ProductId
</th>
<th>
ProductName
</th>
<th>
ProductPrice
</th>
<th>
ProductDescription
</th>
<th>
ProductCategory
</th>
<th>
ProductSupplier
</th>
<th>
ProductImage
<td>
Edit
<th>
Delete
</th>
</tr>
<c:forEach items="${prolist}" var="pro">
<tr>
<td>${pro.productId}</td>
<td>${pro.productName}</td>
<td>${pro.productPrice}</td>
<td>${pro.productDescription}</td>
<td>${pro.productCategory}</td>
<td>${pro.productSupplier}</td>
<td><img src="resources/product-images/${pro.productId}.jpg" height="100" width="100"></td>
<td> <a href="editpro?proid=${pro.productId}">edit</a></td>
<td> <a href="deletepro?proid=${pro.productId}">delete</a></td>
</tr>
</c:forEach>
</body>
</html>
</body>
</html>