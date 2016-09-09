<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Contact Us</title>
<meta charset="utf-8">

   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">


<link rel="Stylesheet" href="../../css/style.css">
<link href='http://fonts.googleapis.com/css?family=Niconne' rel='stylesheet' type='text/css'>

</head>

<body>

<div class= "wrapper">

<div class="header">
<div class="heading">
For Hire Buses
</div>

<%@include file="menu.html"%>

</div>



<div class="main">


<div class="content">
<h3>Contact Us</h3>
<form name="employee" method="post" action="">




<br><br>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
 </form>

</div></div>
<div class="bl"><div class="left"></div><div class="right"></div></div><br>
<br>
<div class="footer">
<small>&copy; MRS </small>
</div>

</div>
</body>

</html>