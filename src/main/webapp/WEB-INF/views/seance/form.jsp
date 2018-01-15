
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Seance List</title>
  
  
 
</head>
<body>



    	<form role="form" action="addoredit" method="POST">
		 <div >
            <div >
            	<c:choose>
					<c:when test="${ not empty seanceInfo}">
						<h3 class="box-title">Update </h3>
						<input type="hidden" name="id" value="${ seanceInfo.id }"/>
					</c:when>
					<c:otherwise>
						<h3 class="box-title">Ajouter</h3>
					</c:otherwise>
				</c:choose>
            </div>
            <div class="box-body">
              
                <div class="form-group">
                   <label>libelle</label>
                  <input type="text" class="form-control" placeholder=" libelle..." name="libelleSeance" value="${ seanceInfo.libelleSeance }" required/>
                  <label>heure Debut</label>
                  <input type="text" class="form-control" placeholder=" heure Debut ..." name="heureDebut" value="${ seanceInfo.heureDebut }" required/>
                
                  <label>heure Fin</label>
                  <input type="text" class="form-control" placeholder=" heure Fin ..." name="heureFin" value="${ seanceInfo.heureFin }" required/>
                  <label>date</label>
                  <input type="date" class="form-control" placeholder=" date ..." name="date" value="${ seanceInfo.date }" required/>
                  
                  
                </div>
				<div class="box-footer">
	              <input class="btn btn-primary pull-right" type="submit" value="${ not empty seanceInfo ? 'Edit' : 'Add' }"/>
	       		 </div>
            </div>
            <!-- /.box-body -->
           
          </div>
		 </form>

</body>
</html>

