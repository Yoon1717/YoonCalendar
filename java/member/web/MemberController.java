package com.calendar.yoony.member.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.calendar.yoony.cld.service.CldService;
import com.calendar.yoony.cld.vo.CldVO;
import com.calendar.yoony.member.service.MemberService;
import com.calendar.yoony.member.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	CldService cldService;
	
	
	@RequestMapping("/registView")
	public String registView() {
		return "member/registView";
	}

//	회원가입 컨트롤러
	@RequestMapping("/registDo")
	public String registDo(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = passwordEncoder.encode(request.getParameter("pw"));
		String nm = request.getParameter("nm");
		System.out.println(pw);
		MemberVO member = new MemberVO(id, pw, nm);
		try {
			memberService.registMember(member);
		} catch (Exception e) {
			e.printStackTrace();
			return "errorView";
		}
		return "redirect:/";
	}
	
//	로그인 컨트롤러
	@RequestMapping("/loginView")
	public String loginView(HttpServletRequest request, Model model) {
//		현재 request 객체의 요청이 어느 URL으로 부터 왔는지
		String requestUrl = request.getHeader("Referer");
//		Model : Controller와 view 사이에서 데이터를 전달하는 객체
//		model에 addAttribute로 key-value 상의 형태로 데이터를 저장하면 
//		view 에서 해당 key로 사용가능하다.
		model.addAttribute("fromUrl", requestUrl);
		
		return "member/loginView";
		
	}
//	memberVO가 맵핑되어 돌아오면 리다이랙트
	@RequestMapping("/loginDo")
	public String loginDo(MemberVO member, HttpSession session
						 , boolean remember, String fromUrl, HttpServletResponse response ) {
		System.out.println(member);
		MemberVO login = memberService.loginMember(member);
		
		boolean match = passwordEncoder.matches(member.getMemPw(), login.getMemPw());
		
		if(login == null || !match) {
//			로그인정보가 없으므로 나중에 처리하기 위해 msg=N
			return "redirect:/loginView?msg=N";
		}
		session.setAttribute("login", login);
//		세선을 담고 아래에서 체크
		if(remember) {
			//true 쿠키 생성
			Cookie cookie = new Cookie("rememberId", member.getMemId());
//			생성한 쿠키를 response(응답하는 객체)에 담아서 전달.
			response.addCookie(cookie);
		}else {
			// 쿠키 삭제
			Cookie cookie = new Cookie("rememberId", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);	// 응답하는 객체에 담아서 전달
		}
		return "redirect:" + fromUrl;
	}
	
//	로그아웃 컨트롤러 세션종료시키는 역할
	@RequestMapping("/logoutDo")
	public String logoutDo(HttpSession session, HttpServletRequest request) {
		// 세션종료
		session.invalidate();
		// 현재 요청이 어느 URL을 바라보는지
		String requestToUrl = request.getRequestURI().toString();
		String requestUrl = request.getHeader("Referer");
		System.out.println(requestUrl);
		return "redirect:" + requestUrl;
	}
	
	@RequestMapping("/mypage")
	public String mypage(HttpSession session, Model model) throws Exception {
		//로그인한 사람만 들어올수있도록 세션가져오기
		if (session.getAttribute("login")==null) {
			return "redirect:/loginView";
		}
		MemberVO login = (MemberVO) session.getAttribute("login");
		model.addAttribute("member", login);
		// 마이페이지 입장시 countCldPerIcon 데이터 가져오기
		List<Map<String, Object>> countCldPerIcon = cldService.countCldPerIcon(login);
		// 화면에서 foreach 로 접근가능
		model.addAttribute("countCldPerIcon", countCldPerIcon);
		
		
		return "member/mypage";
	}

	
}
