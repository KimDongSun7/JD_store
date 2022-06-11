package com.kh.jdstore.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.kh.jdstore.entity.MemberDto;

public interface MemberService {
	void join(MemberDto memberDto, MultipartFile memberProfile) throws IllegalStateException, IOException;
}