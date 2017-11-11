package com.cyice.ams.control;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.cyice.ams.model.Activity;
import com.cyice.ams.model.Association;
import com.cyice.ams.model.FileInput;
import com.cyice.ams.view.AssociationsView;

public class Control implements ListSelectionListener {

	// 社团介绍实图实例
	private AssociationsView associationsView;
	// 社团实例
	private List<Association> associations = new ArrayList<>();
	// 活动实例
	private List<Activity> activities = new ArrayList<>();

	public void initView() {

		initAssociations();
		initActivities();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					associationsView = new AssociationsView();
					associationsView.setVisible(true);
					initSelectetionListener();
					initTextFieldListener();
					updateAssociationsList(null);
					updateActivitiesList(null);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	// 绑定事件监听函数
	private void initSelectetionListener() {
		associationsView.getAssociations().addListSelectionListener(this);
		associationsView.getActivities().addListSelectionListener(this);
	}

	// 社团列表和活动列表搜索事件监听和响应
	private void initTextFieldListener() {

		associationsView.getAssociationSearch().getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				updateAssociationsList(associationsView.getAssociationSearch().getText());
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				updateAssociationsList(associationsView.getAssociationSearch().getText());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		associationsView.getActivitySearch().getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				updateActivitiesList(associationsView.getActivitySearch().getText());
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				updateActivitiesList(associationsView.getActivitySearch().getText());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
	}

	// 初始化社团实例
	// 初始化社团实例
	private void initAssociations() {
		List<String> strings = FileInput.readFile("社团表");
		for (String s : strings) {
			if (s.length() <= 0) {
				continue;
			}
			String[] line = s.split(",");
			associations.add(new Association(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7]));
		}
	}

	// 初始化活动实例 // 初始化活动实例
	private void initActivities() {
		List<String> strings = FileInput.readFile("活动表");
		for (String s : strings) {
			if (s.length() <= 0) {
				continue;
			}
			String[] line = s.split(",");
			String end = line.length < 6 ? "" : line[5];
			activities.add(new Activity(line[0], line[1], line[2], line[3], line[4], end));
		}
	}

	// 更新社团列表内容
	// 更新社团列表
	private void updateAssociationsList(String _words) {
		DefaultListModel<String> associationsValue = new DefaultListModel<>();
		Boolean isBlank = true;
		for (Association association : associations) {
			if (_words == null || association.getName().contains(_words)) {
				associationsValue.addElement(association.getName());
				isBlank = false;
			}
		}
		if (!isBlank) {
			associationsView.getAssociations().setModel(associationsValue);
		}
	}

	// 更新活动列表内容
	// 更新活动列表
	private void updateActivitiesList(String _words) {
		DefaultListModel<String> activitiesValue = new DefaultListModel<>();
		Boolean isBlank = true;
		for (Activity activity : activities) {
			if (_words == null || activity.getName().contains(_words)) {
				activitiesValue.addElement(activity.getName());
				isBlank = false;
			}
		}
		if (!isBlank) {
			associationsView.getActivities().setModel(activitiesValue);
		}

	}
	// 社团列表和活动列表事件响应

	// 事件监听函数
	@Override
	public void valueChanged(ListSelectionEvent e) {

		if (e.getSource().equals(associationsView.getAssociations())) {
			String associationName = (String) ((JList<?>) e.getSource()).getSelectedValue();
			Association association = this.findAAssociationByName(associationName);
			if (association != null) {
				associationsView.getInfoArea().setText(association.getFormatInfo(0));
			}
		} else if (e.getSource().equals(associationsView.getActivities())) {
			String activityName = (String) ((JList<?>) e.getSource()).getSelectedValue();
			Activity activity = this.findActivityByName(activityName);
			if (activity != null) {
				associationsView.getInfoArea().setText(activity.getFormatInfo());
			}
		}
	}

	// 通过社团名称获取社团实例
	private Association findAAssociationByName(String _name) {
		for (Association association : associations) {
			if (association.getName().equals(_name)) {
				return association;
			}
		}
		return null;
	}

	// 通过活动名称获取活动实例
	private Activity findActivityByName(String _name) {
		for (Activity activity : activities) {
			if (activity.getName().equals(_name)) {
				return activity;
			}
		}
		return null;
	}

}
