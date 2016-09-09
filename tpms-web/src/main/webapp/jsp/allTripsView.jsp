<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<c:if test="${not empty statusMessageKey}">
    <p><fmt:message key="${statusMessageKey}"/></p>
</c:if></div></div></div>

<div class="content">
<br><br><h2> Trips In The Requested Range</h2>
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
								<strong>Trip End Date</strong>
							</div>
							<div class="rTableHead">
								<strong>Trip End KM</strong>
							</div>
							<div class="rTableHead">
								<strong>Trip Total KM</strong>
							</div>
							<div class="rTableHead">
								<strong>Trip Fuel Cost</strong>
							</div>
							<div class="rTableHead">
								<strong>Fuel Cost Per Ltr</strong>
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
							<div class="rTableHead">
								<strong>Edit Trip</strong>
							</div>			
									
						</div>
						<c:forEach var="openTrip" items="${openTrips}">
				  			<div class="rTableRow">
							<div class="rTableCell">${openTrip.tripStartDate}</div>
							<div class="rTableCell">${openTrip.bus.registrationNumber}</div>
							<div class="rTableCell">${openTrip.employee.firstName}  ${openTrip.employee.lastName}</div>
							<div class="rTableCell">${openTrip.startingKMReading}</div>
							<div class="rTableCell">${openTrip.tripEndDate}</div>
							<div class="rTableCell">${openTrip.endingKMReading}</div>
							<div class="rTableCell"><c:out value='${openTrip.endingKMReading - openTrip.startingKMReading}'/></div>
							<div class="rTableCell">${openTrip.costOfFuelStarting}</div>
							<div class="rTableCell">${openTrip.startingFuelInLtrs}</div>
							<div class="rTableCell">${openTrip.tripStartInspectionDriver}</div>
							<div class="rTableCell">${openTrip.tripStartInspectionBus}</div>
							<div class="rTableCell">${openTrip.tripStartingRemarks}</div>
							
							<div class="rTableCellCheckOut" >
								<a href="./edit/form?tripId=${openTrip.tripId}&busRegId=${openTrip.bus.registrationNumber}&empId=${openTrip.employee.id}">Check-Out</a>
						    </div>			
											
						</div>
						</c:forEach>				
					</div>
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