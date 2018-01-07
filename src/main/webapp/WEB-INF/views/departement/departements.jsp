<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Departements List</title>
  
 </head>
 <body>
   
		
            <div >
              <h3 class="box-title">Departements List</h3>
            </div>
            <!-- /.box-header -->
            <div >
              <table class="table table-striped text-center">
                <tr>
                    <th>Name</th>
					<th>Actions</th>
                </tr>
                 <c:forEach var="iDepartement" items="${ departementList }">
					<tr>
						<td>${ iDepartement.nom_dep }</td>
						<td>
						<a href="createOrUpdateDepartement?idDepartement=${ iDepartement.id }" class="btn btn-sm btn-success btn-outlined">
			                <i class="fa fa-edit"></i> 
			              </a>
			              <a href="delete?idDepartement=${ iDepartement.id }" class="btn btn-sm btn-danger btn-outlined">
			                <i class="fa fa-remove"></i> 
			              </a>
					</tr>
				</c:forEach>
              </table>
            </div>
            <!-- /.box-body -->
          </div>
          
          <button class="btn btn-primary pull-right" type="submit" onclick="window.location='createOrUpdateDepartement'">Add Departement</button>

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  
</body>
</html>
