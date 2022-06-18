package com.kh.jdstore.repository;

import com.kh.jdstore.entity.MemberDto;

public interface MemberDao {
	
	void join(MemberDto memberDto);
	MemberDto login(String memberId, String memberPw);
	MemberDto info(String memberId);
	boolean changePassword(String memberId, String currentPw, String changePw);
	boolean exit(String memberId, String memberPw);
	boolean changeInformation(MemberDto memberDto); 
	
	
	
}
