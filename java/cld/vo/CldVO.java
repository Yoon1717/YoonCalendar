package com.calendar.yoony.cld.vo;

public class CldVO {

	private String  cldNo    ; 
	private String  memId    ;
	private String  iconNo   ;
	private String  cldDay   ;
	private String  cldHour  ;
	private String  cldTime  ;
	private String  cldDelYn    ;

	public CldVO() {
		super();
	}

	public String getCldNo() {
		return cldNo;
	}

	public void setCldNo(String cldNo) {
		this.cldNo = cldNo;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getIconNo() {
		return iconNo;
	}

	public void setIconNo(String iconNo) {
		this.iconNo = iconNo;
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
		return "CldVO [cldNo=" + cldNo + ", memId=" + memId + ", iconNo=" + iconNo + ", cldDay=" + cldDay + ", cldHour="
				+ cldHour + ", cldTime=" + cldTime + ", cldDelYn=" + cldDelYn + "]";
	}
	
	
	
	
}
