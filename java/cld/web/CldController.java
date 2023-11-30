package com.calendar.yoony.cld.web;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.calendar.yoony.cld.service.CldService;
import com.calendar.yoony.cld.vo.CldVO;
import com.calendar.yoony.icons.service.IconService;
import com.calendar.yoony.icons.vo.IconVO;

@Controller
public class CldController {
	
	@Autowired
	CldService cldService;
	
	@Autowired
	IconService iconService;
	
	@ExceptionHandler(Exception.class)
	public String errorView(Exception e) {
		e.printStackTrace();
		return "errorView";
	}
	
//	유니크한 cld_no 생성
	@ResponseBody
	@PostMapping("/writeCldDo")
	public CldVO writeCldDo(@RequestBody CldVO cld) throws Exception {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		SimpleDateFormat sdf2 =  new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf3 =  new SimpleDateFormat("HH");
		String uniquId = sdf.format(date);
		String day     = sdf2.format(date);
		String hour    = sdf3.format(date);
		cld.setCldNo(uniquId);
		cld.setCldDay(day);
		cld.setCldHour(hour);
		cldService.writeCLD(cld);
		
		return cld;
	}
	
	@ResponseBody
	@PostMapping("/delCldDo")
	public String delCldDo(@RequestBody CldVO cld) throws Exception {
		String result = "fail";
		cldService.delCld(cld.getCldNo());
		result = "success";
		return result;
	}
	
}
