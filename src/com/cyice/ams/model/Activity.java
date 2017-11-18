package com.cyice.ams.model;

public class Activity implements Comparable<Activity> {

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

	// 将时间转化为int类型返回
	private int timeToIntege() {
		String[] times = time.split("\\.");
		int t = Integer.parseInt(times[0]) * 10000 + Integer.parseInt(times[1]) * 100 + Integer.parseInt(times[2]);
		return t;
	}

	public String getFormatInfo(boolean isController) {

		StringBuilder formatInfo = new StringBuilder();
		String separator = System.getProperty("line.separator");
		formatInfo.append("活动名称 ： " + this.name + separator);
		formatInfo.append("开始时间 ： " + this.time + separator);
		formatInfo.append("地点 ： " + this.place + separator);
		formatInfo.append("主办社团 ： " + this.associations + separator);
		formatInfo.append("宣传标语 ： " + this.synopsis + separator);

		if (isController == true) {
			formatInfo.append(this.participant + separator);
		}
		return formatInfo.toString();
	}

	@Override
	public int compareTo(Activity o) {
		if (this.timeToIntege() > o.timeToIntege()) {
			return 1;
		} else if (this.timeToIntege() < o.timeToIntege()) {
			return -1;
		} else {
			return 0;
		}
	}

}
