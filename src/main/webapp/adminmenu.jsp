<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${message}</h1>
<h2>${messageabouteditproductbyadmin}</h2>
<form:form>

<a href="loadproduct">Add Product</a><br>
<a href="getproductbyid">Get Product By Id</a><br>
<a href="getallproduct">Get All Product</a><br>
</form:form>
</body>
</html>