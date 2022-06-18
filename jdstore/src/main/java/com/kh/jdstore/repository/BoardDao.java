package com.kh.jdstore.repository;

import java.util.List;

import com.kh.jdstore.entity.BoardDto;

public interface BoardDao {

	List<BoardDto> list(String type, String keyword, int page, int size) ;
	
	

}
