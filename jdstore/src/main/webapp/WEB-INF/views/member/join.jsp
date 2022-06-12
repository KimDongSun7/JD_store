<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   
    <!-- 프로필 이미지를 추가하기 위해 enctype을 multipart/form-data로 변경 -->
<form action="join" method="post" enctype="multipart/form-data">
	<div class="container w450 m30">
	    <div class="row center">
	        <h1>회원가입</h1>
	    </div>
	    <div class="row">
	        <label>아이디</label>
	        <input type="text" name="memberId" autocomplete="off" placeholder="영문 소문자, 숫자 8~20자" required class="form-input fill input-round">
	    </div>
	    <div class="row">
	        <label>비밀번호</label>
	        <input type="password" name="memberPw" required placeholder="영어, 숫자, 특수문자 8~16자" class="form-input fill input-round">
	    </div>
	    <div class="row">
	        <label>
	           	이름
	            <input type="text" name="memberName" required placeholder="한글, 숫자 10자 이내" autocomplete="off" class="form-input fill input-round">
	        </label>
	    </div>
	    <div class="row">
	        <label>생년월일</label><br>
	        <input type="date" name="memberBirth" required class="form-input input-round" autocomplete="off">
	    </div>
	    <div class="row">
	        <label>전화번호</label>
	        <input type="tel" name="memberPhone" required placeholder="- 제외하고 입력" class="form-input fill input-round" autocomplete="off">
	    </div>
	    <div class="row">
	        <label>이메일</label>
	        <input type="email" name="memberEmail" class="form-input fill input-round" autocomplete="off">
	    </div>
	    <div class="row">
	        <label>주소</label><br>
	        <input type="text" name="memberPost" size="6" maxlength="6" placeholder="우편번호" class="form-input input-round" autocomplete="off">
	        <a href="#" class="link link-btn">검색</a>
	    </div>
	    <div class="row">
	        <input type="text" name="memberBasicAddress" placeholder="기본주소" class="form-input fill input-round" autocomplete="off">
	    </div>
	    <div class="row">
	        <input type="text" name="memberDetailAddress" placeholder="상세주소" class="form-input fill input-round" autocomplete="off">
	    </div>
	    <div class="row">
	    	<label>프로필 이미지</label><br>
	    	<input type="file" name="memberProfile" class="form-input input-round">
	    </div>
	    <div class="row">
	        <button type="submit" class="btn btn-primary fill">회원가입</button>
	    </div>
	</div>
</form>

