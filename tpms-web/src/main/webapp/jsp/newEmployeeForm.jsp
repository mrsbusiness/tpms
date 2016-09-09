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
<h3>Employee From</h3>
<c:url var="url" value="/admin/employee/create" /> 
<form:form action="${url}" commandName="employee">
 

<div class="bl"><div class="left">First Name</div><div class="right"><form:input path="firstName"/></div></div><br>
<div class="bl"><div class="left">Middle Name</div><div class="right"><form:input path="middleName"/></div></div><br>
<div class="bl"><div class="left">Last Name</div><div class="right"><form:input path="lastName"/></div></div><br>
<div class="bl"><div class="left">&nbsp;</div><div class="right"><form:radiobutton  path="gender" value="male" />&nbsp;&nbsp;Male&nbsp;<form:radiobutton  path="gender" value="female"/>&nbsp;&nbsp;Female&nbsp;</div></div><br>

<div class="bl"><div class="left">Date of Birth </div><div class="right"><form:input type="date" path="dob" style="width: 167px;"/></div></div><br>
 
<div class="bl"><div class="left">Martial Status</div><div class="right">
<form:radiobutton path="martialStatus" value="Single" />&nbsp;&nbsp;Single&nbsp;<form:radiobutton  path="martialStatus" value="Married"/>&nbsp;&nbsp;Married&nbsp;</div></div><br>

<div class="bl"><div class="left">Education</div><div class="right"><form:input path="education"/></div></div><br>

<div class="bl"><div class="left">Experience</div><div class="right"><form:input path="experience" maxlength="2" size="8"/><form:input path="experience"  value="months" maxlength="2" size="8"/></div></div><br>
	
<div class="bl"><div class="left">Work role</div><div class="right">
 <form:select  path="workRole" style="width: 172px;">
 <form:option value="Select Role"></form:option>
 	<form:option value="Driver">Driver</form:option>
 	<form:option value="Supervisor">Supervisor</form:option>
	<form:option value="HR">HR</form:option>
	<form:option value="Service Staff">Service Staff</form:option>
	<form:option value="Accountant">Accountant</form:option>	
  </form:select>
  
</div></div><br>

<div class="bl"><div class="left">Joining Date</div><div class="right"><form:input path="joiningDate" type="date" style="width: 167px;"/></div></div><br>

<div class="bl"><div class="left">Email</div><div class="right"><form:input path="eMail" style="width: 167px;"/></div></div><br>
<div class="bl"><div class="left">Pan Card Number</div><div class="right"><form:input path="panNumber" style="width: 167px;"/></div></div><br>
<div class="bl"><div class="left">Aadhar Card Number</div><div class="right"><form:input path="adarCardNumber" style="width: 167px;"/></div></div><br>

<div class="bl"><div class="left">License Number</div><div class="right"><form:input path="licenseNumber" style="width: 167px;"/></div></div><br>
<div class="bl"><div class="left">badge Number</div><div class="right"><form:input path="badgeNumber" style="width: 167px;"/></div></div><br>

<div class="bl"><div class="left">Home Phone</div><div class="right"><form:input path="homePhoneNumber" maxlength="10" style="width: 167px;"/></div></div><br>
<div class="bl"><div class="left">Cell Phone</div><div class="right"><form:input path="cellPhoneNumber" maxlength="10" style="width: 167px;"/></div></div><br>

<div class="bl"><div class="left">Current Address</div><div class="right"><textarea style="resize:none" name="currentAddress" cols="22" rows="2" maxlength="75"></textarea></div></div><br>
<div class="bl"><div class="left">Permanent Address</div><div class="right"><textarea style="resize:none" name="permAddress" cols="22" rows="2" maxlength="75"></textarea></div></div><br>

<div class="bl"><div class="left"></div><div class="right"></div></div><br>

<div class="bl"><div class="navigation">
<ul>
<li>&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Submit" class="tpmsButton">&nbsp;&nbsp;&nbsp;&nbsp;</li>
<li>&nbsp;&nbsp;<input type="reset" value="Reset" class="tpmsButton"><li>
</ul>
</div>
</div>

 </form:form>
 </div>

 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />


 </div>


<div class="bl"><div class="left"></div><div class="right"></div></div><br>
<div class="bl"><div class="left"></div><div class="right"></div></div><br>
<div class="bl"><div class="left"></div><div class="right"></div></div><br>
<br>
<div class="footer">
<small>&copy; MRS </small>
</div>

</div>
</body>

</html>