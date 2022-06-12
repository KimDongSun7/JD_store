package com.kh.jdstore.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.mail.internet.ContentType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.jdstore.entity.AttachmentDto;
import com.kh.jdstore.repository.AttachmentDao;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {
	
	@Autowired
	private AttachmentDao attachmentDao;
	
	@GetMapping("/download")
	public ResponseEntity<ByteArrayResource> download(
			@RequestParam int attachmentNo) throws IOException{
		AttachmentDto attachmentDto = attachmentDao.info(attachmentNo);
		
		ByteArrayResource resource = attachmentDao.load(attachmentDto.getAttachmentSave());
		
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.contentLength(attachmentDto.getAttachmentSize())
				.header(HttpHeaders.CONTENT_ENCODING, StandardCharsets.UTF_8.name())
				.header(HttpHeaders.CONTENT_DISPOSITION, 
					ContentDisposition.attachment()
										.filename(attachmentDto.getAttachmentUpload(), StandardCharsets.UTF_8)
										.build()
										.toString()
				)
				.body(resource);
	}

}
