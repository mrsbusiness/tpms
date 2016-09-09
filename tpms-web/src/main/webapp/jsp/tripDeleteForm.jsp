<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Driver Log In</title>
<meta charset="utf-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">


<link rel="Stylesheet" href="../../../css/style.css">
<link rel="Stylesheet" href="../../../css/openTripsView.css">
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
				<p>
					<fmt:message key="${statusMessageKey}" />
				</p>
			</c:if>
		</div>
	</div>
	</div>

	<div class="content">
		<br> <br>
		<h3>Click on Yes Button to Delete Record</h3>
		<div class="rTable">
			<div class="rTableRow">
				<div class="rTableHead">
					<strong>Trip Date</strong>
				</div>
				<div class="rTableHead">
					<strong>Registration Number</strong>
				</div>
				<div class="rTableHead">
					<strong>Driver Name</strong>
				</div>
				<div class="rTableHead">
					<strong>Start KM</strong>
				</div>
				<div class="rTableHead">
					<strong>Inspection By Driver</strong>
				</div>
				<div class="rTableHead">
					<strong>Inspection By Supervisor</strong>
				</div>
				<div class="rTableHead">
					<strong>Remarks</strong>
				</div>

			</div>
			<div class="rTableRow">
				<div class="rTableCell">${openTripForDelete.tripStartDate}</div>
				<div class="rTableCell">${openTripForDelete.bus.registrationNumber}</div>
				<div class="rTableCell">${openTripForDelete.employee.firstName}
					${openTripForDelete.employee.lastName}</div>
				<div class="rTableCell">${openTripForDelete.startingKMReading}</div>
				<div class="rTableCell">${openTripForDelete.tripStartInspectionDriver}</div>
				<div class="rTableCell">${openTripForDelete.tripStartInspectionBus}</div>
				<div class="rTableCell">${openTripForDelete.tripStartingRemarks}</div>



			</div>

		</div>
		<br>
		<br>
		<c:url var="url" value="/admin/trip/delete" />
		<form:form action="${url}" commandName="tripCheckOutData"
			method="POST">
			<form:input type="hidden" path="tripId"
				value="${openTripForDelete.tripId}" />
			<input type="submit" value="Yes" css="submiButton" class="tpmsButton"> &nbsp;
			<input type="submit" value="No" css="submiButton" class="tpmsButton">
		</form:form>

		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</div>



	<div class="bl">
		<div class="left"></div>
		<div class="right"></div>
	</div>
	<br>
	<div class="bl">
		<div class="left"></div>
		<div class="right"></div>
	</div>
	<br>
	<br>
	<div class="footer">
		<small>&copy; MRS </small>
	</div>

	</div>
</body>

</html>