<%@page import="tn.iit.projet.entities.Groupe"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
<spring:url value="/resources/css/font-awesome.min.css"
	var="fontAwesomeCss" />

<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${fontAwesomeCss}" rel="stylesheet" />
<title>List Groupes</title>
</head>
<body class="container">
	<br>
	<div class="panel panel-default">

		<div class="panel-heading text-center">
			<h3>Cours List</h3>
		</div>

		<table style="margin: auto; margin-top: 50px;"
			class="table v-middletable-condensed">
			<tr>
				<th>Enseignant</th>
				<th>Groupe</th>
				<th>Salle</th>
				<th>Séance</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach var="icours" items="${ coursList }">
				<tr>
					<td><input class="form-control" type="text" disabled
						value="${ icours.enseignant.nom } ${ icours.enseignant.prenom }"></input></td>
					<td><input class="form-control" type="text" disabled
						value="${ icours.groupe.libelle}"></input></td>
					<td><input class="form-control" type="text" disabled
						value="${ icours.salle.nom }"></input></td>
					<td><input class="form-control" type="text" disabled
						value="${ icours.seance.libelle }"></input></td>
					<td><a href="createOrUpdateCour?idCour=${ icours.id }"><i
								class="fa fa-pencil"></i>Edit</a> &nbsp;&nbsp; 
						<a href="delete?idCour=${ icours.id }"><i class="fa fa-remove"></i>Delete</a>
						</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div>
		<button type="submit" class="btn btn-lg btn-success pull-right"
			onclick="window.location='createOrUpdateCour'">
			<span><i class="fa fa-plus">ADD</i></span>
		</button>
	</div>
</body>
</html>