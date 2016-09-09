<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<link rel="Stylesheet" href="../../css/openTripsView.css">
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

					<c:if test="${not empty openTrips}">
					<br><br><h2>Open Trips In The System</h2> <br>
<h3>All The trips will be in open state un-till fuel is entered for KMPL</h3>
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
								<strong>Status</strong>
							</div>
							<div class="rTableHead">
								<strong>KMPL        (0 = NA)</strong>
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
								<strong>Close Trip</strong>
							</div>			
							<div class="rTableHead">
								<strong>Delete Trip</strong>
							</div>				
						</div>
						</c:if>
						<c:if test="${empty openTrips}">
						<br>
						<br>
						<br>
    						<h2>There are no Records in the Open State </h2>
						</c:if>
							
						<c:forEach var="openTrip" items="${openTrips}">
				  			<div class="rTableRow">
							<div class="rTableCell">${openTrip.tripStartDate}</div>
							<div class="rTableCell">${openTrip.bus.registrationNumber}</div>
							<div class="rTableCell">${openTrip.employee.firstName}  ${openTrip.employee.lastName}</div>
							<div class="rTableCell">${openTrip.startingKMReading}</div>
							<div class="rTableCell">${openTrip.status}</div>
							<div class="rTableCell">${openTrip.KMPL}</div>
							<div class="rTableCell">${openTrip.tripStartInspectionDriver}</div>
							<div class="rTableCell">${openTrip.tripStartInspectionBus}</div>
							<div class="rTableCell">${openTrip.tripStartingRemarks}</div>
							
							<div class="rTableCellCheckOut" >
							<a href="./close/form?tripId=${openTrip.tripId}&busRegId=${openTrip.bus.registrationNumber}&empId=${openTrip.employee.id}">Check-Out</a>
								<c:url var="url" value="./close/form" /> 
										<form:form action="${url}" commandName="tripCheckOutData" method="GET" >
											<form:input type="hidden" path="tripId" value="" />
											<!-- <input type="submit" value="Check-Out"> -->																	
										</form:form>																	
							</div>			
							
							<div class="rTableCellDelete" >
								<a href="./delete/form?tripId=${openTrip.tripId}&busRegId=${openTrip.bus.registrationNumber}&empId=${openTrip.employee.id}">Delete</a>						
							</div>	
							
											
						</div>
						</c:forEach>				
					</div>
 <div><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /></div>


</div>


<div class="lessContentPagefooter">
<small>&copy; MRS </small>
</div>

</div>
</body>

</html>