package com.calendar.yoony.icons.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.calendar.yoony.icons.service.IconService;
import com.calendar.yoony.icons.vo.IconVO;

@Controller
public class IconController {

	@Autowired
	IconService iconService;

	@ExceptionHandler(Exception.class)
	public String errorView(Exception e) {
		e.printStackTrace();
		return "errorView";
	}

	@ResponseBody
	@PostMapping("/writeIconDo")
	public IconVO writeIconDo(@RequestBody IconVO icon) throws Exception {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String uniquId = sdf.format(date);
		icon.setIconNo(uniquId);
		// 예외
		System.out.println(icon);
		iconService.writeIcon(icon);
		// DB속 아이콘 조회
		IconVO result = iconService.getIcon(uniquId);
		// 조회결과 리턴
		return result;
	}

	@ResponseBody
	@PostMapping("/delIconDo")
	public String delIconDo(@RequestBody IconVO icon) throws Exception {
		String result = "fail";
		iconService.delIcon(icon.getIconNo());
		result = "success";
		return result;
	}

	@PostMapping("/files/upload")
	public ResponseEntity<?> uploadFiles(@RequestParam("uploadImage") MultipartFile uploadImage, HttpServletRequest req, IconVO icon,
			@RequestParam Map<String, Object> map, HttpSession session) throws Exception {
		// 1. 웹접근
		System.out.println(icon);
		String webPath = "/resources/iconImage/";
		// 2. 서버 저장 폴더
		String folderPath = session.getServletContext().getRealPath(webPath);
		System.out.println(folderPath);

		IconVO result = iconService.uploadProfile(icon, folderPath, webPath, uploadImage);
		// --> 예외처리
		Map<String, Object> response = new HashMap<>();
		// 응답받는 쪽에서 이미지 위치에 실질적인 저장되어있는 위치로 변경
		response.put("message", "success");
		response.put("imagePath", result.getIconImg());
		response.put("iconNo", result.getIconNo());
		response.put("comment", icon.getIconComment());
		// 추가적인 응답 필요할때 
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
