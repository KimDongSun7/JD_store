package com.kh.jdstore.repository;

import java.io.IOException;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.multipart.MultipartFile;

import com.kh.jdstore.entity.AttachmentDto;

public interface AttachmentDao {
	int save(MultipartFile attachment) throws IllegalStateException, IOException;
	AttachmentDto info(int attachmentNo);
	ByteArrayResource load(String attachmentSave)throws IOException;
}
