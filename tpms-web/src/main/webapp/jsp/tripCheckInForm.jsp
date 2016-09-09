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
<h3>Trip Check In</h3>
<c:url var="url" value="./create" /> 
<form:form action="${url}" commandName="tripOpenData">



<br>

<div class="bl"><div class="left">Trip Start Date:</div><div class="right"><form:input type="date" path="tripStartDate" style="width: 167px;"  required="true"/></div></div>

<div class="bl"><div class="left" >Select Driver: </div><div class="right" >
  
<c:if test="${not empty employees}" >
 
		<ul >
			 <form:select  path="empId"  >
				<c:forEach var="employee" items="${employees}">
				  <form:option value="${employee.id}">${employee.firstName} ${employee.lastName}</form:option>
				</c:forEach>
			</form:select>
		</ul>
 
	</c:if>
	
</div></div> 

<div class="bl"><div class="left">Select Bus: </div><div class="right">
  
<c:if test="${not empty busesForJSP}">
 		<ul>
			 <form:select  path="busRegId">
				<c:forEach var="tempBus" items="${busesForJSP}">
				  <form:option value="${tempBus.registrationNumber}"/>
				</c:forEach>
			</form:select>
		</ul>
 
	</c:if>
	
</div></div><br>


<div class="bl"><div class="left">Driver Reporting time</div><div class="right"><form:input type="time" path="driverStartReportingTime" style="width: 167px;"/></div></div><br>

<div class="bl"><div class="left">Bus Departure Time</div><div class="right"><form:input type="time" path="busStartDepatureTime" style="width: 167px;"/></div></div><br>

<div class="bl"><div class="left">Starting KM Reading </div><div class="right"><form:input path="startingKMReading" style="width: 167px;"/></div></div><br>

<div class="bl"><div class="left">Fuel (liters)</div><div class="right"><form:input path="startingFuelInLtrs" style="width: 167px;"/></div></div><br>

<div class="bl"><div class="left">Sales Rate</div><div class="right"><form:input path="staringFuelSalesRate" style="width: 167px;"/></div></div><br>

<div class="bl"><div class="left">Cost of Fuel</div><div class="right"><form:input path="costOfFuelStarting" style="width: 167px;" /></div></div><br>

<div class="bl"><div class="left">Inspection Driver</div><div class="right"><form:radiobutton  path="tripStartInspectionDriver" value="yes" />&nbsp;&nbsp;Yes&nbsp;<form:radiobutton  path="tripStartInspectionDriver" value="no"/>&nbsp;&nbsp;No&nbsp;</div></div><br>

<div class="bl"><div class="left">Inspection Bus</div><div class="right"><form:radiobutton  path="tripStartInspectionBus" value="yes" />&nbsp;&nbsp;Yes&nbsp;<form:radiobutton  path="tripStartInspectionBus" value="no"/>&nbsp;&nbsp;No&nbsp;</div></div><br>

<div class="bl"><div class="left">Remarks</div><div class="right"><form:textarea style="resize:none" path="tripStartingRemarks" cols="22" rows="2" maxlength="100" /></div></div><br>

<div class="bl"><div class="left"></div><div class="right"></div></div><br>

<div class="bl"><div class="navigation">
<ul>
<li>&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Submit" class="tpmsButton">&nbsp;&nbsp;&nbsp;&nbsp;</li>
<li>&nbsp;&nbsp;<input type="reset" value="Reset" class="tpmsButton"><li>
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