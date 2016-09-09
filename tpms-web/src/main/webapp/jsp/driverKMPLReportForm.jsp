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
<link href='http://fonts.googleapis.com/css?family=Niconne'
	rel='stylesheet' type='text/css'>

</head>

<body>

	<div class="wrapper">

		<div class="header">
			<div class="heading">For Hire Buses</div>
			<%@include file="menu.html"%>

		</div>

		<div class="main">
		
			<c:if test="${not empty statusMessageKey}">
    				<p>${statusMessageKey }/></p>
			</c:if>

			<div class="content">
			<br>
			<br>
			<br>
				<h3>Driver's KMPL Report - Select Dates and Driver</h3>
				<br>
				<br>
				<form action="./driverkmplview">
					
					<div class="bl">
						<div class="left">From Date:</div>
						<div class="right">
							<input type="date" name="fromDate" style="width: 167px;" />
						</div>
					</div>
					<div class="bl">
						<div class="left">To Date:</div>
						<div class="right">
							<input type="date" name="toDate" style="width: 167px;" />
						</div>
					</div>

					<div class="bl">
						<div class="left">Select Driver:</div>
						<div class="right">

							<c:if test="${not empty empData}">

									<select name="empId">
										<c:forEach var="emp" items="${empData}">
											<option value="${emp.key}">${emp.value}</option>
										</c:forEach>
									</select>
							

							</c:if>
							<c:if test="${ empty empData}">
		No Drivers Available
	</c:if>

						</div>
					</div>

					<div class="bl">
						<div class="left"></div>
						<div class="right"></div>
					</div>
					<br>

					<div class="bl">
						<div class="navigation">
							<ul>
								<li>&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit"
									value="Submit" class="tpmsButton">&nbsp;&nbsp;&nbsp;&nbsp;
								</li>
								<li>&nbsp;&nbsp;<input type="reset" value="Reset"  class="tpmsButton">
								<li>
							</ul>
						</div>
					</div>

				</form>
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