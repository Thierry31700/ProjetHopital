<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="modal-wrapper" role="document">
		<div class="modalCreer">
			<div class="head">
				<a class="btn-close trigger" href="javascript:;"></a>
				<h5 class="modal-title" id="popupAjouterLabel">Créer une
					demande de congé</h5>

			</div>
			<form:form action="save" method="post" modelAttribute="conge">
			<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}">
				<div class="modal-body">
					<form:label  path="dateDemande"  for="date">Date de la demande :</form:label> ${aujourdhui}<br>
					
					<form:label path="dateDebut" for="dateDebut">Date de début :</form:label> 
					<form:input path="dateDebut" name="dateDebut" type="date" value="${today}" 
						min="${today}" onchange="dateFinMin()"/><br> 
						
						
						<form:label path="dateFin" for="dateFin">Date de fin :</form:label> 
						<form:input path="dateFin" 
						name="dateFin" type="date" value="${today}" min="${today}"/><br>
						
					<form:label path="typeConge" for="type">Types de congé : </form:label> 
					<form:select path="typeConge"  name="type">
						<form:option value="" selected="selected">Choisir un type de congé</form:option>
						<form:option value="CP">Congés payés</form:option>
						<form:option value="CSS">Congés sans solde</form:option>
						<form:option value="CA">Congé autorisée</form:option>
						<form:option value="CJ">Congé justifiée</form:option>
					</form:select><br> 
					
					<form:label path="motif" for="motif">Motif de la demande</form:label>
					<form:textarea path="motif" class="form-control" name="motif" id="motif" rows="3"
						placeholder="Entrez un motif"></form:textarea>
				</div>
				<div class="modal-footer">
					<a type="button" class="btn trigger" href="${ctx}/spring/conge"
						data-dismiss="modal">Annuler</a> 
					<input type="submit"
						class="btn btn-primary" id="btnSave" name="btnAjouter"
						value="Ajouter">
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>