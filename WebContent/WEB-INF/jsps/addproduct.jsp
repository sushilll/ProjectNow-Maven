<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="_head_include.jsp"%>
<title>Add Product</title>
</head>
<body>
	<div class="container">
		<jsp:include page="_header.jsp"></jsp:include>
		<jsp:include page="_menu.jsp"></jsp:include>

		<div class="page-title">Add Product</div>
		<div class="content info-container">
			<c:choose>
				<c:when test="${!auth}">
					<h2 class="error">Access Denied</h2>
				</c:when>
				<c:otherwise>
					<div class="enter-info">
						<form action="addproduct" method="post">
							<table>
								<tbody>
									<tr>
										<td>Product id:</td>
										<td>${pid}</td>
									</tr>
									<tr>
										<td>Name:</td>
										<td><input name="pname" value="${pname}" required="true"></td>
										<c:if test="${pnameError}">
											<td class="error">Name can not be empty</td>
										</c:if>
									</tr>
									<tr>
										<td>Details:</td>
										<td><input name="pdetails" value="${pdetails}"
											required="true"></td>
										<c:if test="${pdetailsError}">
											<td class="error">Details can not be empty</td>
										</c:if>
									</tr>
									<tr>
										<td>Price:</td>
										<td><input name="pprice" value="${pprice}"
											required="true"></td>
										<c:if test="${ppriceError}">
											<td class="error">Invalid price</td>
										</c:if>
									</tr>
									<tr>
										<td>Image Link:</td>
										<td><input name="plink" value="${plink}"></td>
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
				</c:otherwise>
			</c:choose>

		</div>

		<%@ include file="_footer.jsp"%>
	</div>
</body>
</html>