<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Result</title>
</head>
<body>
	<h2 style="text-align: center">Submission Result</h2>
	<div>
		<p>Name:<c:out value="${user.name}" /></p>
		<p>Email:<c:out value="${user.email}" /></p>
		<p>Age:<c:out value="${user.age}" /></p>
		<p>Password length :<c:out value="${fn:length(user.password)}" />characters</p>
		<p>About :<c:out value="${user.about}" /></p>
		<p>Subscribed to newsletter<c:out value="${user.subscribe ? 'Yes' : 'No'}" /></p>
		<h3>Selected interests</h3>
		<c:choose>
			<c:when test="${not empty user.interests}">
				<ul>
					<c:forEach var="it" items="${user.interests}">
						<li><c:out value="${it}" /></li>
					</c:forEach>
				</ul>
			</c:when>
			<c:otherwise>
				<p>No interest</p>
			</c:otherwise>
		</c:choose>
		<p>Gender :<c:out value="${user.gender}" /></p>
		<p>Country :<c:out value="${user.country}" /></p>
		<h3>Languages known: </h3>
		<c:choose>
			<c:when test="${not empty user.languages}">
				<ul>
					<c:forEach var="lang" items="${user.languages}">
						<li><c:out value="${lang}" /></li>
					</c:forEach>
				</ul>
			</c:when>
			<c:otherwise>
				<p>No language selected.</p>
			</c:otherwise>
		</c:choose>
		<a href="${pageContext.request.contextPath}/formTag">Submit another form</a>
	</div>
</body>
</html>