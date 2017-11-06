package com.cyice.ams.model;

public class Lecture extends Activity {

	// 工作单位
	private String workUnit;
	
	public Lecture(String _name, String _associations, String _time, String _participant, String _place,
			String _synopsis, String _workUnit) {
		super(_name, _associations, _time, _participant, _place, _synopsis);
		this.workUnit = _workUnit;
	}

	public String getWorkUnit() {
		return workUnit;
	}

}
