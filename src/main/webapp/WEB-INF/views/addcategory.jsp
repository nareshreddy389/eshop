<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="adminheader.jsp" %>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="#">
categoryname<input type="text" name="c"/>
categorydescription<input type="text" name="d"/>
<input type="submit" value="submit">
</form>
</body>
</html>