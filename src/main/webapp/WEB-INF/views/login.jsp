<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta charset="utf-8">
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  
    <link media="all" type="text/css" rel="stylesheet" href="resources/assets/css/CSSLogin.css">

 
</head>
<body>

	
 <div class="login">
	<h1>Login</h1>
    <form method="post" action="spring_security_check">
    
       <tr>  
      <td colspan="2" style="color: red">${message}</td>  
  
     </tr>  
    	<input type="text" name="username" placeholder="username" required="required" />
        <input type="password" name="password" placeholder="password" required="required" />
        <button type="submit" class="btn btn-primary btn-block btn-large">Let me in.</button>
    </form>
   
   <a href="register" style="color:white;">Register</a>
  
</div>

</body>
</html>
