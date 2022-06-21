<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container w800 m30">
	<div class="row center m30">
		<h1>${boardDto.boardNo}번 글 보기</h1>
	</div>
	
	<div class="row">
		<table class="table table-border">
			<tr>
				<td class="left">
					<h2>
						<%-- 말머리가 있으면 출력 --%>
						<c:if test="${boardDto.boardHead != null}">
						[${boardDto.boardHead}]
						</c:if>
						${boardDto.boardTitle}
					</h2>
				</td>
			</tr>
			
			<tr>
				<td class="left">
					<c:choose>
						<c:when test="${boardDto.boardWriter == null}">
							(탈퇴한 사용자)
						</c:when>
						<c:otherwise>
							${boardDto.boardWriter}
				 			(${memberDto.memberGrade})
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			
			<!-- 
				내용 표시 영역 
				(주의) pre 태그는 아무런 에디터도 쓰지 않았을 경우에만 사용
			-->
			<tr height="250">
				<td valign="top" class="left">
					<pre>${boardDto.boardContent}</pre>
				</td>
			</tr>
			
			<!-- 버튼 영역 -->
			<tr>
				<td class="right">
					<a href="${pageContext.request.contextPath}/board/write" class="link link-btn">글쓰기</a>
					<a href="${pageContext.request.contextPath}/board/write?superNo=${boardDto.boardNo}" class="link link-btn">답글</a>
					
					<c:if test="${isOwner || isAdmin}">
					<a href="${pageContext.request.contextPath}/board/edit?boardNo=${boardDto.boardNo}" class="link link-btn">수정</a>
					<a href="${pageContext.request.contextPath}/board/edit/${boardDto.boardNo}" class="link link-btn">수정</a>
					<a href="${pageContext.request.contextPath}/board/delete?boardNo=${boardDto.boardNo}" class="link link-btn">삭제</a>
					<a href="${pageContext.request.contextPath}/board/delete/${boardDto.boardNo}" class="link link-btn">삭제</a>
					</c:if>
					<a href="${pageContext.request.contextPath}/board/list" class="link link-btn">목록</a>
				</td>
			</tr>
		</table>
	</div>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>