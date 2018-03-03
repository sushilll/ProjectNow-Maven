<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="header">
	<div class="homeLink">
		<a href="home">Online Shop</a>
	</div>
	<div class="loginLink">
		<ul>
			<li>Hello <c:choose>
			<%-- <%=!session.getAttribute(\"userid\").equals(\"Guest\")%> --%>
			<c:when test="${!userid.equals(\"Guest\")}">
				<a href="accountinfo">${userid}</a></li>|
				<li><a href="logout">Logout</a></li></c:when>
			<c:otherwise>Guest</li>|<li><a href="login">Login</li></a>
			</c:otherwise>
			</c:choose>
			
		</ul>
	</div>
</div>