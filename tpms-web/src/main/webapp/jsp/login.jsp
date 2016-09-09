<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Login</title>
<meta charset="utf-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">


<link rel="Stylesheet" href="css/style.css">

<link href='http://fonts.googleapis.com/css?family=Niconne'	rel='stylesheet' type='text/css'>

</head>

<body>

	<div class="wrapper">

		<div class="loginheader">
			<div class="heading">For Hire Buses</div>
		
		</div>

		<div class="main">

			
				<div class="logincontent">
					
					
					<c:if test="${not empty error}">
						<div class="error">${error}</div>
					</c:if>
					<c:if test="${not empty msg}">
						<div class="msg">${msg}</div>
					</c:if>
					
					<form name="login" method="POST" action="<c:url value='/login' />">
						<div class="bl">
							<div class="left">Username</div>
							<div class="right">
								<input type="text" name="username">
							</div>
						</div>
						<br>

						<div class="bl">
							<div class="left">Password</div>
							<div class="right">
								<input type="password" name="password">
							</div>
						</div>
						<br>
						<br>

						<div class="bl"><div class="navigation">
<ul>
<li>&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Submit" class="tpmsButton">&nbsp;&nbsp;&nbsp;&nbsp;</li>
<li>&nbsp;&nbsp;<input type="reset" value="Reset" class="tpmsButton"></a><li>
</ul>
</div>
</div>

						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
				</div>
			
		</div>


		<div class="bl"><div class="left"></div><div class="right"></div></div><br><br>
		
		<div class="loginfooter"><strong><small>&copy; MRS </small></strong>
		</div>

	</div>
</body>

</html>