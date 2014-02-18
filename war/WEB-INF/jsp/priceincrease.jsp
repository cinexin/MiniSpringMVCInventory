<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<link rel="stylesheet" href="<%= request.getContextPath() %>/css/app.css" type="text/css" />
		<style>
			
		</style>		
		<title>
			<fmt:message key="title"/>
		</title>
	</head>

	<body>
		
		<h1>
			<fmt:message key="priceincrease.heading" />
		</h1>
		 
		<form:form method="post" commandName="priceIncrease">
			<center>
				<div class="form"  >
					<fmt:message key="priceincrease.percentage"  />
					<form:input  path="percentage" size="2"  />
					<form:errors path="percentage" cssClass="error"  />
				</div>
				<br />
			
				<input type="submit" value="OK"/>
			</center>
		</form:form>
		
		<div class="menu">
			<a href="<c:url value="hello.htm" />" >Home </a>
		</div>		
	</body>
</html>