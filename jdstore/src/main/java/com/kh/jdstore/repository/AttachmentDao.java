package com.kh.jdstore.repository;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface AttachmentDao {
	int save(MultipartFile attachment) throws IllegalStateException, IOException;
}
