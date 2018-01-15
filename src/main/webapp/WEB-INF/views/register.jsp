
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">

<link media="all" type="text/css" rel="stylesheet"
	href="resources/assets/css/CSSLogin.css">

<title>Registration</title>
</head>
<body>
<body>
<div class="login">
<h1>Register</h1>

	<form id="regForm" modelAttribute="user" action="registerProcess"
		method="post">
		
		        <input type="hidden" name="role" value="ROLE_USER" id="role"/>
			
			
				<input placeholder="First Name" path="firstName" name="nom" id="nom" required/>
				<input placeholder="Last Name" path="LastName" name="prenom" id="prenom" required/>
				
				<label path="sexe" style="color: white;">Sexe</label>
				<select name="type" id="type" path="sexe" required>

						<option value="Femme">Femme</option>
						<option value="Homme">Homme</option>

				</select>
				
				
				<input placeholder="email" path="email" name="email" id="email" required />
			
				
			
				<input placeholder="Login" path="login" name="login" id="login" required />
			
				<input  placeholder="password" type="password" path="password" name="password" id="password"
						required />
			

			
				<button type="submit" class="btn btn-primary btn-block btn-large" id="register" name="register">Register</button>
			
			
	
	</form>
</div>


</body>
</html>
