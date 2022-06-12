package com.kh.jdstore.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductImgDaoImpl implements ProductImgDao{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insert(int productNo, int attachmentNo) {
		Map<Object, Object> param = new HashMap<>();
		param.put("productNo", productNo);
		param.put("attachmentNo", attachmentNo);
		sqlSession.insert("productImg.insert",param);
	}

	@Override
	public int info(int productNo) {
		Integer attachmentNo = sqlSession.selectOne("productImg.one", productNo);
		if(attachmentNo == null) {
			return 0;
		}
		else {
			return attachmentNo;
		}
	}
	
}
