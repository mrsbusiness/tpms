<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<title></title>
</head>
<link rel="stylesheet" href="login.css" title="Default" type="text/css" media="screen" charset="utf-8">
<body>
<div class="wrapper">


<div class="header">
<div class="heading"> 
<h1>&nbsp;MARS</h1>
</div>
</div>


<div class="nav">
<div class="menu"> 

</div>
</div>

<div class="main">

<center>
<div class="content">

<form name="login" method="post" action="">
 
<div class="a"> 
<div class="left">Username</div><div class="right"><INPUT type="text" name="uid"></div><br>
 
<br><div class="left">Password</div><div class="right"><INPUT type="password" name="password"></div>
 <br><br>
<center><div class="left"><INPUT class="button" type="submit" name="submit" value="Submit"></div><div class="right"><INPUT class="button" type="reset" name="reset" value="Reset"></div></center>
 </div>
 
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
 </form>
 
</div>

</center>
</div>

<div class="footer">email : &nbsp; forhirebusesproject@gmail.com </div>

</div>
</body>
</html>
