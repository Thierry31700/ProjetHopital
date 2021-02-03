<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<c:if test="${pageContext.request.userPrincipal.name != null }">
			<jsp:include page="logout.jsp"></jsp:include>
		</c:if>
		<h1>Bienvenu</h1>
		<div>
			<a href="${ctx}/conge">Congés</a> 
			
			<a href="${ctx}/manager">Validation des conges</a>
			
			<a href="${ctx}/admin">Gestion</a>
		</div>
	</div>
</body>
</html>