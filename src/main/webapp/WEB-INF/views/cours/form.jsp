<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="${fontAwesomeCss}" rel="stylesheet" />
</head>
<body>
	<div id="exTab2" class="container">
		<div class="card">
			<!--Card content-->
			<div class="card-block">
				<form action="addoredit" method="POST">
					<!--Title-->
					<c:choose>
						<c:when test="${ not empty coursInfo }">
							<div class="panel-heading text-center">
								<h3>Edit Cours</h3>
							</div>
							<input type="hidden" name="idCour" value="${ coursInfo.id }"></input>
						</c:when>
						<c:otherwise>
							<div class="panel-heading text-center">
								<h3>Add Cours</h3>
							</div>
						</c:otherwise>
					</c:choose>
					<label>Enseignant</label>
					
					<select name="enseignant"
						class="form-control">
						<c:forEach var="enseignant" items="${ enseignants }">
							<c:choose>
								<c:when test="${enseignant.id eq courInfo.enseignant.id }">
									<option value="${ enseignant.id }" selected="selected">${ enseignant.nom }
										${ enseignant.prenom }</option>
								</c:when>
								<c:otherwise>
									<option value="${ enseignant.id }">${ enseignant.nom }
										${ enseignant.prenom }</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select> 
					
					<label>Groupe</label> <select name="groupe" class="form-control">
					
						<c:forEach var="groupe" items="${ groupes }">
							<c:choose>
								<c:when test="${groupe.id eq courInfo.groupe.id }">
									<option value="${ groupe.id }" selected="selected">${ groupe.libelle }</option>
								</c:when>
								<c:otherwise>
									<option value="${ groupe.id }">${ groupe.libelle }</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						
					</select>
					
					 <label>Salle</label> 
					 
					 <select name="salle" class="form-control">
						<c:forEach var="salle" items="${ salles }">
							<c:choose>
								<c:when test="${salle.id eq courInfo.salle.id }">
									<option value="${ salle.id }" selected="selected">${ salle.nom }</option>
								</c:when>
								<c:otherwise>
									<option value="${ salle.id }">${ salle.nom }</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select> 
					
					<label>Seance</label> 
					
					<select name="seance" class="form-control">
						<c:forEach var="seance" items="${ seances }">
							<c:choose>
								<c:when test="${seance.id eq courInfo.seance.id }">
									<option value="${ seance.id }" selected="selected">${ seance.libelle }</option>
								</c:when>
								<c:otherwise>
									<option value="${ seance.id }">${ seance.libelle }</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
					
					<hr></hr>
					<input type="submit" class="btn btn-primary"
						value="${ not empty coursInfo ? 'Edit' : 'Add' }"
						style="text-align: center" />
				</form>
			</div>
			<!--/.Card content-->
		</div>
	</div>

</body>
</html>