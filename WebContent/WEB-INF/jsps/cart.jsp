<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="_head_include.jsp"%>
<title>Cart</title>
</head>
<body>
	<div class="container">
		<jsp:include page="_header.jsp"></jsp:include>
		<jsp:include page="_menu.jsp"></jsp:include>

		<div class="page-title">Cart</div>
		<div class="content">
			<div class="info-container">
				<c:choose>
					<c:when test="${cart == null || cart.size() == 0}">
						<h2>Cart is Empty</h2>
					</c:when>
					<c:otherwise>
						<c:forEach var="p" items="${cart}">
							<div class="product content">
								<img src="${p.getImageLink()}">
								<form action="cart" method="post">
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
											<td>Quantity:</td>
											<td><input style="width: 30px" type="text" name="quan"
												value="${p.getQuantity()}"><input class="btn"
												type="submit" value="change"><input type="hidden"
												name="hiddenId" value="${p.getId()}"></td>
										</tr>
										<tr>
											<td>Price:</td>
											<td>${p.getPrice()}</td>
										</tr>
										<tr>
											<td>Amount:</td>
											<td>${p.getQuantity()*p.getPrice()}</td>
										</tr>
										<tr>
											<td colspan="2"><a class="btn"
												href="removefromcart?id=${p.getId()}">Remove from cart</a></td>
										</tr>
									</table>
								</form>
							</div>
						</c:forEach>
						<h2>Total Amount: ${cartValue}</h2>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="bottom-menu">
				<div class="item">
					<a class="btn" href="productlist">Continue Shopping</a>
				</div>
				<c:choose>
					<c:when test="${cart == null || cart.size() == 0}">
						<div class="right-item">
							<a class="btn">Checkout</a>
						</div>
					</c:when>
					<c:otherwise>
						<div class="right-item">
							<a class="btn" href="checkout">Checkout</a>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<%@ include file="_footer.jsp"%>
	</div>

</body>
</html>