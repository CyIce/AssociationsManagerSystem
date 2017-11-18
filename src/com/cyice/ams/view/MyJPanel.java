package com.cyice.ams.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class MyJPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image backgroundImage;
	private boolean backResize;

	/**
	 * 构造方法
	 * 
	 * @param arg0
	 *            背景图片 Image 类
	 * @param arg1
	 *            背景图片是否根据Panel大小自行缩放
	 */
	public MyJPanel(Image arg0, boolean arg1) {
		backgroundImage = arg0;
		backResize = arg1;
	}

	protected void paintComponent(Graphics g) {
		if (backgroundImage != null) {
			if (backResize) {
				g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
			} else {
				g.drawImage(backgroundImage, (getWidth() - backgroundImage.getWidth(null)) / 2,
						(getHeight() - backgroundImage.getHeight(null)) / 2, null);
			}
		}
	}

	public void setIBackgroundImage(Image backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

}
