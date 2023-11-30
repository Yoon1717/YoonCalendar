package com.calendar.yoony.member.vo;

public class MemberVO {
	private String memId;
	private String memPw;
	private String memNm;
	private String profileImg;
	
	public MemberVO() {
		super();
	}

	public MemberVO(String memId, String memPw, String memNm) {
		super();
		this.memId = memId;
		this.memPw = memPw;
		this.memNm = memNm;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}

	public String getMemNm() {
		return memNm;
	}

	public void setMemNm(String memNm) {
		this.memNm = memNm;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", memPw=" + memPw + ", memNm=" + memNm + ", profileImg=" + profileImg
				+ "]";
	}
	
}
