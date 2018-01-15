<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

  <title>Seance List</title>
  
  
</head>
<body >


               <h3 class="box-title">Seances List</h3>
           <!-- /.box-header -->
            <div class="box-body no-padding">
              <table class="table table-striped text-center">
                <tr>
                   <th>libelle</th>
			       <th>heure Debut </th>
			       <th>heure Fin</th>
			       <th>date</th>
					<th>Actions</th>
                </tr>
                 <c:forEach var="seance" items="${ seanceList }">
					<tr>
						
						<td><c:out value="${seance.libelleSeance}" /></td>
				        <td><c:out value="${seance.heureDebut}" /></td>
				        <td><c:out value="${seance.heureFin}" /></td>
				        <td><c:out value="${seance.date}" /></td>
				       


						
						<td>
						<a href="createOrUpdateSeance?id=${ seance.id }" > modifier
			               
			              </a>
			              <a href="delete?id=${ seance.id }" > supprimer
			              
			              </a>
					</tr>
				</c:forEach>
              </table>
            </div>
            
             
            <!-- /.box-body -->
          </div>
          
         <button class="btn btn-primary pull-right" type="submit" onclick="window.location='createOrUpdateSeance'">Ajouter</button>

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

 
 </body>
</html>
