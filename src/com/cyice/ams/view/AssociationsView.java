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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;

public class AssociationsView extends JFrame{
	private JList<String> associations;
	private JList<String> activities;
	private JTextField associationSearch;
	private JTextField activitySearch;
	private JTextArea infoArea;

	public AssociationsView() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		
		JLabel associationSearchLabel = new JLabel("  搜索  ");
		
		associationSearch = new JTextField();
		associationSearch.setColumns(10);
		
		JScrollPane associationSP = new JScrollPane();
		
		JLabel activitySearchLabel = new JLabel("  搜索。");
		
		activitySearch = new JTextField();
		activitySearch.setColumns(10);
		
		JScrollPane activitySP = new JScrollPane();
		
		JScrollPane infoAreaSP = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(associationSearchLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(associationSearch, GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
						.addComponent(associationSP, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(infoAreaSP, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(activitySearchLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(activitySearch))
						.addComponent(activitySP, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(associationSearchLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(associationSearch, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(activitySearchLabel)
						.addComponent(activitySearch, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(associationSP, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
						.addComponent(infoAreaSP, Alignment.TRAILING)
						.addComponent(activitySP))
					.addContainerGap(224, Short.MAX_VALUE))
		);
		
		infoArea = new JTextArea();
		infoArea.setEditable(false);
		infoAreaSP.setViewportView(infoArea);
		
		activities = new JList();
		activities.setBackground(new Color(0, 255, 255));
		activities.setForeground(new Color(0, 0, 51));
		activities.setFont(new Font("Kokonor", Font.BOLD, 18));
		activitySP.setViewportView(activities);
		
		associations = new JList();
		associations.setBackground(new Color(0, 255, 255));
		associations.setForeground(new Color(0, 0, 51));
		associations.setFont(new Font("Kokonor", Font.BOLD, 18));
		associationSP.setViewportView(associations);
		getContentPane().setLayout(groupLayout);

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
}
