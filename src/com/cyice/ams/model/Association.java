package com.cyice.ams.model;

public class Association {

	// 社团名称
	private String name;
	// 负责人
	private String chargeName;
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
	// 社团所有活动名称
	private String activities;
	// 简介
	private String synopsis;

	public Association(String _name, String _foundingTime, String _chargeName, String _phoneNumber, String _email,
			String _members, String _activities, String _synopsis) {
		this.name = _name;
		this.chargeName = _chargeName;
		this.phoneNumber = _phoneNumber;
		this.email = _email;
		this.members = _members;
		this.foundingTime = _foundingTime;
		this.activities = _activities;
		this.synopsis = _synopsis;
	}

	public String getName() {
		return name;
	}

	public String getChargeName() {
		return chargeName;
	}

	public String getActivities() {
		return activities;
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
