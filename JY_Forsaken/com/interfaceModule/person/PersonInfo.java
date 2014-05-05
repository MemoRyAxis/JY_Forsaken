package com.interfaceModule.person;

import java.awt.*;
import java.net.*;
import java.awt.event.*;

import javax.swing.*;

public class PersonInfo extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	Container contentPane;
	JPanel centerPanel = new JPanel();
	JPanel upPanel = new JPanel();
	JPanel downPanel = new JPanel();

	// 框架大小
	Dimension faceSize = new Dimension(800, 500);

	// 定义图形界面元素
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();
	JLabel jLabel5 = new JLabel();
	JLabel jLabel6 = new JLabel();
	JLabel jLabel7 = new JLabel();
	JLabel jLabel8 = new JLabel();
	JLabel jLabel9 = new JLabel();

	JTextField jTextField1 = new JTextField(15);
	JTextField jTextField2 = new JTextField(15);
	JTextField jTextField3 = new JTextField(15);
	JTextField jTextField4 = new JTextField(15);
	JTextField jTextField5 = new JTextField(15);
	JTextField jTextField6 = new JTextField(15);
	JTextField jTextField7 = new JTextField(15);
	JTextField jTextField8 = new JTextField(15);
	JTextField jTextField9 = new JTextField(46);

	JButton searchInfo = new JButton();
	JButton addInfo = new JButton();
	JButton modifyInfo = new JButton();
	JButton deleteInfo = new JButton();
	JButton clearInfo = new JButton();
	JButton saveInfo = new JButton();
	JButton exitInfo = new JButton();

	JButton jBSee = new JButton();
	JButton jBSearch = new JButton();
	JButton jBExit = new JButton();
	JButton jBSum = new JButton();
	JButton jBGrade = new JButton();

	GridBagLayout gridBag = new GridBagLayout();
	GridBagConstraints gridBagCon;

	public PersonInfo() {
		// 设置框架大小
		this.setSize(faceSize);
		// 设置标题
		this.setTitle("人员综合信息管理");
		this.setResizable(false);
		// 设置程序图标
		this.setIconImage(getImage("image/smile.png"));
		try {
			Init();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	private void Init() {
		contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		Font font = new Font("Dialog", 0, 12);

		// 中部面板布局
		centerPanel.setLayout(gridBag);

		jLabel1.setText("编          号: ");
		jLabel1.setFont(font);
		gridBagCon = new GridBagConstraints();
		gridBagCon.gridx = 0;
		gridBagCon.gridy = 0;
		gridBagCon.insets = new Insets(10, 10, 10, 1);
		gridBag.setConstraints(jLabel1, gridBagCon);
		centerPanel.add(jLabel1);

		gridBagCon = new GridBagConstraints();
		gridBagCon.gridx = 1;
		gridBagCon.gridy = 0;
		gridBagCon.insets = new Insets(10, 1, 10, 15);
		gridBag.setConstraints(jTextField1, gridBagCon);
		centerPanel.add(jTextField1);

		jLabel2.setText("姓          名: ");
		jLabel2.setFont(font);
		gridBagCon = new GridBagConstraints();
		gridBagCon.gridx = 2;
		gridBagCon.gridy = 0;
		gridBagCon.insets = new Insets(10, 15, 10, 1);
		gridBag.setConstraints(jLabel2, gridBagCon);
		centerPanel.add(jLabel2);

		gridBagCon = new GridBagConstraints();
		gridBagCon.gridx = 3;
		gridBagCon.gridy = 0;
		gridBagCon.insets = new Insets(10, 1, 10, 10);
		gridBag.setConstraints(jTextField2, gridBagCon);
		centerPanel.add(jTextField2);

		jLabel3.setText("性          别: ");
		jLabel3.setFont(font);
		gridBagCon = new GridBagConstraints();
		gridBagCon.gridx = 0;
		gridBagCon.gridy = 1;
		gridBagCon.insets = new Insets(10, 10, 10, 1);
		gridBag.setConstraints(jLabel3, gridBagCon);
		centerPanel.add(jLabel3);

		gridBagCon = new GridBagConstraints();
		gridBagCon.gridx = 1;
		gridBagCon.gridy = 1;
		gridBagCon.insets = new Insets(10, 1, 10, 15);
		gridBag.setConstraints(jTextField3, gridBagCon);
		centerPanel.add(jTextField3);

		jLabel4.setText("部          门: ");
		jLabel4.setFont(font);
		gridBagCon = new GridBagConstraints();
		gridBagCon.gridx = 2;
		gridBagCon.gridy = 1;
		gridBagCon.insets = new Insets(10, 15, 10, 1);
		gridBag.setConstraints(jLabel4, gridBagCon);
		centerPanel.add(jLabel4);

		gridBagCon = new GridBagConstraints();
		gridBagCon.gridx = 3;
		gridBagCon.gridy = 1;
		gridBagCon.insets = new Insets(10, 1, 10, 10);
		gridBag.setConstraints(jTextField4, gridBagCon);
		centerPanel.add(jTextField4);

		jLabel5.setText("职          位: ");
		jLabel5.setFont(font);
		gridBagCon = new GridBagConstraints();
		gridBagCon.gridx = 0;
		gridBagCon.gridy = 2;
		gridBagCon.insets = new Insets(10, 10, 10, 1);
		gridBag.setConstraints(jLabel5, gridBagCon);
		centerPanel.add(jLabel5);

		gridBagCon = new GridBagConstraints();
		gridBagCon.gridx = 1;
		gridBagCon.gridy = 2;
		gridBagCon.insets = new Insets(10, 1, 10, 15);
		gridBag.setConstraints(jTextField5, gridBagCon);
		centerPanel.add(jTextField5);

		jLabel6.setText("其          他: ");
		jLabel6.setFont(font);
		gridBagCon = new GridBagConstraints();
		gridBagCon.gridx = 2;
		gridBagCon.gridy = 2;
		gridBagCon.insets = new Insets(10, 15, 10, 1);
		gridBag.setConstraints(jLabel6, gridBagCon);
		centerPanel.add(jLabel6);

		gridBagCon = new GridBagConstraints();
		gridBagCon.gridx = 3;
		gridBagCon.gridy = 2;
		gridBagCon.insets = new Insets(10, 1, 10, 10);
		gridBag.setConstraints(jTextField6, gridBagCon);
		centerPanel.add(jTextField6);

		contentPane.add(centerPanel, BorderLayout.CENTER);

		jTextField1.setEditable(false);
		jTextField2.setEditable(false);
		jTextField3.setEditable(false);
		jTextField4.setEditable(false);
		jTextField5.setEditable(false);
		jTextField6.setEditable(false);
		jTextField7.setEditable(false);
		jTextField8.setEditable(false);

	}

	/**
	 * 下部面板布局
	 */
	public void downInit() {
		Font font = new Font("Dialog", 0, 12);

		searchInfo.setText("查询");
		searchInfo.setFont(font);
		downPanel.add(searchInfo);
		addInfo.setText("增加");
		addInfo.setFont(font);
		downPanel.add(addInfo);
		modifyInfo.setText("修改");
		modifyInfo.setFont(font);
		downPanel.add(modifyInfo);
		deleteInfo.setText("删除");
		deleteInfo.setFont(font);
		downPanel.add(deleteInfo);
		saveInfo.setText("保存");
		saveInfo.setFont(font);
		downPanel.add(saveInfo);
		clearInfo.setText("清空");
		clearInfo.setFont(font);
		downPanel.add(clearInfo);
		exitInfo.setText("退出");
		exitInfo.setFont(font);
		downPanel.add(exitInfo);

		contentPane.add(downPanel, BorderLayout.SOUTH);

		// 添加事件侦听
		searchInfo.addActionListener(this);
		addInfo.addActionListener(this);
		modifyInfo.addActionListener(this);
		deleteInfo.addActionListener(this);
		saveInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		exitInfo.addActionListener(this);

		modifyInfo.setEnabled(false);
		deleteInfo.setEnabled(false);
		saveInfo.setEnabled(false);
		clearInfo.setEnabled(false);

	}

	private Image getImage(String filename) {
		URLClassLoader urlLoader = (URLClassLoader) this.getClass()
				.getClassLoader();
		URL url = null;
		Image image = null;
		url = urlLoader.findResource(filename);
		image = Toolkit.getDefaultToolkit().getImage(url);
		MediaTracker mediatracker = new MediaTracker(this);
		mediatracker.addImage(image, 0);
		try {
			mediatracker.waitForID(0);
		} catch (InterruptedException e) {
			image = null;
		}
		if (mediatracker.isErrorID(0)) {
			image = null;
		}
		return image;
	}

	/*
	 * 事件处理
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == searchInfo) {// 查询

		} else if (obj == addInfo) {// 增加

		} else if (obj == modifyInfo) {// 修改
		} else if (obj == deleteInfo) {// 删除
		} else if (obj == saveInfo) {// 保存
		} else if (obj == clearInfo) {// 清空

			setNull();
		} else if (obj == exitInfo) {// 退出
			this.dispose();
		}

	}

	/**
	 * 清空文本
	 */
	void setNull() {
		jTextField1.setText(null);
		jTextField2.setText(null);
		jTextField3.setText(null);
		jTextField4.setText(null);
		jTextField5.setText(null);
		jTextField6.setText(null);
		jTextField7.setText(null);
		jTextField8.setText(null);
	}

}
