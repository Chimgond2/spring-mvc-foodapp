<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="saveproduct" modelAttribute="saveproduct">
NAME: <form:input path="name"/><br>
PRODUCT TYPE:<form:input path="type"/><br>
COST: <form:input path="cost"/><br>

<form:button>Save Product</form:button>


</form:form>

</body>
</html>