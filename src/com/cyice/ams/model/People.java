package com.cyice.ams.model;

public class People {

	// 姓名
	private String name;
	// 院系
	private String institute;
	// 班级
	private String classes;
	// 电话号码
	private String phoneNumber;
	// 电子邮箱Ï
	private String email;
	
	public String getName() {
		return name;
	}

	public String getInstitute() {
		return institute;
	}

	public String getClasses() {
		return classes;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getQq() {
		return qq;
	}

	public String getWechat() {
		return wechat;
	}

	// QQ
	private String qq;
	// 微信
	private String wechat;

	public People(String _name, String _institute, String _classes, String _phoneNumber, String _email, String _qq,
			String _wechat) {
		this.name = _name != null ? _name : "???";
		this.institute = _name != null ? _institute : "???";
		this.classes = _name != null ? _classes : "???";
		this.phoneNumber = _name != null ? _phoneNumber : "???";
		this.email = _name != null ? _email : "???";
		this.qq = _name != null ? _qq : "???";
		this.wechat = _name != null ? _wechat : "???";
	}

}
