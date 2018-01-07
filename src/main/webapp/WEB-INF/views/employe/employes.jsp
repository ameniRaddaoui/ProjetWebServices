<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

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
<body >


               <h3 class="box-title">Employes List</h3>
           <!-- /.box-header -->
            <div class="box-body no-padding">
              <table class="table table-striped text-center">
                <tr>
                   <th>First Name</th>
			       <th>Last Name</th>
			       <th>Sexe</th>
			       <th>Adresse</th>
			       <th>Email</th>
			       <th>Télephone</th>
			       <th>CIN</th>
			        <th>ROLE</th>
			        <th>Département</th>
					<th>Actions</th>
                </tr>
                 <c:forEach var="employe" items="${ employeList }">
					<tr>
						
						<td><c:out value="${employe.firstName}" /></td>
				        <td><c:out value="${employe.lastName}" /></td>
				        <td><c:out value="${employe.sexe}" /></td>
				        <td><c:out value="${employe.adresse}" /></td>
				        <td><c:out value="${employe.email}" /></td>
				        <td><c:out value="${employe.telephone}" /></td>
				        <td><c:out value="${employe.cin}" /></td>
				        <td><c:out value="${employe.role}" /></td>
                        <td><c:out value="${employe.departement.nom_dep}" /></td>


						
						<td>
						<a href="createOrUpdateEmploye?idEmploye=${ employe.id }" > créer
			               
			              </a>
			              <a href="delete?idEmploye=${ employe.id }" > supprimer
			              
			              </a>
					</tr>
				</c:forEach>
              </table>
            </div>
            
             
            <!-- /.box-body -->
          </div>
          
         <button class="btn btn-primary pull-right" type="submit" onclick="window.location='createOrUpdateEmploye'">Add New Employe</button>

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

 
 </body>
</html>
