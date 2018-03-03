<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="_head_include.jsp"%>
<title>Shop</title>
</head>
<body>
	<div class="container">
		<jsp:include page="_header.jsp"></jsp:include>
		<jsp:include page="_menu.jsp"></jsp:include>

		<div class="page-title">Project Features</div>
		<div class="content">
			<ul>
				<li>Online Shop</li>
				<li>Cart</li>
				<li>Employee / Manager Authentication</li>
				<li>Orders Reports</li>
				<li>built on Servlet, JSP using MVC pattern</li>
			</ul>
		</div>
		
		<%@ include file="_footer.jsp" %>
	</div>
</body>
</html>