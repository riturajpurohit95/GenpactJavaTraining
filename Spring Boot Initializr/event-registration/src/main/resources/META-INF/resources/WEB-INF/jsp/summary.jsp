<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Summary</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css"/>
</head>
<body>

	
	
	<div class="container">
		<h2 style="text-align: center">User details</h2>
	
		<p>Name:<c:out value="${user.name}" /></p>
		<p>Email:<c:out value="${user.email}" /></p>
		<p>Password length :<c:out value="${fn:length(user.password)}" />characters</p>
		<p>City:<c:out value="${user.city}" /></p>
		<p>Gender:<c:out value="${user.gender}" /></p>
		<h3>Selected technologies: </h3>
		<c:choose>
			<c:when test="${not empty user.technologies}">
				<ul>
					<c:forEach var="tech" items="${user.technologies}">
						<li><c:out value="${tech}" /></li>
					</c:forEach>
				</ul>
			</c:when>
			<c:otherwise>
				<p class="sub-heading">No technologies selected.</p>
			</c:otherwise>
		</c:choose>
		<h3>Selected sessions: </h3>
		<c:choose>
			<c:when test="${not empty user.sessions}">
				<ul class="list">
					<c:forEach var="session" items="${user.sessions}">
						<li><c:out value="${session}" /></li>
					</c:forEach>
				</ul>
			</c:when>
			<c:otherwise>
				<p class="no-data">No session selected.</p>
			</c:otherwise>
		</c:choose>
		<p>Subscribed to newsletter<c:out value="${user.newsletter ? 'Yes' : 'No'}" /></p>
		<p>Payment :<c:out value="${user.payment}" /></p>
		<p>Comments :<c:out value="${user.comments}" /></p>
		
		<a class="summary-button" href="${pageContext.request.contextPath}/register">Submit another form</a>
	</div>
</body>
</html>