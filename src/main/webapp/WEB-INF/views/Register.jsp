<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sform:form action="toregister"  method="post" modelAttribute="reg">
Email<sform:input  path="email"/>
Password<sform:input  path="password"/>
Username<sform:input  path="username"/>
MobileNumber<sform:input  path="mobileno"/>
Address<sform:input  path="address"/>
<input type="submit"  value="Register"/>
</sform:form>
</body>
</html>