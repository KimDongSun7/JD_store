package com.kh.jdstore.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductDto {
	private int productNo;
	private String productName;
	private String productCategory;
	private int productPrice;
	private int productStock;
}
