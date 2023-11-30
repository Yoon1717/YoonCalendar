package com.calendar.yoony.cld.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calendar.yoony.cld.dao.ICldDAO;
import com.calendar.yoony.cld.vo.CldVO;
import com.calendar.yoony.icons.vo.IconVO;
import com.calendar.yoony.icons.vo.IconViewVO;
import com.calendar.yoony.member.vo.MemberVO;

@Service
public class CldService {

	@Autowired
	ICldDAO dao;
	
	public CldVO getCld(String cldNo) throws Exception {
		CldVO result = dao.getCLD(cldNo);
		if (result == null) {
			throw new Exception();
		}
		return result;
	}
	
	public int writeCLD(CldVO cldVO) throws Exception {
		System.out.println(cldVO);
		int result = dao.writeCLD(cldVO);
		if (result == 0) {
			throw new Exception();
		}
		return result;
	}
	
	public List<IconViewVO> getHomeCLD(CldVO cldVO) throws Exception{
		List<IconViewVO> result = dao.getHomeCLD(cldVO);
		if (result == null) {
			throw new Exception();
		}
		return result;
	}
	
	public void delCld(String cldNo) throws Exception {
		int result = dao.delCLD(cldNo);
		if (result == 0) {
			throw new Exception();
		}
	}
	
	public List<Map<String, Object>> countCldPerIcon(MemberVO vo) throws Exception{
		List<Map<String, Object>> result = dao.countCldPerIcon(vo); 
		if (result == null) {
			throw new Exception();
		}
		return result;
	}
	
	
	
	
	
}