package com.kh.jdstore.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.jdstore.entity.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {

	@	Autowired
	private SqlSession sqlSession; 
	
	@Override
	public void join(MemberDto memberDto) {
		// TODO Auto-generated method stub
		
	}
// String memberPw 는 사용자가 입력한 비밀번호 
// memberDto 는 DB 데이터 
	
	@Override
	public MemberDto login(String memberId, String memberPw) {
		MemberDto memberDto = sqlSession.selectOne("member.one", memberId);
		if(memberDto == null) {
			return null;
		}
		
		boolean isPasswordMatch = memberDto.getMemberPw().equals(memberPw);
		if(isPasswordMatch) {
			return memberDto;
		}
		else {
			return null;
		}
	}

	
}
