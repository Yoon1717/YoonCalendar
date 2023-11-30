package com.calendar.yoony;

import java.text.DateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.calendar.yoony.cld.service.CldService;
import com.calendar.yoony.cld.vo.CldVO;
import com.calendar.yoony.icons.service.IconService;
import com.calendar.yoony.icons.vo.IconVO;
import com.calendar.yoony.icons.vo.IconViewVO;
import com.calendar.yoony.member.vo.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	IconService iconService;

	@Autowired
	CldService cldService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) throws Exception {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		if (session.getAttribute("login") != null) {
			MemberVO login = (MemberVO) session.getAttribute("login");
			IconVO iconVO = new IconVO();
			iconVO.setMemId(login.getMemId());
			List<IconVO> homeIconList = iconService.getHomeIcon(iconVO);
			model.addAttribute("getHomeIcon", homeIconList);
		}

		return "home";
	}

//	home은 dao, xml 따로 생성안해도 될지, if문 작성(그냥 자바에서 했듯이???)을 위(로그인시 리턴)에할지 아래에 따로 해야할지?
	@RequestMapping("/getHomeIcon")
	public String homeIconList(Model model, HttpSession session) throws Exception {

		if (session.getAttribute("login") != null) {
			MemberVO login = (MemberVO) session.getAttribute("login");
			IconVO iconVO = new IconVO();
			iconVO.setMemId(login.getMemId());
			List<IconVO> homeIconList = iconService.getHomeIcon(iconVO);
			model.addAttribute("getHomeIcon", homeIconList);
		}
		return "home";
	}

	/*
	  @RequestMapping("/getHomeCLD") public String homeCldList(Model model, HttpSession session) throws Exception {
		  if(session.getAttribute("login") != null) { 
			  MemberVO login = (MemberVO) session.getAttribute("login"); 
			  CldVO cldVO = new CldVO(); 
			  cldVO.setMemId(login.getMemId()); 
			  List<CldVO> homeCldList = cldService.getHomeCLD(cldVO); 
			  model.addAttribute("getHomeCLD", homeCldList);
		  } return "home"; 
	  }
	 */

	@ResponseBody
	@RequestMapping("/getHomeCLD")
	public List<IconViewVO> getHomeCldList(HttpSession session) throws Exception {
		if (session.getAttribute("login") != null) {
			MemberVO login = (MemberVO) session.getAttribute("login");
			CldVO cldVO = new CldVO();
			cldVO.setMemId(login.getMemId());
			List<IconViewVO> homeCldList = cldService.getHomeCLD(cldVO);
			return homeCldList;
		}
		return Collections.emptyList(); // 로그인되지 않았을 경우 빈 리스트 반환
	}

}
