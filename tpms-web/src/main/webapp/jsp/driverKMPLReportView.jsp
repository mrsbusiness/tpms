<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>TPMS</title>
<meta charset="utf-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">


<link rel="Stylesheet" href="../../css/style.css">
<link rel="Stylesheet" href="../../css/reports.css">
<link href='http://fonts.googleapis.com/css?family=Niconne'
	rel='stylesheet' type='text/css'>

</head>

<body>

	<div class="wrapper">

		<div class="header">
			<div class="heading">For Hire Buses</div>
			<%@include file="menu.html"%>

		</div>

		<div  align="center">


			
			<div style="color:white">
				<br>
				<br>
				<h2> KMPL Report</h2>
			</div>
			
			
			<c:if test="${not empty statusMessageKey}">
    				<p>${statusMessageKey }/></p>
			</c:if>
			
			<br>

			<c:if test="${not empty driverKMPLReportImagesList}">
				
				<c:forEach items="${driverKMPLReportImagesList}" var="driverKMPLReportImage">
    					<img alt="img" src="data:image/jpeg;base64,${driverKMPLReportImage}" />
    					<br>
				</c:forEach>
				

			</c:if>
				<br>
			
			<div class="content">
			
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</div>


		</div>

		<div class="lessContentPagefooter">
			<small>&copy; MRS </small>
		</div>

	</div>
</body>

</html>