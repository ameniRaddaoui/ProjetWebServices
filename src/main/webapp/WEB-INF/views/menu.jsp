<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<!-- Left side column. contains the sidebar -->
		<aside class="main-sidebar"> <!-- sidebar: style can be found in sidebar.less -->
		<br>

		<ul class="sidebar-menu" data-widget="tree">
			<li class="header">MENU</li>
			
		
			<security:authorize access="isAuthenticated() && hasRole('ROLE_ADMIN')">>
				<li ><a href="${pageContext.request.contextPath}/admin/cours/list#"> <i class="fa fa-th"></i>
						<span>cours</span> <span class="pull-right-container"> <span class="label label-primary pull-right">${ coursList.size() }</span>
					</span></a></li>
				
			<li><a href="${pageContext.request.contextPath}/admin/enseignant/list#"> <i class="fa fa-th"></i>
					<span>Enseignant</span> <span class="pull-right-container"> <span
						class="label label-primary pull-right">${ enseignantList.size() }</span>
				</span></a></li>
			
			<li ><a href="${pageContext.request.contextPath}/admin/groupe/list#"> <i class="fa fa-th"></i>
					<span>Groupe</span> <span class="pull-right-container"> <span
						class="label label-primary pull-right">${ groupeList.size() }</span>
				</span></a></li>
			
			
			<li><a href="${pageContext.request.contextPath}/admin/seance/list#"> <i class="fa fa-th"></i>
					<span>Seance</span> <span class="pull-right-container"> <span
						class="label label-primary pull-right">${ seanceList.size() }</span>
				</span></a></li>
			</security:authorize>
			
		</ul>
		 </aside>
</head>
</html>