package com.cyice.ams.model;

public class Activity {

	// 活动名称
	private String name;
	// 承办社团
	private String associations;
	// 活动时间
	private String time;
	// 参与者
	private String participant;
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

	public String getOarticipant() {
		return participant;
	}

	public String getPlace() {
		return place;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public Activity(String _name, String _time, String _place, String _associations, String _synopsis,
			String _participant) {
		this.name = _name;
		this.associations = _associations;
		this.time = _time;
		this.participant = _participant;
		this.place = _place;
		this.synopsis = _synopsis;
	}

	public String getFormatInfo() {
		StringBuilder formatInfo = new StringBuilder();
		String separator = System.getProperty("line.separator");
		formatInfo.append("活动名称 ： " + this.name + separator);
		formatInfo.append("开始时间 ： " + this.time + separator);
		formatInfo.append("       地点 ： " + this.place + separator);
		formatInfo.append("主办社团 ： " + this.associations + separator);
		formatInfo.append("宣传标语 ： " + this.synopsis + separator);

		String[] part = this.participant.split("：");
		if (part[0].length() < 4) {
			formatInfo.append("    " + this.participant + separator);
		} else {
			formatInfo.append("" + this.participant + separator);
		}
		return formatInfo.toString();
	}

}
