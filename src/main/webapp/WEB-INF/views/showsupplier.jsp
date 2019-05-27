<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    <%@ include file="adminheader.jsp" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
SupplierId
</th>
<th>
SupplierName
</th>
<th>
SupplierDetails
<th>
Edit
<th>
Delete
</th>
</tr>
<c:forEach items="${suplist}" var="sup">
<tr>
<td>${sup.supplierId}</td>
<td>${sup.supplierName}</td>
<td>${sup.supplierDetails}</td>
<td> <a href="editing?supid=${sup.supplierId}">edit</a></td>
<td> <a href="deleting?supid=${sup.supplierId}">delete</a></td>
</tr>
</c:forEach>
</body>
</html>