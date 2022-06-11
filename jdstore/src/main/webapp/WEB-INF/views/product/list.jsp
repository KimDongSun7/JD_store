<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품 목록</h1>
	<table border="1">
		<thead>
			<tr>
				<th>상품번호</th>
				<th>상품이름</th>
				<th>카테고리</th>
				<th>상품가격</th>
				<th>상품재고</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="productDto" items="${list}">
			<tr>
				<td>${productDto.productNo }</td>
				<td><a href ="detail?productNo=${productDto.productNo }">${productDto.productName }</a></td>
				<td>${productDto.productCategory }</td>
				<td>${productDto.productPrice }</td>
				<td>${productDto.productStock }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>