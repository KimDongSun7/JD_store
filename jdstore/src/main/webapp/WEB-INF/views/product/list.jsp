<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"> -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/5.1.3/journal/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"/>
    <style>

    </style>
</head>
<body>
	<h1>상품 목록</h1>
	
<div class="container-fluid">
	<div class="row">
	<c:forEach var="productImgVO" items="${list}">
	<div id="carouselExampleControlsNoTouching" class="carousel slide" data-bs-touch="false" data-bs-interval="false">
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="${pageContext.request.contextPath}/attachment/download?attachmentNo=${productImgVO.attachmentNo}" class="d-block w-10" alt="...">
          </div>
          <div class="carousel-item">
            <img src="${pageContext.request.contextPath}/attachment/download?attachmentNo=${productImgVO.attachmentNo}" class="d-block w-10" alt="...">
          </div>
          <div class="carousel-item">
            <img src="${pageContext.request.contextPath}/attachment/download?attachmentNo=${productImgVO.attachmentNo}" class="d-block w-10" alt="...">
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControlsNoTouching" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControlsNoTouching" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
        
      </div>
      <div>${productImgVO.productNo }</div>
      <div><a href ="detail?productNo=${productImgVO.productNo }">${productImgVO.productName }</a></div>
      <div>${productImgVO.productCategory }</div>
      <div>${productImgVO.productPrice }</div>
      <div>${productImgVO.productStock }</div>
      </c:forEach>	
      </div>
</div>

<div class="card" style="width: 18rem;">
	<c:forEach var="productImgVO" items="${list}">
        <a href ="detail?productNo=${productImgVO.productNo }"><img src="${pageContext.request.contextPath}/attachment/download?attachmentNo=${productImgVO.attachmentNo}" class="card-img-top" alt="..."></a>
        <div class="card-body">
          <h5 class="card-title"><a href ="detail?productNo=${productImgVO.productNo }">${productImgVO.productName }</a></h5>
          <p class="card-text">${productImgVO.productPrice }</p>
          <a href="#" class="btn btn-primary">Go somewhere</a>
        </div>
	</c:forEach>
</div>
				
				
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script>

    </script>
</body>
</html>