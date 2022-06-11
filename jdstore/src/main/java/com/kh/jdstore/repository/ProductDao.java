package com.kh.jdstore.repository;

import java.util.List;

import com.kh.jdstore.entity.ProductDto;

public interface ProductDao {
	List<ProductDto> list();
	ProductDto detail(int productNo);
	void insert(ProductDto productDto);
}
