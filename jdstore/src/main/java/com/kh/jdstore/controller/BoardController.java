package com.kh.jdstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.jdstore.entity.BoardDto;
import com.kh.jdstore.entity.MemberDto;
import com.kh.jdstore.repository.BoardDao;
import com.kh.jdstore.repository.MemberDao;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("/list")
	public String list(
				@RequestParam(required = false) String type,
				@RequestParam(required = false) String keyword,
				@RequestParam(required = false, defaultValue = "1") int p,
				@RequestParam(required = false, defaultValue = "10") int s,
				Model model
			) {
		
		List<BoardDto> list = boardDao.list(type, keyword, p, s);
		model.addAttribute("list", list);
		
		boolean search = type != null && keyword != null;
		model.addAttribute("search", search);
		 
		int count = boardDao.count(type, keyword);
		int lastPage = (count + s - 1) / s;
		
		int blockSize = 10;//블록 크기
		int endBlock = (p + blockSize - 1) / blockSize * blockSize;
		int startBlock = endBlock - (blockSize - 1);
		if(endBlock > lastPage){
			endBlock = lastPage;
		}
		
		model.addAttribute("p", p);
		model.addAttribute("s", s);
		model.addAttribute("type", type);
		model.addAttribute("keyword", keyword);
		model.addAttribute("startBlock", startBlock);
		model.addAttribute("endBlock", endBlock);
		model.addAttribute("lastPage", lastPage);
		
		return "board/list";
	}
	
	@GetMapping("/detail")
	public String detail(
			@RequestParam int boardNo, Model model, HttpSession session) {
		BoardDto boardDto = boardDao.read(boardNo);
		model.addAttribute("boardDto", boardDto);
		
		//작성자 정보 조회
		//-> 탈퇴한 사용자인 경우 실행하지 않는다
		if(boardDto.getBoardWriter() != null) {
			MemberDto memberDto = memberDao.info(boardDto.getBoardWriter());
			model.addAttribute("memberDto", memberDto);
		}
		
		//내 글인지 판정
		String memberId = (String) session.getAttribute("login");
		boolean isLogin = memberId != null;
		boolean isOwner = isLogin && memberId.equals(boardDto.getBoardWriter());
		model.addAttribute("isLogin", isLogin);
		model.addAttribute("isOwner", isOwner);
		
		//관리자인지 판정
		String memberGrade = (String)session.getAttribute("auth");
		boolean isAdmin = memberGrade != null && memberGrade.equals("관리자");
		model.addAttribute("isAdmin", isAdmin);
		
		//현재 글에 대한 댓글 목록을 조회(미구현)
		
		return "board/detail";
	}
	
	@GetMapping("/detail/{boardNo}")
	public String detail2(@PathVariable int boardNo, Model model, HttpSession session) {
		BoardDto boardDto = boardDao.read(boardNo);
		model.addAttribute("boardDto", boardDto);
		
		//작성자 정보 조회
		//-> 탈퇴한 사용자인 경우 실행하지 않는다
		if(boardDto.getBoardWriter() != null) {
			MemberDto memberDto = memberDao.info(boardDto.getBoardWriter());
			model.addAttribute("memberDto", memberDto);
		}
		
		//내 글인지 판정
		String memberId = (String) session.getAttribute("login");
		boolean isLogin = memberId != null;
		boolean isOwner = isLogin && memberId.equals(boardDto.getBoardWriter());
		model.addAttribute("isLogin", isLogin);
		model.addAttribute("isOwner", isOwner);
		
		//관리자인지 판정
		String memberGrade = (String)session.getAttribute("auth");
		boolean isAdmin = memberGrade != null && memberGrade.equals("관리자");
		model.addAttribute("isAdmin", isAdmin);
		
		//현재 글에 대한 댓글 목록을 조회(미구현)
		
		return "board/detail";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam int boardNo) {
		boardDao.delete(boardNo);
		return "redirect:list"; 
	}
	
	@GetMapping("/delete/{boardNo}")
	public String delete2(@PathVariable int boardNo) {
		boardDao.delete(boardNo);
		return "redirect:/board/list"; 
	}
	
	
	@GetMapping("/edit")
	public String edit(@RequestParam int boardNo, Model model) {
		BoardDto boardDto = boardDao.info(boardNo);
		model.addAttribute("boardDto", boardDto); 
		return "board/edit";
	}
	
	@GetMapping("/edit/{boardNo}")
	public String edit2 (@PathVariable int boardNo, Model model) {
		BoardDto boardDto = boardDao.info(boardNo);
		model.addAttribute("boardDto", boardDto); 
		return "board/edit2";
	}
	
	
	@PostMapping("/edit")
	public String edit(
			@ModelAttribute BoardDto boardDto, 
			HttpServletResponse response, 
			RedirectAttributes attr){ 
		
		boardDao.edit(boardDto);
		attr.addAttribute("boardNo", boardDto.getBoardNo());
		return "redirect:detail";
	}
		
	@PostMapping("/edit/{boardNO}")
	public String edit2 (
		@ModelAttribute BoardDto boardDto, 
		@PathVariable int boardNo,
		RedirectAttributes attr) {
		boardDto.setBoardNo(boardNo);
		boardDao.edit(boardDto); 
		
		attr.addAttribute("boardNo", boardDto.getBoardNo());
		return "redirect:detail";
	}
			
	@GetMapping("/write")
	public String write(
			@RequestParam(required = false, defaultValue = "0") int superNo,
			Model model) {
		if(superNo > 0) {
			model.addAttribute("superNo", superNo);
		}
		return "board/write";
	}
	
	@PostMapping("/write")
	public String write(@ModelAttribute BoardDto boardDto,
									HttpSession session,
									RedirectAttributes attr) {
		//새글 : boardHead + boardTitle + boardContent
		//답글 : 새글 + superNo
		
		//작성자 추가
		String memberId = (String) session.getAttribute("login");
		boardDto.setBoardWriter(memberId);
		
		int boardNo = boardDao.write(boardDto);
		
//		return "redirect:detail?boardNo="+boardNo;
		attr.addAttribute("boardNo", boardNo);
		return "redirect:detail";
	}
	
}
