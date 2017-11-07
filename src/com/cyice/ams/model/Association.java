package com.cyice.ams.model;

public class Association {

	// 社团名称
	private String name;
	// 负责人
	private People charge;
	// 电话号码
	private String phoneNumber;
	// QQ
	private String qq;
	// 微信
	private String wechat;
	// 电子邮箱
	private String email;
	// 社团成员
	private String members;
	// 成立时间
	private String foundingTime;
	// 社团网址
	private String websize;
	// 简介
	private String synopsis;

	public Association(String _name, People _charge, String _phoneNumber, String _qq, String _wechat, String _email,
			String _member, String _foundingTime, String _websize, String _synopsis) {
		this.name = _name;
		this.charge = _charge;
		this.phoneNumber = _phoneNumber;
		this.qq = _qq;
		this.wechat = _wechat;
		this.email = _email;
		this.members = _member;
		this.foundingTime = _foundingTime;
		this.websize = _websize;
		this.synopsis = _synopsis;
	}

	public String getName() {
		return name;
	}

	public People getCharge() {
		return charge;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getQq() {
		return qq;
	}

	public String getWechat() {
		return wechat;
	}

	public String getEmail() {
		return email;
	}
	
	public String getMenbers() {
		return members;
	}

	public String getFoundingTime() {
		return foundingTime;
	}

	public String getWebsize() {
		return websize;
	}

	public String getSynopsis() {
		return synopsis;
	}

}
