<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="_head_include.jsp"%>
<title>Product List</title>
</head>
<body>
	<div class="container">
		<jsp:include page="_header.jsp"></jsp:include>
		<jsp:include page="_menu.jsp"></jsp:include>

		<div class="page-title">Product List</div>
		<div class="product-container content">
			<c:forEach var="p" items="${pagination.getList()}">
				<div class="product content">
				<img src="${p.getImageLink()}">
					<table>
						<tr>
							<td>Product Id:</td>
							<td>${p.getId()}</td>
						</tr>
						<tr>
							<td>Name:</td>
							<td>${p.getName()}</td>
						</tr>
						<tr>
							<td>Description:</td>
							<td>${p.getDetails()}</td>
						</tr>
						<tr>
							<td>Price:</td>
							<td>${p.getPrice()}</td>
						</tr>
					</table>
					<a class="btn" href="addtocart?id=${p.getId()}">Add to cart</a>
					<c:if test="${user.getUserRole().equals(\"Manager\")}">
						<a class="btn" href="edit?id=${p.getId()}">Edit</a>
					</c:if>
				</div>
			</c:forEach>
			<div class="pagination">
				Pages:
				<c:forEach var="i" items="${pagination.getNavigationPages()}">
					<c:choose>
						<c:when test="${i eq pagination.getCurrentPage()}">
							<a>${i}</a>
						</c:when>
						<c:otherwise>
							<a href="productlist?page=${i}">${i}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
		</div>

		<jsp:include page="_footer.jsp"></jsp:include>

	</div>
</body>
</html>