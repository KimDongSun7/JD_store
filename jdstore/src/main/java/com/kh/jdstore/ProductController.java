package com.kh.jdstore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
//	@GetMapping("/detail")
}
