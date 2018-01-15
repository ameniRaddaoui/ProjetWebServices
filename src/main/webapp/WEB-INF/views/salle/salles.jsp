<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
		<div class="box">
            <div class="box-header text-center">
              <h3 class="box-title">Departements List</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body no-padding">
              <table class="table table-striped text-center">
                <tr>
                    <th>Nom</th>
					<th>Etage</th>
					<th>Capacité</th>
					<th>Action</th>
					<th></th>
                </tr>
				<c:forEach var="iSalle" items="${ salleList }">
					<tr>
						<td>${  iSalle.nom }</td>
						<td>${  iSalle.etage }</td>
						<td>${  iSalle.capacite }</td>
						<td><a href="createOrUpdateSalle?idSalle=${ iSalle.id }" class="btn btn-sm btn-success btn-outlined"><i
								class="fa fa-pencil"></i>Edit</a>
								<a href="delete?idSalle=${ iSalle.id }" class="btn btn-sm btn-danger btn-outlined"><i class="fa fa-remove"></i>Delete</a>
						</td>
					</tr>
				</c:forEach>
              </table>
            </div>
            <!-- /.box-body -->
          </div>
          
          <button class="btn btn-primary pull-right" type="submit" onclick="window.location='createOrUpdateSalle'">Add Enseignant</button>

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->


</body>
</html>
