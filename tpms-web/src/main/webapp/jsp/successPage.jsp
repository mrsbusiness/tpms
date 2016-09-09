                
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page session="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Message Board</title>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="Stylesheet" href="../../css/style.css">
<link rel="Stylesheet" href="../../../css/style.css">
<link href='http://fonts.googleapis.com/css?family=Niconne'
	rel='stylesheet' type='text/css'>
</head>
<body>
<div class="wrapper">

		<div class="header">
			<div class="heading">For Hire Buses</div>
		</div>
	<%@include file="menu.html"%>
	
	<div class="main">	
	<div class="content">
	<div class="status">
<c:if test="${not empty statusMessageKey}">
    <p>${statusMessageKey}</p>
</c:if></div></div></div>

<div class="footer"><small>&copy; MRS </small></div>

</div>
</body>
</html>