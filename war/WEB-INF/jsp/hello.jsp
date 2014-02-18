<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		
		<link rel="stylesheet" href="<%= request.getContextPath() %>/css/app.css" type="text/css" />
		<title>
			<fmt:message key="title" />
		</title>
	</head>

	<body>
		<center>
			<h1> 
				<fmt:message key="heading"  /> 
			</h1>
		</center>
		
		<center>
			<div class="greetingMessage" >
				<p> 
					<fmt:message key="greeting" />
					<c:out value="${model.now}" /> 
				</p>
			</div>
		</center>
		
		<h3 class="productList">Product List</h3>
		
		<ul class="list">		
		<c:forEach items="${model.products}" var="product">		
			<li >
				<c:out value="${product.description}" />:&nbsp;
				<em> <c:out value="${product.price}" /> </em>
			</li>
		</c:forEach>
		</ul>
		
		<br />
		<div class="menu" >
			<a   href="<c:url value="priceincrease.htm" />" >
				Increase prices
			</a>
		</div>
	</body>
</html>