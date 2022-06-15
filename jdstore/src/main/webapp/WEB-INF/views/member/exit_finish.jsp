<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container w500 m30">
	<div class="row center m30">
		<h1>그동안 이용해주셔서 감사합니다</h1>
	</div>
	<div class="row center m30">
		<h5>가까운 시일에 다시 만나요!</h5>
	</div>
	<div class="row center m30">
		
		<a href="https://www.naver.com"><img src="<%=request.getContextPath()%>/image/error.png" width="50" height="50"></a>
	</div>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>