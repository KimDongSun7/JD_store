package com.kh.jdstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.jdstore.entity.BoardDto;
import com.kh.jdstore.repository.BoardDao;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardDao boardDao;
	
	//숫자가 없으면 페이지 1로 가기 위해서 p에 defaultValue를 1로 지정 
	@GetMapping("/list")
	public String list(
		@RequestParam(required = false) String type,
		@RequestParam(required = false) String keyword, 
		@RequestParam(required = false, defaultValue= "1") int p,
		@RequestParam(required = false, defaultValue= "10") int s, 
		Model model
			){
		
		List<BoardDto> list = boardDao.list(type, keyword, p, s);
		model.addAttribute("list, list");
		
		boolean search = type != null && keyword != null; 
		
			return "board/list";
		}
	
	
	
	//@GetMapping("/write")
	//@PostMapping("/write")
	//@GetMapping("/detail")
	//@GetMapping("/delete")
	//@GetMapping("/edit")
	//@PostMapping("/edit")
	
}
