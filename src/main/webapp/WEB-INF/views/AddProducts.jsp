<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    <%@ include file="adminheader.jsp" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform"  %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
<sform:form action="addpro"  method="post" modelAttribute="pro" enctype="multipart/form-data">
ProductName <sform:input  path="productName"/>
ProductPrice <sform:input  path="productPrice"/>
ProductDescription <sform:input  path="productDescription"/>

<sform:select path="productCategory">
<c:forEach items="${catlists}" var="cat">

<sform:option value="${cat.categoryName}"></sform:option>
</c:forEach>

</sform:select>

<sform:select path="productSupplier">
<c:forEach items="${suplist}" var="sup">

<sform:option value="${sup.supplierName}"></sform:option>
</c:forEach>

</sform:select>
<sform:input  path="productId" type="hidden"/>
<sform:input type="file" path="proimage"/>
<input type="submit"  value="${buttonname}"/>
</sform:form>
</body>
</html>