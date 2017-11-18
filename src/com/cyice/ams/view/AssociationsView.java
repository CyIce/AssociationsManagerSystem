package com.cyice.ams.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AssociationsView extends JFrame {
	private JTextField associationSearch;
	private JTextField activitySearch;
	private JScrollPane associationsListSP;
	private JList<String> associations;
	private JTextArea infoArea;
	private JScrollPane infoAreaSP;
	private JList<String> activities;
	private JCheckBox associationsSort;
	private JCheckBox activitiesSort;
	private JPanel identityPanel;
	private JButton identity;
	private MyJPanel backgroundPanel;
	private JLabel associationSearchLabel;
	private JLabel activitySearchLabel;
	private JScrollPane activitiesListSP;

	public AssociationsView() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);

		backgroundPanel = new MyJPanel(null, true);
		backgroundPanel.setOpaque(false);

		GroupLayout groupLayout = new GroupLayout(getContentPane());

		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(backgroundPanel,
				GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(backgroundPanel,
				GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE));

		associationSearchLabel = new JLabel("搜索");

		associationSearch = new JTextField();
		associationSearch.setColumns(10);

		activitySearchLabel = new JLabel("   搜索");

		activitySearch = new JTextField();
		activitySearch.setColumns(10);

		associationsListSP = new JScrollPane();

		activitiesListSP = new JScrollPane();

		infoAreaSP = new JScrollPane();

		associationsSort = new JCheckBox("S");
		associationsSort.setVisible(false);

		activitiesSort = new JCheckBox("S");
		activitiesSort.setVisible(false);

		infoArea = new JTextArea();
		infoArea.setForeground(Color.BLACK);
		infoArea.setFont(new Font("Mshtakan", Font.PLAIN, 20));
		infoArea.setEditable(false);
		infoAreaSP.setViewportView(infoArea);

		activities = new JList<String>();
		activities.setFont(new Font("Kokonor", Font.PLAIN, 16));
		activitiesListSP.setViewportView(activities);

		associations = new JList<String>();
		associations.setFont(new Font("Kokonor", Font.PLAIN, 16));
		associationsListSP.setViewportView(associations);

		identityPanel = new JPanel();
		identityPanel.setOpaque(false);

		GroupLayout gl_background = new GroupLayout(backgroundPanel);
		gl_background.setHorizontalGroup(gl_background.createParallelGroup(Alignment.LEADING).addGroup(gl_background
				.createSequentialGroup()
				.addGroup(gl_background.createParallelGroup(Alignment.LEADING).addGroup(gl_background
						.createSequentialGroup()
						.addGroup(gl_background.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_background.createSequentialGroup().addGap(6).addComponent(
										associationsListSP, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
								.addGroup(gl_background.createSequentialGroup().addGap(18)
										.addComponent(associationSearchLabel, GroupLayout.PREFERRED_SIZE, 42,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(associationSearch,
												GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)))
						.addGap(6)
						.addGroup(gl_background.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_background.createSequentialGroup()
										.addComponent(associationsSort, GroupLayout.PREFERRED_SIZE, 39,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 364, Short.MAX_VALUE)
										.addComponent(activitiesSort, GroupLayout.PREFERRED_SIZE, 39,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(infoAreaSP, GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE))
						.addGap(6)
						.addGroup(gl_background.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_background.createSequentialGroup()
										.addComponent(activitySearch, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(activitySearchLabel,
												GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
								.addComponent(activitiesListSP, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 220,
										Short.MAX_VALUE)))
						.addGroup(gl_background.createSequentialGroup().addContainerGap().addComponent(identityPanel,
								GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)))
				.addContainerGap()));
		gl_background.setVerticalGroup(gl_background.createParallelGroup(Alignment.TRAILING).addGroup(gl_background
				.createSequentialGroup()
				.addComponent(identityPanel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE).addGap(4)
				.addGroup(gl_background.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_background.createSequentialGroup().addGap(2).addComponent(associationSearchLabel,
								GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_background.createParallelGroup(Alignment.BASELINE)
								.addComponent(associationSearch, GroupLayout.PREFERRED_SIZE, 39,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(associationsSort))
						.addGroup(gl_background.createParallelGroup(Alignment.BASELINE)
								.addComponent(activitySearchLabel, GroupLayout.PREFERRED_SIZE, 34,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(activitySearch, GroupLayout.PREFERRED_SIZE, 38,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(activitiesSort)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_background.createParallelGroup(Alignment.LEADING)
						.addComponent(associationsListSP, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
						.addComponent(infoAreaSP, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
						.addComponent(activitiesListSP, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE))
				.addGap(174)));

		identity = new JButton("学生");

		identityPanel.add(identity);
		backgroundPanel.setLayout(gl_background);
		getContentPane().setLayout(groupLayout);

	}

	public JScrollPane getActivitiesListSP() {
		return activitiesListSP;
	}

	public JLabel getAssociationSearchLabel() {
		return associationSearchLabel;
	}

	public JLabel getActivitySearchLabel() {
		return activitySearchLabel;
	}

	public JScrollPane getAssociationsListSP() {
		return associationsListSP;
	}

	public JScrollPane getInfoAreaSP() {
		return infoAreaSP;
	}

	public JPanel getIdentityPanel() {
		return identityPanel;
	}

	public JButton getIdentity() {
		return identity;
	}

	public JCheckBox getAssociationsSort() {
		return associationsSort;
	}

	public JCheckBox getActivitiesSort() {
		return activitiesSort;
	}

	public JList<String> getAssociations() {
		return associations;
	}

	public JList<String> getActivities() {
		return activities;
	}

	public JTextArea getInfoArea() {
		return infoArea;
	}

	public JTextField getAssociationSearch() {
		return associationSearch;
	}

	public JTextField getActivitySearch() {
		return activitySearch;
	}

	public MyJPanel getBackgroundPanel() {
		return backgroundPanel;
	}

}
