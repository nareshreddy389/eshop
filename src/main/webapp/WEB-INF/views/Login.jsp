<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sform:form action="tologin"  method="post" modelAttribute="user">
Email<sform:input  path="email"/>
Password<sform:input  path="password"/>
<input type="submit"  value="Login"/>
</sform:form>
${logininfo} 
</body>
</html>