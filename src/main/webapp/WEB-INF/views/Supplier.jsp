<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    <%@ include file="adminheader.jsp" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="sform"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sform:form action="addsup"  method="post" modelAttribute="sup">
<sform:input  path="SupplierId" type="hidden"  />
SupplierName <sform:input  path="SupplierName" />
SupplierDetails <sform:input  path="SupplierDetails" />
<input type="submit" value="${buttonname}" />
</sform:form>
</body>
</html>