package com.kh.jdstore.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class ProductImgVO {
	private int productNo;
	private String productName;
	private String productCategory;
	private int productPrice;
	private int productStock;
	private int attachmentNo;
}
