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
<title>Insert title here</title>
</head>
<body>
	<div class="container">

			<h1>Se connecter</h1>
		
			<c:if test="${param.error != null}">
				<div class="alert alert-danger">erreur d'authentification</div>
			</c:if>
			<form id="connectForm" action="" method="post">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}">
				<div class="form-group">
					<label>mail</label> <input name="mail" class="form-control"
						required="required">
				</div>
				<div class="form-group">
					<label>mot de passe</label><input type="password" name="password"
						class="form-control" required="required">
				</div>
				<div class="form-group">
					<button class="btn btn-outline-success" type="submit">envoyer</button>
					<a href="${ctx}" class="btn btn-outline-warning">annuler</a>
				</div>
			</form>
		
		</div>
</body>
</html>