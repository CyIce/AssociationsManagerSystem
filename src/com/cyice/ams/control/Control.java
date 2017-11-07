package com.cyice.ams.control;

import java.awt.EventQueue;

import com.cyice.ams.view.AssociationsView;

public class Control {

	private AssociationsView associationsView;

	public void initView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AssociationsView frame = new AssociationsView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
