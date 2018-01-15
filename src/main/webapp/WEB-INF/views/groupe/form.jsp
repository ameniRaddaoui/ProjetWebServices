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
						<c:when test="${ not empty groupeInfo }">
							<div class="panel-heading text-center">
								<h3>Edit Groupe</h3>
							</div>
							<input type="hidden" name="idGroupe" value="${ groupeInfo.id }"></input>
						</c:when>
						<c:otherwise>
							<div class="panel-heading text-center">
								<h3>Add Groupe</h3>
							</div>
						</c:otherwise>
					</c:choose>
					<label>Libellé</label> 
					<input class="form-control" type="text" name="libelle" value="${ groupeInfo.libelle }" required></input>
					<label>Spécialité</label> 
					<input class="form-control" type="text" name="specialite" value="${ groupeInfo.specialite }" required></input> 
					<label>Niveau</label> 
					<input class="form-control" type="number" name="niveau" value="${ groupeInfo.niveau }" required></input>
					<hr></hr>
					<input type="submit" class="btn btn-primary"
						value="${ not empty groupeInfo ? 'Edit' : 'Add' }"
						style="text-align: center" />
				</form>
			</div>
			<!--/.Card content-->
		</div>
	</div>

</body>
</html>