package com.kh.jdstore.repository;

import java.util.List;

import com.kh.jdstore.entity.ProductDto;
import com.kh.jdstore.vo.ProductImgVO;

public interface ProductDao {
	List<ProductImgVO> list();
	ProductDto detail(int productNo);
	void insert(ProductDto productDto);
}
