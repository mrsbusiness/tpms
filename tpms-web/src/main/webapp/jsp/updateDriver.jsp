<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Update Driver Information</title>
<meta charset="utf-8">

   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">


<link rel="Stylesheet" href="../../../css/style.css">
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
<h3>Update Driver Information</h3>
<c:url var="url" value="" /> 
<form:form action="${url}" commandName="">



<br>

<div class="bl"><div class="left">Date:</div><div class="right"><form:input type="date" path="Date" size="15"/></div></div>

<div class="bl"><div class="left">Select Driver: </div><div class="right">
  
<c:if test="${not empty employees}">
 
		<ul>
			 <form:select  path="empId">
				<c:forEach var="employee" items="${employees}">
				  <form:option value="${employee.id}">${employee.firstName} ${employee.lastName}</form:option>
				</c:forEach>
			</form:select>
		</ul>
 
	</c:if>
	
</div></div> 


<div class="bl"><div class="left"></div><div class="right"></div></div><br>

<div class="bl"><div class="navigation">
<ul>
<li>&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Submit">&nbsp;&nbsp;&nbsp;&nbsp;</li>
<li>&nbsp;&nbsp;<input type="reset" value="Reset"><li>
</ul>
</div>
</div>

</form:form>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /></div>


</div>

<div class="bl"><div class="left"></div><div class="right"></div></div><br>
<div class="bl"><div class="left"></div><div class="right"></div></div><br>
<br>
<div class="footer">
<small>&copy; MRS </small>
</div>

</div>
</body>

</html>