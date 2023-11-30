package com.calendar.yoony.member.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.calendar.yoony.member.dao.IMemberDAO;
import com.calendar.yoony.member.vo.MemberVO;

	
@Service
public class MemberService {
	
//	@Autowired : 생성한 DAO  new로 생성하지 않아도 바로 사용가능
	@Autowired
	IMemberDAO dao;
		
	public void registMember(MemberVO member) throws Exception {
		int result = dao.registMember(member);
		if(result == 0) {
			throw new Exception();
		}
	}
	
	public MemberVO loginMember(MemberVO member) {
		MemberVO result = dao.loginMember(member);
		if(result == null) {
			return null;
		}
		return result;
	}
	
	public String uploadProfile(MemberVO member, String uploadDir, String webPath, MultipartFile file) throws Exception {
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
		member.setProfileImg(dbFilePath);
		int result = dao.profileUpLoad(member);
		if (result == 0) {
			throw new Exception();
		}
		return dbFilePath;
	}
	
}
