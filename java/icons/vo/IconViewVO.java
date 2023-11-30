package com.calendar.yoony.icons.vo;

public class IconViewVO {
	
	private String iconNo;
	private String memId;
	private String iconImg;
	private String iconComment;
	private String delYn;
	private String cldNo;
	private String cldDay;
	private String cldHour;
	private String cldTime;
	private String cldDelYn;

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

	public String getCldNo() {
		return cldNo;
	}

	public void setCldNo(String cldNo) {
		this.cldNo = cldNo;
	}

	public String getCldDay() {
		return cldDay;
	}

	public void setCldDay(String cldDay) {
		this.cldDay = cldDay;
	}

	public String getCldHour() {
		return cldHour;
	}

	public void setCldHour(String cldHour) {
		this.cldHour = cldHour;
	}

	public String getCldTime() {
		return cldTime;
	}

	public void setCldTime(String cldTime) {
		this.cldTime = cldTime;
	}

	public String getCldDelYn() {
		return cldDelYn;
	}

	public void setCldDelYn(String cldDelYn) {
		this.cldDelYn = cldDelYn;
	}

	@Override
	public String toString() {
		return "IconViewVO [iconNo=" + iconNo + ", memId=" + memId + ", iconImg=" + iconImg + ", iconComment="
				+ iconComment + ", delYn=" + delYn + ", cldNo=" + cldNo + ", cldDay=" + cldDay + ", cldHour=" + cldHour
				+ ", cldTime=" + cldTime + ", cldDelYn=" + cldDelYn + "]";
	}

	public IconViewVO() {
	}

}
