
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Employes List</title>
  <spring:url value="/resources/assets/libs/bootstrap/css/bootstrap.min.css" var="bootstrapCss" />
  <spring:url value="/resources/assets/libs/font-awesome/css/font-awesome.min.css" var="faCss" />
  <spring:url value="/resources/assets/libs/Ionicons/css/ionicons.min.css" var="ioniconsCss" />
  <spring:url value="/resources/assets/css/AdminLTE.min.css" var="adminLteCss" />
  <spring:url value="/resources/assets/css/skin-blue.min.css" var="skinBlueCss" />
  
 
</head>
<body>



    	<form role="form" action="addoredit" method="POST">
		 <div >
            <div >
            	<c:choose>
					<c:when test="${ not empty employeInfo}">
						<h3 class="box-title">Update Employe</h3>
						<input type="hidden" name="idEmploye" value="${ employeInfo.id }"/>
					</c:when>
					<c:otherwise>
						<h3 class="box-title">Add Employe</h3>
					</c:otherwise>
				</c:choose>
            </div>
            <div class="box-body">
              
                <div class="form-group">
                   <label>First Name</label>
                  <input type="text" class="form-control" placeholder=" First Name ..." name="firstName" value="${ employeInfo.firstName }" required/>
                  <label>Last Name</label>
                  <input type="text" class="form-control" placeholder=" Last Name ..." name="lastName" value="${ employeInfo.lastName }" required/>
                
                  <label>Adresse</label>
                  <input type="text" class="form-control" placeholder=" adresse ..." name="adresse" value="${ employeInfo.adresse }" required/>
                  <label>Email</label>
                  <input type="text" class="form-control" placeholder=" email ..." name="email" value="${ employeInfo.email }" required/>
                  <label>Telephone</label>
                  <input type="text" class="form-control" placeholder=" telephone ..." name="telephone" value="${ employeInfo.telephone }" required/>
                  <label>Cin</label>
                  <input type="text" class="form-control" placeholder=" cin ..." name="cin" value="${ employeInfo.cin }" required/>
                
                  <label>login</label>
                  <input type="text" class="form-control" placeholder=" login ..." name="login" value="${ employeInfo.login }" required/>
                  <label>password</label>
                  <input type="text" class="form-control" placeholder=" Password ..." name="password" value="${ employeInfo.password }" required/>
                  </br>
                  <label>Sexe</label>
                   <select name="sexe" value="${ employeInfo.sexe }" required>

							<option value="1">Femme</option>
							<option value="2">Homme</option>

					</select>
				</br>
                  </br>
                  <label>role</label>
                  <select name="role" value="${ employeInfo.role }">

							<option value="ROLE_ADMIN">ROLE_ADMIN</option>
							<option value="ROLE_USER">ROLE_USER</option>

					</select>
					</br>
                  </br>
                  <label>departement</label>
					<select name="departement_id">
							<c:forEach var="departement" items="${departementList}">
								<option  value="${departement.id}"> ${departement.nom_dep} </option>
							</c:forEach>			
					</select>
                  
                  
                </div>
				<div class="box-footer">
	              <input class="btn btn-primary pull-right" type="submit" value="${ not empty employeInfo ? 'Edit' : 'Add' }"/>
	       		 </div>
            </div>
            <!-- /.box-body -->
           
          </div>
		 </form>

</body>
</html>

