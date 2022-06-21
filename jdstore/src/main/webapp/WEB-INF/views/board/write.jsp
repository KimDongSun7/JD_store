<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<form action="write" method="post">

<c:if test="${superNo != null}">
	<input type="hidden" name="superNo" value="${superNo}">
</c:if>

	<div class="container w800 m30">
	    <div class="row center">
	        <h1>게시글 작성</h1>
	    </div>
	    <div class="row">
	        <label>말머리</label>
	        <select name="boardHead" class="form-input fill input-round">
	            <option value="">선택</option>
	            <option>상품후기</option>
	            <option>상품 컴플레인 </option>
	            <option>공지</option>
	        </select>
	    </div>
	    <div class="row">
	        <label>제목</label>
	        <input type="text" name="boardTitle" autocomplete="off" required class="form-input fill input-round">
	    </div>
	    <div class="row">
	        <label>내용</label>
	        <textarea name="boardContent" required class="form-input fill input-round" rows="12"></textarea>
	    </div>
	    <div class="row">
	        <button type="submit" class="btn btn-primary fill">등록</button>
	    </div>
	    <div class="row">
	        <a href="list" class="link link-btn fill">목록</a>
	    </div>
	</div>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>