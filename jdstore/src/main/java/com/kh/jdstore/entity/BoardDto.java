package com.kh.jdstore.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BoardDto {
	private int boardNo;
	private String boardHead;
	private String boardTitle;
	private String boardContent;
	private Date boardTime;
	private int boardReadcount;
	private String boardWriter;
	private int boardReplycount;
	private int groupNo;
	private int superNo;
	private int depth;
}