package com.calendar.yoony.icons.vo;

public class IconVO {
	private String iconNo;          
	private String memId; 
	private String iconImg;   	
	private String iconComment; 
	private String delYn;
	
	
	public IconVO() {
	}
	
	
	public IconVO(String memId, String iconImg, String iconComment) {
		this.memId = memId;
		this.iconImg = iconImg;
		this.iconComment = iconComment;
	}


	public String getIconNo() {
		return iconNo;
	}
	public void setIconNo(String iconNo) {
		this.iconNo = iconNo;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getIconImg() {
		return iconImg;
	}
	public void setIconImg(String iconImg) {
		this.iconImg = iconImg;
	}
	public String getIconComment() {
		return iconComment;
	}
	public void setIconComment(String iconComment) {
		this.iconComment = iconComment;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	@Override
	public String toString() {
		return "IconVO [iconNo=" + iconNo + ", memId=" + memId + ", iconImg=" + iconImg + ", iconComment=" + iconComment
				+ ", delYn=" + delYn + "]";
	}
	
	
	
}
