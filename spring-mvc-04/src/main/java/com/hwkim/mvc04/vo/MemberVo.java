package com.hwkim.mvc04.vo;

/** 테이블의 한개행 전체를 저장할 목적의 클래스 */
public class MemberVo {
	private String mid, mname, mpwd, mintro;
	//생성자메서드. 기본생성자, 변수전체수신 생성자
	public MemberVo() {
	}
	// Source->Generate Contructor using Fields
	public MemberVo(String mid, String mname, String mpwd, String mintro) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.mpwd = mpwd;
		this.mintro = mintro;
	}
	// getter/setter 메서드 Source->Generate Getters and Setters
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMpwd() {
		return mpwd;
	}
	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}
	public String getMintro() {
		return mintro;
	}
	public void setMintro(String mintro) {
		this.mintro = mintro;
	}
	// 선택사항: toString() - 디버깅용. 전체변수값 출력
	//Source -> Generate toString()
	@Override
	public String toString() {
		return "MemberVo [mid=" + mid + ", mname=" + mname + ", mpwd=" + mpwd + ", mintro=" + mintro + "]";
	}
}






