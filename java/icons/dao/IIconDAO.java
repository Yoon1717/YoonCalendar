package com.calendar.yoony.icons.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.calendar.yoony.icons.vo.IconVO;

@Mapper
public interface IIconDAO {
	public IconVO getIcon(String iconNo);
	public List<IconVO> getHomeIcon(IconVO iconVO);
	public int writeIcon(IconVO icon);
	public List<IconVO> getIconList(int memId);
	public int delIcon(String iconNo);
	
	
	public int profileUpLoad(IconVO icon);
}
