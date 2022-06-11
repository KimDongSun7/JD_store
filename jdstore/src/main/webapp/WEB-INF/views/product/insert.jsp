<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="insert" method="post" enctype="multipart/form-data">
	<div align="center">
		<div>
			<h1>상품 등록</h1>
		</div>
		<div>
			<label>상품 분류</label>
			<select name="productCategory">
				<option value="">선택</option>
				<option>상의</option>
				<option>하의</option>
				<option>모자</option>
				<option>신발</option>
			</select>
		</div>
		<div>
			<label>상품명</label>
			<input type="text" name="productName" required>
		</div>
		<div>
			<label>상품가격</label>
			<input type="number" name="productPrice" required>
		</div>
		<div>
			<label>상품재고</label>
			<input type="number" name="productStock" required>
		</div>
		<div>
			<label>상품 이미지</label>
			<input type="file" name="productImg" accept=".png, .jpg, .gif" multiple>
		</div>
		<div>
			<button type="submit">등록</button>
		</div>
	</div>
</form>
</body>
</html>