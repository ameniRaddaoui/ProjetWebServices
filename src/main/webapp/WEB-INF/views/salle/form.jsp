<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 </head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

 
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
		<form role="form" action="addoredit" method="POST">
		 <div class="box box-warning">
            <div class="box-header with-border text-center">
            	<c:choose>
					<c:when test="${ not empty salleInfo}">
						<h3 class="box-title">Edit Salle</h3>
						<input type="hidden" name="idSalle" value="${ salleInfo.id }"></input>
					</c:when>
					<c:otherwise>
						<h3 class="box-title">Add Salle</h3>
					</c:otherwise>
				</c:choose>
            </div>
            <div class="box-body">
              
                <div class="form-group">
                  <label>Name</label>
                  <input type="text" class="form-control" placeholder="Enter Name ..." name="nom" value="${ salleInfo.nom }" required>
                   <label>Etage</label> 
					<input class="form-control" type="number" name="etage" value="${ salleInfo.etage }" required></input> 
					<label>Capacité</label> 
					<input class="form-control" type="number" name="capacite" value="${ salleInfo.capacite }" required></input>
                </div>
				<div class="box-footer">
	              <input class="btn btn-primary pull-right" type="submit" value="${ not empty salleInfo ? 'Edit' : 'Add' }"/>
	       		 </div>
            </div>
            <!-- /.box-body -->
           
          </div>
		 </form>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <footer class="main-footer">
    <div class="pull-right hidden-xs">
      <b>Version</b> 2.4.0
    </div>
    <strong>Copyright &copy; 2017-2018 <a href="https://adminlte.io">Almsaeed Studio</a>.</strong> All rights
    reserved.
  </footer>

  <!-- Control Sidebar -->
  
</body>
</html>
