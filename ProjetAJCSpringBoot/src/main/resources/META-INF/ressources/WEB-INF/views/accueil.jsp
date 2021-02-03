<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<c:set var="ctx" value="${pageContext.servletContext.contextPath}" />
<meta charset="utf-8">
<link rel="stylesheet" href="${ctx}/css/mystyle.css">
<title>Accueil</title>
</head>
<body>
<div class="container">
		<c:if test="${param.error != null}">
			<div class="alert alert-danger">erreur d'authentification</div>
		</c:if>
		<form action="" method="post">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}">
			<div class="form-group">
				<label>mail</label> <input name="mail"
					class="form-control" required="required">
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