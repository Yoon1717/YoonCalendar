package com.calendar.yoony.icons.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.calendar.yoony.icons.dao.IIconDAO;
import com.calendar.yoony.icons.vo.IconVO;

@Service
public class IconService {
	
	@Autowired
	IIconDAO dao;
	
	// 홈화면 조회
	public List<IconVO> getHomeIcon(IconVO iconVO) throws Exception {
		List<IconVO> result = dao.getHomeIcon(iconVO);
		if(result== null) {
			throw new Exception();
		}
		return result;
	}
	
	// 아이콘 조회
	public IconVO getIcon(String iconNo) throws Exception {
		IconVO result = dao.getIcon(iconNo);
		if(result== null) {
			throw new Exception();
		}
		return result;
	}
	
	
	// 왜 int?? 
	public int writeIcon(IconVO icon) throws Exception {
		int result = dao.writeIcon(icon);
		if(result == 0) {
			throw new Exception();
		}
		return result;
	}
	
	
	// 멤버별 아이콘 조회 위함 getIcon과의 차이점 여쭤보기
	public List<IconVO> getIconList(int memId){
		List<IconVO> result = dao.getIconList(memId);
		return result;
	}
	
	
	public void delIcon(String iconNo) throws Exception {
		int result = dao.delIcon(iconNo);
		if (result == 0) {
			throw new Exception();
		}
	}
	
	public IconVO uploadProfile(IconVO vo, String uploadDir, String webPath, MultipartFile file) throws Exception {
		String originFilename = file.getOriginalFilename();
		// 서버에 저장되는 파일명 (중복을 방지하기 위해 유니크한이름생성) (랜덤값 + 원본파일명)
		String storedFilename = UUID.randomUUID().toString() + "_" + originFilename;
		String dbFilePath = webPath + storedFilename;
		Path filePath = Paths.get(uploadDir, storedFilename);
		try {
			// 실질적으로, 물리적으로 파일을 저장하는 경로
			Files.copy(file.getInputStream(), filePath);
		} catch (IOException e) {
			throw new Exception("file to save the file", e);
		}
		// 오류가 없으면 DB에 업데이트하는 부분
		vo.setIconImg(dbFilePath);

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String uniquId = sdf.format(date);
		vo.setIconNo(uniquId);
		
		int result = dao.writeIcon(vo);
		if (result == 0) {
			throw new Exception();
		}
		
		return vo;
	}
	
	
	
	
	
	
	
	
	
}
