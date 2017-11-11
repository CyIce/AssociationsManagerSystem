package com.cyice.ams.control;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.cyice.ams.model.Association;
import com.cyice.ams.model.FileInput;
import com.cyice.ams.view.AssociationsView;

public class Control implements ListSelectionListener {

	// 社团介绍实图实例
	private AssociationsView associationsView;
	// 社团实例
	private List<Association> associations = new ArrayList<>();

	public void initView() {

		initAssociations();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					associationsView = new AssociationsView();
					associationsView.setVisible(true);
					initSelectetionListener();
					initJList();
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

	// 初始化社团实例
	private void initAssociations() {
		List<String> strings = FileInput.readFile("社团表");
		for (String s : strings) {
			if (s.length() < 8) {
				continue;
			}
			String[] line = s.split(",");

			associations.add(new Association(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7]));
		}
	}

	// 初始化社团和活动列表
	private void initJList() {
		DefaultListModel<String> associationsValue = new DefaultListModel<>();
		DefaultListModel<String> activitiesValue = new DefaultListModel<>();
		for (Association association : associations) {
			associationsValue.addElement(association.getName());
			activitiesValue.addElement(association.getActivities());
		}
		associationsView.getAssociations().setModel(associationsValue);
		associationsView.getActivities().setModel(activitiesValue);

	}

	public List<Association> getAssociations() {
		return associations;
	}

	// 事件监听函数
	@Override
	public void valueChanged(ListSelectionEvent e) {

		if (e.getSource().equals(associationsView.getAssociations())) {
			associationsView.getAssociationSearch().setText((String) ((JList<?>) e.getSource()).getSelectedValue());

		} else if (e.getSource().equals(associationsView.getActivities())) {
			associationsView.getActivitySearch().setText((String) ((JList<?>) e.getSource()).getSelectedValue());
		}
	}
}
