<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="signinuser" modelAttribute="loaduser">
NAME: <form:input path="name"/><br>
EMAIL: <form:input path="email"/><br>
PASSWORD: <form:input path="password"/><br>
PHONE: <form:input path="phone"/><br>
<form:button>USER SIGN IN</form:button>




</form:form>

</body>
</html>