<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Gestion Salarie</title>
</head>
<body>
	<a id="btnDisconnect" href="${ctx}/spring/accueil"><input type="button"
		class="btn btn-danger" value="Se deconnecter"></a>


	<h1>Mes demandes</h1>

	<!-- Button trigger modal -->
	<a type="button" class="btn btn-primary"
		href="${ctx}/spring/conge/add">Créer une demande de congé</a>

		<!-- Modal -->

	<div id="content">
	
		<div class="tab-content" id="pills-tabContent">
			<div class="tab-pane fade show active" id="pills-emp" role="tabpanel"
				aria-labelledby="pills-emp-tab">
	<table class="table table-striped text-center">
		<thead>
			<tr>
				<th class="table-dark">Type de demande</th>
				<th class="table-dark">Date de début</th>
				<th class="table-dark">Date de fin</th>
				<th class="table-dark">Nombre de jour</th>
				<th class="table-dark">Motif</th>
				<th class="table-dark">Service</th>
				<th class="table-dark">Etat</th>
				<th class="table-dark"></th>
			</tr>
		</thead>
		<tbody id="listconge">
			<c:forEach items="${conges}" var="conges">
				<tr>
					<td class="table-active">${conges.typeConge.libelle}</td>
					<td class="table-active">${conges.dateDebut}</td>
					<td class="table-active">${conges.dateFin}</td>
					<td class="table-active">${conges.nbJour}</td>
					<td class="table-active">${conges.motif}</td>
					<td class="table-active">${conges.employe.service.libelle}</td>
					<c:choose>
					<c:when test="${conges.etat == 'VALIDE'}">
					<td class="table-active" style="color:green">${conges.etat}</td>
					</c:when>
					<c:when test="${conges.etat == 'REFUSE'}">
					<td class="table-active" style="color:red">${conges.etat}</td>
					</c:when>
					<c:when test="${conges.etat == 'ATTENTE'}">
					<td class="table-active" style="color:black">${conges.etat}</td>
					</c:when>
					</c:choose>
					<td class="table-active">
					<c:if test="${conges.etat == 'ATTENTE'}">
					
					<td><a href="${ctx}/spring/conge/delete?id=${conge.id}"
						class="btn btn-outline-danger">supprimer</a></td>
						
<!-- 						<form class="formReponse" name="formReponse" -->
<!-- 								action="employe" method="post"> -->
<%-- 								<input type="hidden" name="${_csrf.parameterName}" --%>
<%-- 					value="${_csrf.token}"> --%>
<%-- 								<input type="hidden" value="${conges.id}" name="id_conge"> --%>
<!-- 								<input type="submit" id="btnDelete" name="btnAnnuler" class="btn btn-warning" -->
<!-- 									value="Annuler"> -->
<!-- 							</form> -->
					</c:if></td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
	</div>
	</div>
	</div>

</body>
<script>
	//$('#myModal').on('shown.bs.modal', function () {$('#myInput').trigger('focus')})

	function dateFinMin() {
		dateFin.value = dateDebut.value;
		dateFin.min = dateDebut.value;
	}
	
	//popup
	
	$( document ).ready(function() {
  $('.trigger').click(function() {
     $('.modal-wrapper').toggleClass('open');
    $('.modal-wrapper').toggleClass('blur');
     return false;
  });
});
</script>

</html>
