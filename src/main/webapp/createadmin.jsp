<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form action="createadminaccount" modelAttribute="create" >
EMAIL: <form:input path="email"/><br>
PASSWORD: <form:input path="password"/><br>
NAME: <form:input path="name"/><br>
<form:button>Admin Register</form:button>
</form:form>
</body>
</html> 