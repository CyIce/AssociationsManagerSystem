package com.cyice.ams.model;

public class Activity {

	// 活动名称
	private String name;
	// 承办社团
	private String associations;
	// 活动时间
	private String time;
	// 活动地点
	private String place;
	// 活动简介
	private String synopsis;

	public String getName() {
		return name;
	}

	public String getAssociations() {
		return associations;
	}

	public String getTime() {
		return time;
	}

	public String getPlace() {
		return place;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public Activity(String _name, String _associations, String _time, String _place, String _synopsis) {
		this.name = _name;
		this.associations = _associations;
		this.time = _time;
		this.place = _place;
		this.synopsis = _synopsis;
	}

}
