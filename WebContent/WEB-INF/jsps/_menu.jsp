<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="menu-container">
	<div class="menu">
		<a href="home">Home</a>|<a href="productlist">Product List</a>| <a
			href="cart">Cart</a>|
		<c:if test="${user.getUserRole() != null}">
			<c:if test="${user.getUserRole().equals(\"Employee\")}">
			<a href="orders">Orders</a>|</c:if>
			<c:if test="${user.getUserRole().equals(\"Manager\")}">
				<a href="orders">Orders</a>|
				<a href="addproduct">Add New Product</a>
			</c:if>
		</c:if>
	</div>
</div>