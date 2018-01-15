<%@page import="tn.iit.projet.entities.Enseignant"%>
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
<title>List Enseignants</title>
</head>
<body class="container">
	<br>
	<div class="panel panel-default">

		<div class="panel-heading text-center">
			<h3>Enseignants list</h3>
		</div>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nom</th>
					<th>Prénom</th>
					<th>Téléphone</th>
					<th>Adresse</th>
					<th>Grade</th>
					<th>E-mail</th>
					<th>Action</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="iEnseignant" items="${ enseignantList }">
					<tr>
						<td>${  iEnseignant.nom }</td>
						<td>${  iEnseignant.prenom }</td>
						<td>${  iEnseignant.tel }</td>
						<td>${  iEnseignant.adresse }</td>
						<td>${  iEnseignant.grade }</td>
						<td>${  iEnseignant.email }</td>
						<td><a href="createOrUpdateEnseignant?idEnseignant=${ iEnseignant.id }"><i
								class="fa fa-pencil"></i>Edit</a> &nbsp;&nbsp; <a
							href="delete?idEnseignant=${ iEnseignant.id }"><i class="fa fa-remove"></i>Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
		<button type="submit" class="btn btn-lg btn-success pull-right"
			onclick="window.location='createOrUpdateEnseignant'">
			<span><i class="fa fa-plus">ADD</i></span>
		</button>
	</div>
</body>
</html>