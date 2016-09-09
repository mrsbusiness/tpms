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


			<div class="content">
				<h3>Bus Information</h3>
				<c:url var="url" value="./create" />
				<form:form action="${url}" commandName="bus">

					<div class="bl">
						<div class="left">Registration Number</div>
						<div class="right">
							<form:input path="registrationNumber" style="width: 169px;"/>
						</div>
					</div>
					<br>

					<div class="bl">
						<div class="left">Engine Number</div>
						<div class="right">
							<form:input path="engineNumber" style="width: 169px;"/>
						</div>
					</div>
					<br>

					<div class="bl">
						<div class="left">Chasis Number</div>
						<div class="right">
							<form:input path="chasisNumber" style="width: 169px;"/>
						</div>
					</div>
					<br>

					<div class="bl">
						<div class="left">Insurance Policy Number</div>
						<div class="right">
							<form:input path="insurancePolicyNumber" style="width: 169px;"/>
						</div>
					</div>
					<br>

					<div class="bl">
						<div class="left">Policy Expiry Date</div>
						<div class="right">
							<form:input path="policyExpiryDate" type="date" style="width: 167px;"/>
						</div>
					</div>
					<br>

					<div class="bl">
						<div class="left">Road Tax Exp Date</div>
						<div class="right">
							<form:input path="roadTaxDate" type="date" style="width: 167px;"/>
						</div>
					</div>
					<br>

<div class="bl"><div class="left">Bus Type</div><div class="right">
 <form:select  path="busType" style="width: 170px;">
 <form:option value="Select Bus Type"></form:option>
 	<form:option value="Express">Express</form:option>
 	<form:option value="PalleVelugu">PalleVelugu</form:option>
	 </form:select>
  
</div></div><br>

<div class="bl"><div class="left">Bus Depot</div><div class="right">
 <form:select  path="busDepot" style="width: 170px;">
 <form:option value="Select Depot  "></form:option>
 	<form:option value="Narayankhed">Narayankhed</form:option>
 	<form:option value="Siddipet">Siddipet</form:option>
	 </form:select>		
  
</div></div><br>

<div class="bl"><div class="left">Bus Route</div><div class="right"><form:input path="busRoute" style="width: 170px;"/></div></div><br>
					
<div class="bl"><div class="left">Kilometers</div><div class="right"><form:input path="kilometers" style="width: 169px;"/></div></div><br>	

<div class="bl"><div class="left">Rate /Kilometers</div><div class="right"><form:input path="ratePerKilometers" style="width: 169px;"/></div></div><br>	
					
<div class="bl"><div class="left">Body Maker</div><div class="right"><form:input path="bodyMaker" style="width: 169px;" /></div></div><br>					
					
<div class="bl"><div class="left">Diesel /Day Liters</div><div class="right"><form:input path="dieselPerDayLiters" style="width: 169px;"/></div></div><br>	

<div class="bl"><div class="left">Finance</div><div class="right">
 <form:select  path="finance" style="width: 172px;">
 <form:option value="Select Bank"></form:option>
 	<form:option value="Bank Of Baroda">Bank Of Baroda</form:option>
 	<form:option value="Bank Of India">Bank Of India</form:option>
	 </form:select>
  </div></div><br>
  					
				

					<div class="bl">
						<div class="left"></div>
						<div class="right"></div>
					</div>
					<br>

					<div class="bl">
						<div class="navigation">
							<ul>
								<li>&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Submit" class="tpmsButton">&nbsp;&nbsp;&nbsp;&nbsp;
								</li>
								<li>&nbsp;&nbsp;<input type="reset" value="Reset" class="tpmsButton">
								<li>
							</ul>
						</div>
					</div>
				</form:form>
				<br> <input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />

			</div>

		</div>

<div class="bl">
			<div class="left"></div>
			<div class="right"></div>
		</div>
		<br> <br>

		<div class="bl">
			<div class="left"></div>
			<div class="right"></div>
		</div>
		<br> <br>
		<div class="bl">
			<div class="left"></div>
			<div class="right"></div>
		</div>
		<br><br>
		<div class="footer">
			<small>&copy; MRS </small>
		</div>

	</div>
</body>

</html>