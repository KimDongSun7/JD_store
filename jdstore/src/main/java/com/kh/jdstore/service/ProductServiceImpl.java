package com.kh.jdstore.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.kh.jdstore.entity.ProductDto;
import com.kh.jdstore.repository.AttachmentDao;
import com.kh.jdstore.repository.ProductDao;
import com.kh.jdstore.repository.ProductImgDao;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private AttachmentDao attachmentDao;
	
	@Autowired
	private ProductImgDao productImgDao;

	@Transactional
	@Override
	public void insert(ProductDto productDto, MultipartFile productImg) throws IllegalStateException, IOException {
			productDao.insert(productDto);
		
			//상품 이미지 추가
			if(!productImg.isEmpty()) {//상품이미지가 있으면
				int attachmentNo = attachmentDao.save(productImg);
				productImgDao.insert(productDto.getProductNo(), attachmentNo);
		}
	}

}
