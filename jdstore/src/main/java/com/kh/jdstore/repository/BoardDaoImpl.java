package com.kh.jdstore.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.jdstore.entity.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<BoardDto> list(String type, String keyword, int page, int size) {
		
		Map<String, Object> param = new HashMap<>();
		param.put("type", type);
		param.put("keyword", keyword);
		
		int end = page * size;
		int begin = end - (size - 1);
		
		param.put("begin", begin);
		param.put("end", end);
		
		return sqlSession.selectList("board.list", param);
		
	
	}

	@Override
	public int count(String type, String keyword) {
		Map<String, Object> param = new HashMap<>();
		param.put("type", type);
		param.put("keyword", keyword);
		
		return sqlSession.selectOne("board.count", param);
		
	}

	@Override
	public BoardDto read(int boardNo) {
		sqlSession.update("board.plusReadcount", boardNo); 
		return null;
	}

	@Override
	public boolean delete(int boardNo) {
			int count = sqlSession.delete("board.delete", boardNo);
			return count > 0; 
		
	}

	@Override
	public BoardDto info(int boardNo) {
		return sqlSession.selectOne("board.one", boardNo); 

	}

	@Override
	public boolean edit(BoardDto boardDto) {
		return sqlSession.update("board.edit", boardDto) > 0 ; 
	}

	@Override
	public int write(BoardDto boardDto) {
		int boardNo = sqlSession.selectOne("board.sequence");
		boardDto.setBoardNo(boardNo);
		//추가 계산
		if(boardDto.getSuperNo() == 0) {//새글
			boardDto.setGroupNo(boardNo);
			//설정 안해도 나머지(superNo, depth)는 0이다(객체 생성시 초기화됨)
		}
		else {//답글
			BoardDto originDto = sqlSession.selectOne("board.one", boardDto.getSuperNo());
			boardDto.setGroupNo(originDto.getGroupNo());//그룹번호 똑같이
			//superNo는 이미 설정되어 있음
			boardDto.setDepth(originDto.getDepth()+1);//차수 1 증가
		}
		sqlSession.insert("board.write", boardDto);
		return boardNo;
	}
} 
