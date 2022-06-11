package com.kh.jdstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.jdstore.entity.ProductDto;
import com.kh.jdstore.repository.ProductDao;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductDao productDao;
	
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
	public String insert(@ModelAttribute ProductDto productDto) {
		productDao.insert(productDto);
		return "redirect:list";
	}
}
