package com.kh.jdstore.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class MemberDto {

	private String memberId; 
	private String memberPw;
	private String memberNick;
	private String memberPhone;
	private String memberEmail;
	private String memberBirth;
	private String memberPost;
	private String memberBasicAddress;
	private String memberDetailAddress;
	private int memberPoint;
	private String memberGrade;
	private Date memberJoindate;
	private Date memberLogindate;

}
