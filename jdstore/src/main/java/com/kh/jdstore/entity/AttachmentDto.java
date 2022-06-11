package com.kh.jdstore.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class AttachmentDto {
	private int attachmentNo;
	private String attachmentUpload;
	private String attachmentSave;
	private String attachmentType;
	private long attachmentSize;
}
