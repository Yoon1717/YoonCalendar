package com.calendar.yoony.cld.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.calendar.yoony.cld.vo.CldVO;
import com.calendar.yoony.icons.vo.IconVO;
import com.calendar.yoony.icons.vo.IconViewVO;
import com.calendar.yoony.member.vo.MemberVO;

@Mapper
public interface ICldDAO {
	public CldVO getCLD(String cldNo);
	public int writeCLD(CldVO cldVO);
	public int delCLD(String cldNo);
	
	
	public List<IconViewVO> getHomeCLD(CldVO cldVO);
//	public List<CldVO> getHomeCLD();
	
	
	public List<Map<String, Object>> countCldPerIcon(MemberVO vo);
}
