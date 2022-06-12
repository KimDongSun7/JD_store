<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${productDto.productNo }번 상품</h1>
	<div>
		<img src="${pageContext.request.contextPath}${profileUrl}"
		width = "150" class="img img-circle img-shadow">
	</div>
	<div>
		<table border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>카테고리</th>
					<th>가격</th>
					<th>재고</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${productDto.productNo }</td>
					<td>${productDto.productName }</td>
					<td>${productDto.productCategory }</td>
					<td>${productDto.productPrice }</td>
					<td>${productDto.productStock }</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>