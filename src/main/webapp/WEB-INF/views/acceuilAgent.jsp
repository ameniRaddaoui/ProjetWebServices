<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Acceuil Agent</title>
</head>
<body>
	<form action="filtrer" method="POST">
		<div class="row">
			<div class="col-md-3">
				<input type="date" name="date" class="form-control">
			</div>
			<div class="col-md-4">
				<select name="seance" class="form-control">
					<c:forEach var="seance" items="${ seances }">
						<option value="${ seance.id }">${ seance.libelle }</option>
					</c:forEach>
				</select> 
			</div>
			<div class="col-md-4">
				<button type="submit" class="btn btn-info">ok
					<span class="glyphicon glyphicon-ok"></span>
				</button>
			</div>
		</div>
	</form>
	
	<c:if test="${ not empty cours }">
		<form action="envoie" method="post">
		<table style="margin: auto; margin-top: 50px;" class="table v-middletable-condensed">
			<tr>
				<th>Enseignant</th>
				<th>Groupe</th>
				<th>Salle</th>
				<th></th>
			<tr>
			<c:forEach var="cours" items="${ cours }">
				<tr>
					<td>${ cours.enseignant.nom } ${ cours.enseignant.prenom }</td>
					<td>${ cours.groupe.libelle }</td>
					<td>${ cours.salle.nom }</td>
					<td><input value="${ cours.id }" type="checkbox" name="cours"></td>
				</tr>
			</c:forEach>
		</table>
		<input type="hidden" name="date" value="${ date }" />
		<input type="hidden" name="seance" value="${ seance }" />
		
		<button type="submit" class="form-control btn btn-success">envoyer
			<span class="glyphicon glyphicon-ok"></span>
		</button>
		</form>
	</c:if>
</body>
</html>