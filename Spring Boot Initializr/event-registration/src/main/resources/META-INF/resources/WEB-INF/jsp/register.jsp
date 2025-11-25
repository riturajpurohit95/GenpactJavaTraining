<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 
<!-- Taglib directives -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Event Registration</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css"/>
</head>
<body>
	<div class="container">
		<h2>Event Registration Form - Tech Conference</h2>
		<form:form action="${pageContext.request.contextPath}/register" modelAttribute="user" method="post">
		
			<form:label path="name">Name:</form:label>
            <form:input path="name"  cssClass="text-input"/><br>
			
			<form:label path="email">Email:</form:label>
            <form:input path="email" type="email"  cssClass="text-input"/><br>
            <form:errors path="email" cssClass="error"/><br>
			
			<form:label path="password">Password:</form:label>
            <form:input path="password" id="password"  cssClass="text-input"/><br>
			
			<form:label path="city">City:</form:label>
            <form:input path="city"  cssClass="text-input"/><br>
			
			<form:label path="contact">Contact:</form:label>
            <form:input path="contact"  cssClass="text-input"/><br>
			
			<form:label path="gender">Gender:</form:label>
            <label><form:radiobutton path="gender" value="Male"/>Male</label>
            <label><form:radiobutton path="gender" value="Female"/>Female</label>
			<label><form:radiobutton path="gender" value="Other"/>Other</label><br>
			
			<label>Technologies:</label>
			<form:checkboxes path="technologies" items="${technologiesOptions}"/><br>
			
			<label>Sessions:</label>
			<form:select multiple="true" path="sessions" items="${sessionsOptions}"/><br>
			<form:errors path="sessions" cssClass="error"/><br>
			
			<label>Newsletter:</label>
			<form:checkbox path="newsletter" cssClass="text-input"/><br>
			
			<label>Payment:</label>
			<form:select path="payment" items="${paymentOptions}"/><br>
			
			<label>Comments:</label>
			<form:textarea path="comments" rows="5" cols="30" cssClass="text-input"/><br>
			
			<button type="submit">Register</button>
		</form:form>
	</div>
	
	<p><a href="${pageContext.request.contextPath}/">Home</a></p>
</body>
</html>