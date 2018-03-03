<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="_head_include.jsp"%>
<title>Order Details</title>
</head>
<body>
	<div class="container">
		<jsp:include page="_header.jsp"></jsp:include>
		<jsp:include page="_menu.jsp"></jsp:include>

		<div class="page-title">Order Details:</div>
		<div class="content info-container">
			<c:choose>
				<c:when test="${!auth}">
					<h2 class="error">Access Denied</h2>
				</c:when>
				<c:otherwise>
					<div class="enter-info">
						<h3>Customer Info:</h3>
						<table>
							<tr>
								<td>Name:</td>
								<td>${name}</td>
							</tr>
							<tr>
								<td>Mobile:</td>
								<td>${mobile}</td>
							</tr>
							<tr>
								<td>Email:</td>
								<td>${email}</td>
							</tr>
							<tr>
								<td>Address:</td>
								<td>${address}</td>
							</tr>
						</table>
						<h3>Total Amount: ${totalAmount}</h3>
					</div>
					<div class="info-container">
						<table border="1" style="width: 100%;">
							<tbody>
								<tr>
									<th>Product id</th>
									<th>Name</th>
									<th>Quantity</th>
									<th>Price</th>
									<th>Amount</th>
								</tr>
								<c:forEach var="o" items="${productList}">
									<tr>
										<td>${o.getId()}</td>
										<td>${o.getName()}</td>
										<td>${o.getQuantity()}</td>
										<td>${o.getPrice()}</td>
										<td>${o.getQuantity()*o.getPrice()}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</c:otherwise>
			</c:choose>

		</div>

		<%@ include file="_footer.jsp"%>
	</div>
</body>
</html>