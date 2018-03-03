<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="_head_include.jsp"%>
<title>Checkout</title>
</head>
<body>
	<div class="container">
		<jsp:include page="_header.jsp"></jsp:include>
		<jsp:include page="_menu.jsp"></jsp:include>

		<div class="page-title">Checkout</div>
		<div class="content info-container">
			<div class="enter-info">
				<h4>Enter Billing Details:</h4>

				<form action="checkout" method="post">
					<table>
						<tbody>
							<tr>
								<td>Name:</td>
								<td><input name="name" value="${name}" required="true"></td>
								<c:if test="${nameError != null}">
									<td class="error">Name is required</td>
								</c:if>
							</tr>
							<tr>
								<td>Email:</td>
								<td><input name="email" value="${email}" required="true"></td>
								<c:if test="${emailError != null}">
									<td class="error">Invalid Email</td>
								</c:if>
							</tr>
							<tr>
								<td>Mobile:</td>
								<td><input name="mobile" value="${mobile}" required="true"></td>
								<c:if test="${mobileError != null}">
									<td class="error">10 digit Mobile is required</td>
								</c:if>
							</tr>
							<tr>
								<td>Address:</td>
								<td><input name="address" value="${address}" required="true"></td>
								<c:if test="${addressError != null}">
									<td class="error">Address is required</td>
								</c:if>
							</tr>
							<tr>
								<td></td>
								<td><input type="submit" value="Submit"> <input
									type="reset" value="Reset"></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>

		</div>

		<%@ include file="_footer.jsp"%>
	</div>
</body>
</html>