package com.kh.jdstore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.jdstore.entity.MemberDto;
import com.kh.jdstore.repository.MemberDao;

@Controller
@RequestMapping("/member")  //  이 자리에 @Getmapping이나 @PostMapping 사용불가 
public class MemberController {

	 //의존성 주입 (Dependency injection)
    // 이클래스는 등록된 도구 중에서 memberDao를 쓸겁니다
   // 만약 등록된 도구 중 memberDao가 없다면 error 
	
	@Autowired 
	private MemberDao memberDao; 
	
	@GetMapping("/join")
	public String join() {
		return "member/join"; 	
	}

	@PostMapping("/join")
	public String join(
			@ModelAttribute MemberDto memberDto) {
		
		memberDao.join(memberDto);
		
//		return "redirect:join_success";//상대
		return "redirect:/member/join_success";//절대
	}
	
	@RequestMapping("/join_success")
	public String joinSuccess() {
		return "member/join_success";
	}

//	로그인 처리
// 사용자 요청 헤더에 있는 Referer라는 값을 알아야 로그인 성공 후 다시 이동 시킬 수 있다 
// - @RequestHeader("헤더이름")
	@GetMapping("/login")
	public String login(
			@RequestHeader(value = "Referer", defaultValue="/") String referer,
				Model model
			) {  
		model.addAttribute("referer", referer);
		return "member/login"; 
	}	
	
	@PostMapping("/login")
	public String login(
			@RequestParam String  memberId,
			@RequestParam String memberPw,
			@RequestParam String referer, 
			HttpSession session) {
		MemberDto memberDto = memberDao.login(memberId, memberPw);
		if(memberDto != null) { //로그인 성공 
			return "redirect:" + referer; 
		}
		else {// 로그인 실패
			return "Redirect:login?error"; 
		}
	}
	
			
			
	
			

	
	
}
