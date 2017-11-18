package com.cyice.ams.control;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.jar.JarFile;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.cyice.ams.model.Activity;
import com.cyice.ams.model.Association;
import com.cyice.ams.model.FileInput;
import com.cyice.ams.util.ColorAnalysis;
import com.cyice.ams.view.AssociationsView;

public class Control implements ListSelectionListener, MouseListener {

	// 社团介绍实图实例
	private AssociationsView associationsView;
	// 社团实例
	private List<Association> associations = new ArrayList<>();
	// 活动实例
	private List<Activity> activities = new ArrayList<>();
	// 判断当前操作的身份
	private boolean isController = false;
	// 管理员密码
	private String passwords = "123456";
	// 记录最后一次操作的时间
	private Date date = new Date();
	// 判断是否处于展示阶段
	private boolean isShowStatus = false;
	// 判断是否处于管理员输入阶段
	private boolean isEnterPassWords = false;
	// 存储用于展示的图片URL
	private Queue<String> associationImagesUrl = new LinkedList<>();
	// 一个社团用于展示的图片数量
	private int imagesCount = 2;
	// 展示照片切换时间间隔
	private int imageSwitshTime = 10000;
	// 储存用于展示的照片的主颜色
	private Map<String, Color> imageColors = new HashMap<>();

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
					initSortListener();
					initButtonListener();
					initBackgroundPanelListener();
					initInfoArea();
					updateAssociationsList(null);
					updateActivitiesList(null);
					changeBackGroundImage("街舞社");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		/*
		 * EventQueue.invokeLater(new Runnable() { public void run() { try {
		 * parseImagesColor(); } catch (Exception e) { e.printStackTrace(); } } });
		 */

		// 检测是否有用户操作
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				showImages();
			}
		}, 1000, 1000);
	}

	// 绑定列表事件监听函数
	private void initSelectetionListener() {
		associationsView.getAssociations().addListSelectionListener(this);
		associationsView.getActivities().addListSelectionListener(this);
	}

	// 绑定信息面板的点击事件
	private void initInfoArea() {
		associationsView.getInfoArea().addMouseListener(this);
	}

	// 绑定背景面板的事件监听函数
	private void initBackgroundPanelListener() {
		associationsView.getBackgroundPanel().addMouseListener(this);
	}

	// 绑定按键事件监听函数
	private void initButtonListener() {
		associationsView.getIdentity().addMouseListener(this);
		associationsView.getAssociationSearch().addMouseListener(this);
		associationsView.getActivitySearch().addMouseListener(this);
	}

	// 绑定排序按钮的事件监听函数
	private void initSortListener() {
		associationsView.getAssociationsSort().addMouseListener(this);
		associationsView.getActivitiesSort().addMouseListener(this);
	}

	// 最大化窗口
	private void maxFrame() {
		if (associationsView.isUndecorated()) {
			associationsView.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
		} else {
			associationsView.setExtendedState(associationsView.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		}
	}

	// 展示社团照片
	private void showImages() {

		Date nowDate = new Date();
		long disTime = nowDate.getTime() - date.getTime();
		// 判断是否满足切换界面的条件
		if (!isShowStatus && disTime > 5000 && !isEnterPassWords && !isController) {
			changeAllComponentsVisible(false);
			isShowStatus = true;
			maxFrame();
		}
		if (disTime > imageSwitshTime) {
			date = nowDate;
			if (associationImagesUrl.size() == 0) {
				getAssociationImageUrl();
			}
			associationsView.getBackgroundPanel()
					.setBackgroundImage(new ImageIcon(associationImagesUrl.poll()).getImage());
			associationsView.repaint();
		}
	}

	// 社团列表和活动列表搜索事件监听和响应
	private void initTextFieldListener() {

		associationsView.getAssociationSearch().getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				updateAssociationsList(associationsView.getAssociationSearch().getText());
				updaDate();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				updateAssociationsList(associationsView.getAssociationSearch().getText());
				updaDate();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				System.out.println("aa");
			}
		});
		associationsView.getActivitySearch().getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				updateActivitiesList(associationsView.getActivitySearch().getText());
				updaDate();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				updateActivitiesList(associationsView.getActivitySearch().getText());
				updaDate();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
	}

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

	// 获取用于展示的图片的主颜色
	private void parseImagesColor() {
		List<String> associationsName = new ArrayList<>();
		for (Association association : associations) {
			associationsName.add(association.getName());
		}
		for (String name : associationsName) {
			for (int i = 1; i <= imagesCount; i++) {
				String url = "file/images/" + name + i + ".jpg";
				Color color = ColorAnalysis.getImagePixel(url);
				imageColors.put(name + "i", color);
			}
		}
	}

	// 初始化活动实例
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

	// 更新社团列表内容，实现搜索功能
	private void updateAssociationsList(String _words) {
		DefaultListModel<String> associationsValue = new DefaultListModel<>();
		Boolean isBlank = true;
		for (Association association : associations) {
			if (_words == null || association.getName().contains(_words)
					|| association.getActivities().contains(_words)) {
				associationsValue.addElement(association.getName());
				isBlank = false;
			}
		}
		if (!isBlank) {
			associationsView.getAssociations().setModel(associationsValue);
		}
	}

	// 更新活动列表内容，实现搜索功能
	private void updateActivitiesList(String _words) {
		DefaultListModel<String> activitiesValue = new DefaultListModel<>();
		Boolean isBlank = true;
		for (Activity activity : activities) {
			if (_words == null || activity.getName().contains(_words) || activity.getAssociations().contains(_words)) {
				activitiesValue.addElement(activity.getName());
				isBlank = false;
			}
		}
		if (!isBlank) {
			associationsView.getActivities().setModel(activitiesValue);
		}

	}

	// 事件监听函数
	@Override
	public void valueChanged(ListSelectionEvent e) {

		updaDate();

		if (!e.getValueIsAdjusting()) {
			if (e.getSource().equals(associationsView.getAssociations())) {
				String associationName = (String) ((JList<?>) e.getSource()).getSelectedValue();
				Association association = this.findAssociationByName(associationName);
				if (association != null) {
					changeBackGroundImage(associationName);
					associationsView.getInfoArea().setText(association.getFormatInfo(this.isController));
				}
			} else if (e.getSource().equals(associationsView.getActivities())) {
				String activityName = (String) ((JList<?>) e.getSource()).getSelectedValue();
				Activity activity = this.findActivityByName(activityName);
				if (activity != null) {
					associationsView.getInfoArea().setText(activity.getFormatInfo(this.isController));
				}
			}
		}

	}

	// 通过社团名称获取社团实例
	private Association findAssociationByName(String _name) {
		for (Association association : associations) {
			if (association.getName().equals(_name)) {
				return association;
			}
		}
		return null;
	}

	// 切换界面背景图片各个窗体的背景色
	private void changeBackGroundImage(String imageName) {
		Random random = new Random();
		int tag = random.nextInt(imagesCount) + 1;
		String imageNameWithTag = imageName + "tag";
		Color color;
		if (imageColors.get(imageNameWithTag) == null) {
			String url = "file/images/" + imageName + tag + ".jpg";
			associationsView.getBackgroundPanel().setBackgroundImage(new ImageIcon(url).getImage());
			color = ColorAnalysis.getImagePixel(url);
			imageColors.put(imageNameWithTag, color);
		} else {
			color = imageColors.get(imageNameWithTag);
		}

		associationsView.getAssociations().setBackground(color);
		associationsView.getActivities().setBackground(color);
		associationsView.getInfoArea().setBackground(color);
		associationsView.repaint();

	}

	// 更新事时间
	private void updaDate() {
		date = new Date();
	}

	//
	private void getAssociationImageUrl() {
		List<String> associationsName = new ArrayList<>();
		for (Association association : associations) {
			associationsName.add(association.getName());
		}
		// 按社团拼音首字母排序
		Comparator<Object> comparatorByName = Collator.getInstance(java.util.Locale.CHINA);
		Collections.sort(associationsName, comparatorByName);

		Random random = new Random();
		for (String name : associationsName) {
			for (int i = 0; i < 2; i++) {
				int tag = random.nextInt(imagesCount) + 1;
				String url = "file/images/" + name + tag + ".jpg";
				associationImagesUrl.offer(url);
			}
		}

	}

	// 隐藏所有控件
	private void changeAllComponentsVisible(boolean visibel) {
		associationsView.getAssociationsListSP().setVisible(visibel);
		associationsView.getActivitiesListSP().setVisible(visibel);
		associationsView.getInfoAreaSP().setVisible(visibel);
		associationsView.getAssociationSearch().setVisible(visibel);
		associationsView.getActivitySearch().setVisible(visibel);
		associationsView.getAssociationSearchLabel().setVisible(visibel);
		associationsView.getActivitySearchLabel().setVisible(visibel);
		associationsView.getAssociationsSort().setVisible(visibel);
		associationsView.getActivitiesSort().setVisible(visibel);
		associationsView.getIdentityPanel().setVisible(visibel);
	}

	// 修改排序按钮的可见性
	private void changeVisibleOfSort(boolean visible) {
		associationsView.getAssociationsSort().setVisible(visible);
		associationsView.getActivitiesSort().setVisible(visible);
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

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {

		updaDate();
		// 列表排序及打乱
		if (e.getSource().equals(associationsView.getAssociationsSort())) {

			if (associationsView.getAssociationsSort().isSelected()) {
				Collections.sort(associations);
			} else {
				Collections.shuffle(associations);
			}
			updateAssociationsList(associationsView.getAssociationSearch().getText());
		} else if (e.getSource().equals(associationsView.getActivitiesSort())) {
			if (associationsView.getActivitiesSort().isSelected()) {
				Collections.sort(activities);
			} else {
				Collections.shuffle(activities);
			}
			updateActivitiesList(associationsView.getActivitySearch().getText());
		}
		// 切换界面
		if (e.getSource().equals(associationsView.getBackgroundPanel())) {
			if (isShowStatus) {
				changeAllComponentsVisible(true);
				isShowStatus = false;
				date = new Date();
			}
		}

		// 身份切换按键事件
		if (e.getSource().equals(associationsView.getIdentity())) {
			String words = "";
			if (isController == false) {
				isEnterPassWords = true;
				do {
					words = JOptionPane.showInputDialog(null, "请输入管理员密码 ！", "输入密码");
				} while (!passwords.equals(words) && words != null);
				isEnterPassWords = false;
			}

			if (passwords.equals(words) || isController == true) {
				isController = isController == false ? true : false;
				String identity = isController == false ? "学生" : "管理员";
				associationsView.getIdentity().setText(identity);
				this.changeVisibleOfSort(isController);
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}
