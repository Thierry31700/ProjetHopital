<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<jsp:include page="../logout.jsp"></jsp:include>
		<h1>edition employe</h1>
		<form:form action="save" method="post" modelAttribute="employe">
			<div class="form-group">
				<form:label path="numero">id:</form:label>
				<form:input path="numero" cssClass="form-control" readonly="true" />
			</div>
			<div class="form-group">
				<form:label path="nom">nom:</form:label>
				<form:input path="nom" cssClass="form-control" />
				<form:errors path="nom" element="div" cssClass="alert alert-danger"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="poste">poste:</form:label>
				<form:input path="poste" cssClass="form-control" />
				<form:errors path="poste" element="div"
					cssClass="alert alert-danger"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="embauche">embauche:</form:label>
				<form:input type="date" path="embauche" cssClass="form-control" />
				<form:errors path="embauche" element="div"
					cssClass="alert alert-danger"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="salaire">salaire:</form:label>
				<form:input type="number" path="salaire" cssClass="form-control" />
				<form:errors path="salaire" element="div"
					cssClass="alert alert-danger"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="adresse.numero">numero de l'adresse:</form:label>
				<form:input type="number" path="adresse.numero"
					cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="adresse.voie">voie:</form:label>
				<form:input path="adresse.voie" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="adresse.ville">ville:</form:label>
				<form:input path="adresse.ville" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="ordinateur">ordinateur affecté:</form:label>
				<form:select path="ordinateur.id" cssClass="form-control">
					<form:option value="">pas d'ordinateur</form:option>
					<form:options items="${ordinateurs}" itemLabel="infos"
						itemValue="id" />
				</form:select>
			</div>
			<div class="form-group">
				<form:label path="manager">manager:</form:label>
				<form:select path="manager.numero" cssClass="form-control">
					<form:option value="">pas de manager</form:option>
					<form:options items="${managers}" itemValue="numero"
						itemLabel="infos" />
				</form:select>
			</div>
			<div class="form-group">
				<form:label path="departement">departement:</form:label>
				<form:select path="departement.numero" cssClass="form-control">
					<form:options items="${departements}" itemValue="numero"
						itemLabel="nom" />
				</form:select>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-outline-success">enregistrer</button>
				<a href="../employe" class="btn btn-outline-warning">annuler</a>
			</div>
		</form:form>
	</div>
</body>
</html>