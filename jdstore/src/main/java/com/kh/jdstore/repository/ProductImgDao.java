package com.kh.jdstore.repository;

public interface ProductImgDao {
	void insert(int productNo, int attachmentNo);
	int info(int productNo);
}
