package com.cyice.ams.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class AssociationsView extends JFrame {
	private JTextField associationSearch;
	private JTextField activitySearch;


	/**
	 * Create the frame.
	 */
	public AssociationsView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		getContentPane().setLayout(null);
		
		JScrollPane associationsSP = new JScrollPane();
		associationsSP.setBounds(0, 100, 290, 300);
		getContentPane().add(associationsSP);
		
		JList association = new JList();
		associationsSP.setViewportView(association);
		
		JScrollPane activitiesSP = new JScrollPane();
		activitiesSP.setBounds(592, 100, 290, 300);
		getContentPane().add(activitiesSP);
		
		JList activities = new JList();
		activitiesSP.setViewportView(activities);
		
		associationSearch = new JTextField();
		associationSearch.setBounds(100, 66, 190, 35);
		getContentPane().add(associationSearch);
		associationSearch.setColumns(10);
		
		JLabel associationSearchLabel = new JLabel("    搜索");
		associationSearchLabel.setBounds(0, 66, 85, 35);
		getContentPane().add(associationSearchLabel);
		
		JLabel activitySearchLabel = new JLabel("    搜索");
		activitySearchLabel.setBounds(593, 66, 85, 35);
		getContentPane().add(activitySearchLabel);
		
		activitySearch = new JTextField();
		activitySearch.setBounds(692, 66, 190, 35);
		getContentPane().add(activitySearch);
		activitySearch.setColumns(10);
	}
}
