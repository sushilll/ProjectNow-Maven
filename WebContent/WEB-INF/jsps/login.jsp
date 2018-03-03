<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="_head_include.jsp"%>
<title>Login</title>
</head>
<body>
	<div class="container">
		<jsp:include page="_header.jsp"></jsp:include>
		<jsp:include page="_menu.jsp"></jsp:include>

		<div class="content">
			<div class="page-title">Login (for employee/manager only)</div>
			<div style="margin: 0 10%; padding-top: 5px;">
				<h4>${inputError}</h4>
				<form action="login" method="post">
					<table>
						<tr>
							<td><label>User id</label></td>
							<td><input type="text" name="userid" value="${useridError}" required="true"></td>
						</tr>
						<tr>
							<td><label>Password</label></td>
							<td><input type="password" name="pwd" required="true"></td>
						</tr>
						<tr>
							<td></td>
							<td><button type="submit">Submit</button></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div class="content">
			<div class="page-title">Id/Password</div>
			<div style="padding-left: 10px">
				<p>Manager/123</p>
				<p>Employee/123</p>
			</div>
		</div>

		<%@ include file="_footer.jsp"%>
	</div>
</body>
</html>