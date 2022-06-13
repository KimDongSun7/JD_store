package com.kh.jdstore.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.jdstore.entity.ProductDto;
import com.kh.jdstore.vo.ProductImgVO;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<ProductImgVO> list() {
		
		return sqlSession.selectList("product.list");
	}

	@Override
	public ProductDto detail(int productNo) {	
		return sqlSession.selectOne("product.one",productNo);
	}

	@Override
	public void insert(ProductDto productDto) {
		int productNo = sqlSession.selectOne("product.sequence");
		productDto.setProductNo(productNo);
		sqlSession.insert("product.insert",productDto);
	}
	

}
