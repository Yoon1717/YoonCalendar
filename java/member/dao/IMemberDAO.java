package com.calendar.yoony.member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.calendar.yoony.member.vo.MemberVO;

@Mapper
public interface IMemberDAO {
	public int registMember(MemberVO member);
	public MemberVO loginMember(MemberVO member);
	// 사진 업로드를 위한
	public int profileUpLoad(MemberVO member);
	
}
