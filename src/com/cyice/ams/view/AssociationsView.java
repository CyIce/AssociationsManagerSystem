package com.cyice.ams.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SortingFocusTraversalPolicy;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import com.cyice.ams.model.Association;

import java.util.List;
import javax.print.attribute.standard.MediaSize.Engineering;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;
import java.awt.Color;

public class AssociationsView extends JFrame implements ListSelectionListener {

	// 社团和活动的JList
	private JList<String> associations;
	private JList<String> activities;
	// 社团和活动的信息
	private JTextField infoArea;
	//用于判断鼠标是否点击社团或活动
	private boolean isClickAssociation=false;
	private boolean isClickActivity=false;
	//储存点击的社团名或活动名
	private String clickedAssociation;
	private String clickedActivity;

	public AssociationsView() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		getContentPane().setLayout(null);

		JScrollPane associationsSP = new JScrollPane();
		associationsSP.setBounds(0, 100, 290, 300);
		getContentPane().add(associationsSP);

		associations = new JList<String>();
		associations.addListSelectionListener(this);
		associations.setBackground(new Color(176, 224, 230));
		associations.setFont(new Font("Kokonor", Font.PLAIN, 18));
		associationsSP.setViewportView(associations);

		JScrollPane activitiesSP = new JScrollPane();
		activitiesSP.setBounds(592, 100, 290, 300);
		getContentPane().add(activitiesSP);

		activities = new JList<String>();
		activities.addListSelectionListener(this);
		activities.setBackground(new Color(176, 224, 230));
		activities.setFont(new Font("Kokonor", Font.PLAIN, 18));
		activitiesSP.setViewportView(activities);

		JTextField associationSearch = new JTextField();
		associationSearch.setBounds(100, 66, 190, 35);
		getContentPane().add(associationSearch);
		associationSearch.setColumns(10);

		JLabel associationSearchLabel = new JLabel("        搜索");
		associationSearchLabel.setBounds(0, 66, 85, 35);
		getContentPane().add(associationSearchLabel);

		JLabel activitySearchLabel = new JLabel("        搜索");
		activitySearchLabel.setBounds(593, 66, 85, 35);
		getContentPane().add(activitySearchLabel);

		JTextField activitySearch = new JTextField();
		activitySearch.setBounds(692, 66, 190, 35);
		getContentPane().add(activitySearch);
		activitySearch.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(591, 66, -300, 334);
		getContentPane().add(scrollPane);

		infoArea = new JTextField();
		infoArea.setBounds(289, 100, 305, 300);
		getContentPane().add(infoArea);
		infoArea.setColumns(10);

	}

	public JList<String> getAssociations() {
		return associations;
	}

	public JList<String> getActivities() {
		return activities;
	}

	public JTextField getInfoArea() {
		return infoArea;
	}

	public boolean isClickAssociation() {
		return isClickAssociation;
	}

	public boolean isClickActivity() {
		return isClickActivity;
	}

	public String getClickedAssociation() {
		return clickedAssociation;
	}

	public String getClickedActivity() {
		return clickedActivity;
	}

	//事件监听函数
	@Override
	public void valueChanged(ListSelectionEvent e) {

		if(e.getSource().equals(associations)) {
			System.out.println(((JList<?>)e.getSource()).getSelectedValue());
		}else if(e.getSource().equals(activities)) {
			System.out.println(((JList<?>)e.getSource()).getSelectedValue());
		}
	}
	
	
}
