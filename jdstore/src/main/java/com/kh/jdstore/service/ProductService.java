package com.kh.jdstore.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.kh.jdstore.entity.ProductDto;

public interface ProductService {
	void insert(ProductDto productDto, MultipartFile productImg) throws IllegalStateException, IOException;
}
