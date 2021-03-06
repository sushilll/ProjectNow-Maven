<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="_head_include.jsp"%>
<title>Account Info</title>
</head>
<body>
	<div class="container">
		<jsp:include page="_header.jsp"></jsp:include>
		<jsp:include page="_menu.jsp"></jsp:include>

		<div class="page-title">Account Info</div>
		<div class="content">
			<ul class="user-info">
				<li>User id: ${user.getUserid()}</li>
				<li>Name: ${user.getName()}</li>
				<li>E-Mail: ${user.getEmail()}</li>
				<li>User Role: ${user.getUserRole() }</li>
			</ul>
		</div>
		<%@ include file="_footer.jsp" %>
	</div>
</body>
</html>