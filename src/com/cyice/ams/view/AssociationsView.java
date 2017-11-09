package com.cyice.ams.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import com.cyice.ams.model.Association;

import java.util.List;

import javax.swing.AbstractListModel;

public class AssociationsView extends JFrame {
	private JTextField associationSearch;
	private JTextField activitySearch;
	private JTextField textField;

	//
	private List<Association> associationsList;

	/**
	 * Create the frame.
	 */
	public AssociationsView(List<Association> _associations) {

		this.associationsList = _associations;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		getContentPane().setLayout(null);

		JScrollPane associationsSP = new JScrollPane();
		associationsSP.setBounds(0, 100, 290, 300);
		getContentPane().add(associationsSP);

		JList associations = new JList();
		
		associationsSP.setViewportView(associations);

		JScrollPane activitiesSP = new JScrollPane();
		activitiesSP.setBounds(592, 100, 290, 300);
		getContentPane().add(activitiesSP);

		JList activities = new JList();
		activitiesSP.setViewportView(activities);

		associationSearch = new JTextField();
		associationSearch.setBounds(100, 66, 190, 35);
		getContentPane().add(associationSearch);
		associationSearch.setColumns(10);

		JLabel associationSearchLabel = new JLabel("        搜索");
		associationSearchLabel.setBounds(0, 66, 85, 35);
		getContentPane().add(associationSearchLabel);

		JLabel activitySearchLabel = new JLabel("        搜索");
		activitySearchLabel.setBounds(593, 66, 85, 35);
		getContentPane().add(activitySearchLabel);

		activitySearch = new JTextField();
		activitySearch.setBounds(692, 66, 190, 35);
		getContentPane().add(activitySearch);
		activitySearch.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(591, 66, -300, 334);
		getContentPane().add(scrollPane);

		textField = new JTextField();
		textField.setBounds(289, 100, 305, 300);
		getContentPane().add(textField);
		textField.setColumns(10);

	}
}
