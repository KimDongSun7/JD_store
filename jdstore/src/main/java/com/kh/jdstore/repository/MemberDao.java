package com.kh.jdstore.repository;

import com.kh.jdstore.entity.MemberDto;

public interface MemberDao {
	
	void join(MemberDto memberDto);

	MemberDto login(String memberId, String memberPw);
}
