<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
<spring:url value="/resources/css/font-awesome.min.css"
	var="fontAwesomeCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
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
						<c:when test="${ not empty enseignantInfo }">
							<div class="panel-heading text-center">
								<h3>Edit Enseignant</h3>
							</div>
							<input type="hidden" name="idEnseignant" value="${ enseignantInfo.id }"></input>
						</c:when>
						<c:otherwise>
							<div class="panel-heading text-center">
								<h3>Add Enseignant</h3>
							</div>
						</c:otherwise>
					</c:choose>
					<label>Nom</label> 
					<input class="form-control" type="text" name="nom" value="${ enseignantInfo.nom }" required></input>
					<label>Prénom</label> 
					<input class="form-control" type="text" name="prenom" value="${ enseignantInfo.prenom }" required></input> 
					<label>Téléphone</label> 
					<input class="form-control" type="number" name="tel" value="${ enseignantInfo.tel }" required></input>
					<label>Adresse</label> 
					<input class="form-control" type="text" name="adresse" value="${ enseignantInfo.adresse }" required></input> 
					<label>Grade</label> 
					<input class="form-control" type="text" name="grade" value="${ enseignantInfo.grade }" required></input>
					<label>E-mail</label> 
					<input class="form-control" type="email" name="email" value="${ enseignantInfo.email }" required></input> 
					<hr></hr>
					<input type="submit" class="btn btn-primary"
						value="${ not empty enseignantInfo ? 'Edit' : 'Add' }"
						style="text-align: center" />
				</form>
			</div>
			<!--/.Card content-->
		</div>
	</div>

</body>
</html>