package com.kh.jdstore.repository;

import java.util.List;

import com.kh.jdstore.entity.BoardDto;

public interface BoardDao {

	List<BoardDto> list(String type, String keyword, int page, int size) ;

	int count(String type, String keyword);

	//조회수 증가 시켜서 가져오는 거
	BoardDto read(int boardNo);
	// 그냥 가져오는 거 
	BoardDto info(int boardNo);	

	boolean delete(int boardNo);
	boolean edit(BoardDto boardDto);

	int write(BoardDto boardDto);




	
	

}
