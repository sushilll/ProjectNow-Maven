<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="_head_include.jsp"%>
<title>Orders</title>
</head>
<body>
	<div class="container">
		<jsp:include page="_header.jsp"></jsp:include>
		<jsp:include page="_menu.jsp"></jsp:include>

		<div class="page-title">Orders</div>
		<div class="content info-container">
			<c:choose>
				<c:when test="${!auth}">
					<h2 class="error">Access Denied</h2>
				</c:when>
				<c:otherwise>
					<div class="info-container">
					<h3>Total Order Count: ${orderCount}</h3>
						<table border="1" style="width: 100%;">
							<tbody>
								<tr>
									<th>Order id</th>
									<th>Order Date</th>
									<th>Customer Name</th>
									<th>Mobile</th>
									<th>Amount</th>
								</tr>
								<c:forEach var="o" items="${orders}">
									<tr>
										<td><a href="order?id=${o.getId()}">${o.getId()}</a></td>
										<td id="orderDate">${o.getOrderDate()}</td>
										<td>${o.getCust_name()}</td>
										<td>${o.getCust_mobile()}</td>
										<td>${o.getTotalAmount()}</td>
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