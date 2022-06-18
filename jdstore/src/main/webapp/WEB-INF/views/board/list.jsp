<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container w950 m30">
	
	<div class="row center m30">
		<h1>자유 게시판</h1>
	</div>
	
	<div class="row right">
		<a href="write" class="link link-btn">글쓰기</a>
	</div>		
	
	<div class="row">
		<table class="table table-border">
			<thead>
				<tr>
					<th>번호</th>
					<th width="40%">제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach var="boardDto" items="${list}">
				<tr>
					<td>${boardDto.boardNo}</td>
					<td class="left">
						<c:if test="${boardDto.depth > 0}">
							<c:forEach var="i" begin="1" end="${boardDto.depth}" step="1">
								&nbsp;&nbsp;&nbsp;&nbsp;
							</c:forEach>
							<img src="${pageContext.request.contextPath}/image/reply.png" width="20" height="20">
						</c:if>
					
						<!-- 말머리 -->
						<c:if test="${boardDto.boardHead != null}">
							[${boardDto.boardHead}]
						</c:if>
					
						<!-- 
							게시글 제목 링크
							[1] 일반 파라미터 방식의 링크
							[2] 경로 변수 방식의 링크 
						-->
						
						<!-- [1] -->
						<%--
						<a href="detail?boardNo=${boardDto.boardNo}">
							${boardDto.boardTitle}
						</a>
						 --%>
						
						<!-- [2] -->
						<a href="detail/${boardDto.boardNo}">
							${boardDto.boardTitle}
						</a>
						
						<!-- 댓글 수 출력 -->
						<c:if test="${boardDto.boardReplycount > 0}">
							[${boardDto.boardReplycount}]
						</c:if>
					</td>

					<td>
						<c:choose>
							<c:when test="${boardDto.boardWriter == null}">
								(탈퇴한 사용자)
							</c:when>
							<c:otherwise>
								${boardDto.boardWriter}
							</c:otherwise>
						</c:choose>
					</td>					
					<td>${boardDto.boardTime}</td>
					<td>${boardDto.boardReadcount}</td>
					
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="row center pagination">
	
		<c:if test="${p > 1}">
			<c:choose>
				<c:when test="${search}">
					<a href="list?p=1&s=${s}&type=${type}&keyword=${keyword}">&laquo;</a>
				</c:when>
				<c:otherwise>
					<a href="list?p=1&s=${s}">&laquo;</a>
				</c:otherwise>
			</c:choose>
		</c:if>
		
		<c:if test="${startBlock > 1}">
			<c:choose>
				<c:when test="${search}">
					<a href="list?p=${startBlock-1}&s=${s}&type=${type}&keyword=${keyword}">&laquo;</a>
				</c:when>
				<c:otherwise>
					<a href="list?p=${startBlock-1}&s=${s}">&laquo;</a>
				</c:otherwise>
			</c:choose>
		</c:if>
		
		<!-- 숫자 링크 영역 -->
		<c:forEach var="i" begin="${startBlock}" end="${endBlock}" step="1">
			<c:choose>
				<c:when test="${search}">
					<c:choose>
						<c:when test="${i == p}">
							<a class="active" href="list?p=${i}&s=${s}&type=${type}&keyword=${keyword}">${i}</a>
						</c:when>
						<c:otherwise>
							<a href="list?p=${i}&s=${s}&type=${type}&keyword=${keyword}">${i}</a>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${i == p}">
							<a class="active" href="list?p=${i}&s=${s}">${i}</a>
						</c:when>
						<c:otherwise>
							<a href="list?p=${i}&s=${s}">${i}</a>
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	
		<!-- 다음 버튼 영역 -->
		<c:if test="${endBlock < lastPage}">
			<c:choose>
				<c:when test="${search}">
					<a href="list?p=${endBlock+1}&s=${s}&type=${type}&keyword=${keyword}">&gt;</a>
				</c:when>
				<c:otherwise>
					<a href="list?p=${endBlock+1}&s=${s}">&gt;</a>
				</c:otherwise>
			</c:choose>
		</c:if>
		
		<c:if test="${p < lastPage}">
			<c:choose>
				<c:when test="${search}">
					<a href="list?p=${lastPage}&s=${s}&type=${type}&keyword=${keyword}">&raquo;</a>
				</c:when>
				<c:otherwise>
					<a href="list?p=${lastPage}&s=${s}">&raquo;</a>
				</c:otherwise>
			</c:choose>
		</c:if>
	
	</div>
	
	<div class="row center">
		<!-- 검색창 -->
		<form action="list" method="get">
			<select name="type" class="form-input input-round">
				<option value="board_title" <c:if test="${type == 'board_title'}">selected</c:if>>제목</option>
				<option value="board_content" <c:if test="${type == 'board_content'}">selected</c:if>>내용</option>
				<option value="board_writer" <c:if test="${type == 'board_writer'}">selected</c:if>>작성자</option>
			</select>
			
			<input type="search" name="keyword" placeholder="검색어 입력" required class="form-input input-round" value="${keyword}">
			
			<input type="submit" value="검색" class="btn btn-primary">
		</form>
	</div>
	
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>


