<%@page import="com.naresh.model.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="adminheader.jsp" %>
    <%@ page isELIgnored="false" %>
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
categoryId
</th>
<th>
categoryName
</th>
<th>
categoryDiscription
<th>
Edit
<th>
Delete
</th>
</tr>
<c:forEach items="${catlist}" var="cat">
<tr>
<td>${cat.categoryId}</td>
<td> ${cat.categoryName}</td>
<td> ${cat.categoryDiscription}</td>
<td> <a href="edit?catid=${cat.categoryId}">edit</a></td>
<td> <a href="del?catid=${cat.categoryId}">delete</a></td>
</tr>
</c:forEach>
</body>
</html>