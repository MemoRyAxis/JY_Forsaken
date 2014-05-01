package com.interfaceModule.sysMod;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.net.*;

import javax.swing.event.*;

import com.dataOperate.TypeBean;

public class TypeInfo extends JFrame implements ActionListener,
		ListSelectionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Container contentPane;

	JPanel upPanel = new JPanel();

	JPanel centerPanel = new JPanel();

	JPanel downPanel = new JPanel();// 定义所用的面板

	Dimension faceSize = new Dimension(400, 400);// 定义框架大小

	JLabel jLable1 = new JLabel();

	JLabel jLable2 = new JLabel();

	JLabel jLable3 = new JLabel();

	JTextField jTextField1 = new JTextField(15);

	JTextField jTextField2 = new JTextField(15);

	JTextField jTextField3 = new JTextField(15);

	JButton searchInfo = new JButton();

	JButton addInfo = new JButton();

	JButton modifyInfo = new JButton();

	JButton deleteInfo = new JButton();

	JButton clearInfo = new JButton();

	JButton saveInfo = new JButton();

	JButton exitInfo = new JButton();// 定义图形界面元素

	JScrollPane jScrollPane1;

	JTable jTable;

	ListSelectionModel listSelectionModel = null;

	String[] colName = { "设备编号", "所属机房", "管理人员" };

	String[][] colValue;// 定义表格

	GridBagLayout girdBag = new GridBagLayout();

	GridBagConstraints girdBagCon;

	public TypeInfo() {
		this.setSize(faceSize);// 设置框架大小
		this.setTitle("设备分配信息");// 设置标题
		this.setResizable(true);
		this.setIconImage(getImage("image/android.png"));// 设置程序图标

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - 400) / 2,
				(screenSize.height - 300) / 2 + 45);
		try {
			Init();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void Init() throws Exception {
		contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		Font font = new Font("Dialog", 0, 12);// 设置字体

		//中部面板布局
		TypeBean bean = new TypeBean();
		try {
			colValue = bean.searchAll();
			jTable = new JTable(colValue, colName);
			jTable.setPreferredScrollableViewportSize(new Dimension(400, 300));
			listSelectionModel = jTable.getSelectionModel();
			listSelectionModel
					.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listSelectionModel.addListSelectionListener(this);
			jScrollPane1 = new JScrollPane(jTable);
			jScrollPane1.setPreferredSize(new Dimension(400, 300));
		} catch (Exception e) {
			e.printStackTrace();
		}
		upPanel.add(jScrollPane1);
		contentPane.add(upPanel, BorderLayout.NORTH);

		jLable1.setText("编号");
		jLable1.setFont(font);
		centerPanel.add(jLable1);
		centerPanel.add(jTextField1);

		jLable2.setText("所属机房");
		jLable2.setFont(font);
		centerPanel.add(jLable2);
		centerPanel.add(jTextField2);

		jLable3.setText("管理人员");
		jLable3.setFont(font);
		centerPanel.add(jLable3);
		centerPanel.add(jTextField3);
		contentPane.add(centerPanel, BorderLayout.CENTER);

		jTextField1.setEditable(false);
		jTextField2.setEditable(false);
		jTextField3.setEditable(false);

	}

	/**
	 * 下部面板的布局
	 */
	public void downInit() {
		Font font = new Font("Dialog", 0, 12);// 设置字体
		searchInfo.setText("获取新的编号");
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
		clearInfo.addActionListener(this);
		exitInfo.addActionListener(this);

		searchInfo.setEnabled(true);
		addInfo.setEnabled(false);
		modifyInfo.setEnabled(false);
		deleteInfo.setEnabled(false);
		clearInfo.setEnabled(true);

	}

	Image getImage(String filename) {
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
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == searchInfo) {// 获取新编号
			setNull();
			TypeBean bean = new TypeBean();
			jTextField1.setText("" + bean.getId());
			jTextField2.setEditable(true);
			jTextField3.setEditable(true);

			addInfo.setEnabled(true);
			modifyInfo.setEnabled(true);
			deleteInfo.setEnabled(true);

		} else if (obj == addInfo) {// 增加
			TypeBean bean = new TypeBean();
			bean.add(jTextField1.getText(), jTextField2.getText(),
					jTextField3.getText());
			this.dispose();

			TypeInfo typeMan = new TypeInfo();
			typeMan.downInit();
			typeMan.pack();
			typeMan.setVisible(true);

		} else if (obj == modifyInfo) {// 修改
			TypeBean bean = new TypeBean();
			bean.modify(jTextField1.getText(), jTextField2.getText(),
					jTextField3.getText());
			this.dispose();

			TypeInfo typeMan = new TypeInfo();
			typeMan.downInit();
			typeMan.pack();
			typeMan.setVisible(true);
		} else if (obj == deleteInfo) {// 删除
			TypeBean bean = new TypeBean();
			bean.delete(jTextField1.getText());
			this.dispose();

			TypeInfo typeMan = new TypeInfo();
			typeMan.downInit();
			typeMan.pack();
			typeMan.setVisible(true);
		} else if (obj == clearInfo) {// 清空
			setNull();
		} else if (obj == exitInfo) {// 退出
			this.dispose();
		}
		jTable.revalidate();

	}

	/**
	 * 清空文本方法
	 */
	private void setNull() {
		jTextField1.setText(null);
		jTextField2.setText(null);
		jTextField3.setText(null);
		jTextField2.setEditable(false);
		jTextField3.setEditable(false);
		searchInfo.setEnabled(true);
		addInfo.setEnabled(false);
		modifyInfo.setEnabled(false);
		deleteInfo.setEnabled(false);
		clearInfo.setEnabled(true);

	}

	/*
	 * 当表格被选中的时的操作
	 */
	public void valueChanged(ListSelectionEvent lse) {
		int[] selectedRow = jTable.getSelectedRows();
		int[] selectedCol = jTable.getSelectedColumns();
		// 定义文本显示内容

		for (int i = 0; i < selectedRow.length; i++) {
			for (int j = 0; j < selectedCol.length; j++) {
				jTextField1.setText(colValue[selectedRow[i]][0]);
				jTextField2.setText(colValue[selectedRow[i]][1]);
				jTextField3.setText(colValue[selectedRow[i]][2]);
			}
		}

		// 设置是否可操作
		jTextField2.setEditable(true);
		jTextField3.setEditable(true);
		searchInfo.setEnabled(true);
		addInfo.setEnabled(false);
		modifyInfo.setEnabled(true);
		deleteInfo.setEnabled(true);
		clearInfo.setEnabled(true);

	}

}
