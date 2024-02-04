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
<form:form action="saveditem" modelAttribute="loaditem" method="post">
NAME: <form:input path="name"/><br>
COST: <form:input path="cost"/><br>
QUANTITY: <form:input path="quandity"/><br>
<form:button>submit</form:button>





</form:form>
</body>
</html>