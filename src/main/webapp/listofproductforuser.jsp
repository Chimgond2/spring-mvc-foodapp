<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="6px solid black">
<thead>
<tr>
<th>ID</th>
<th>NAME</th>
<th>TYPE</th>
<th>COST</th>
<th>ADD Item to order</th>


</tr>
<c:forEach var="list" items="${listofproduct}">
<tr>
<td>${list.getId()}</td>
<td>${list.getName()}</td>
<td>${ list.getType()}</td>
<td>${list.getCost()}</td>
<td><a href="additem?id=${list.getId()}">Add Item</a></td>
</tr>
</c:forEach>
</thead>
</table>


</body>
</html>