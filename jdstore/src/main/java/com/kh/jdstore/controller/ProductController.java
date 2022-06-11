package com.kh.jdstore.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.jdstore.entity.ProductDto;
import com.kh.jdstore.repository.AttachmentDao;
import com.kh.jdstore.repository.ProductDao;
import com.kh.jdstore.repository.ProductImgDao;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private AttachmentDao attachmentDao;
	
	@Autowired
	private ProductImgDao productImgDao;
	
	@GetMapping("/list")
	public String list(Model model) {
		List<ProductDto> list= productDao.list();
		model.addAttribute("list", list);
		
		return "product/list";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam int productNo, Model model) {
		ProductDto productDto = productDao.detail(productNo);
		model.addAttribute("productDto",productDto);
		return "product/detail";
	}
	
	@GetMapping("/insert")
	public String insert() {
		return "product/insert";
	}
	
	@PostMapping("/insert")
	public String insert(
			@ModelAttribute ProductDto productDto,
			@RequestParam MultipartFile productImg) throws IllegalStateException, IOException {
		productDao.insert(productDto);
		
		//상품 이미지 추가
		if(!productImg.isEmpty()) {//상품이미지가 있으면
			int attachmentNo = attachmentDao.save(productImg);
			productImgDao.insert(productDto.getProductNo(), attachmentNo);
		}
		return "redirect:list";
	}
}
