package com.interfaceModule;

import javax.swing.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.net.*;

import javax.swing.event.*;

import com.dataOperate.TypeBean;

public class TypeInfo extends JFrame implements ActionListener,
		ListSelectionListener {

	Container contentPane;

	JPanel upPanel = new JPanel();

	JPanel centerPanel = new JPanel();

	JPanel downPanel = new JPanel();// 定义所用的面板

	Dimension faceSize = new Dimension(400, 400);// 定义框架大小

	JLabel jLable1 = new JLabel();

	JLabel jLable2 = new JLabel();

	JLabel jLable3 = new JLabel();

	JTextField jTextField1 = new JTextField(15);

	JTextField jTextfield2 = new JTextField(15);

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

	private void Init() {
		// TODO 自动生成方法存根
		contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());

		TypeBean bean = new TypeBean();
		colValue = bean.searchAll();
		jTable = new JTable(colValue, colName);
		jTable.setPreferredScrollableViewportSize(new Dimension(400, 300));
		listSelectionModel = jTable.getSelectionModel();
		listSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSelectionModel.addListSelectionListener(this);
		jScrollPane1 = new JScrollPane(jTable);
		jScrollPane1.setPreferredSize(new Dimension(400, 300));

		upPanel.add(jScrollPane1);

	}

	Image getImage(String filename) {
		// TODO 自动生成方法存根
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
			// TODO 自动生成 catch 块
			image = null;
		}
		if (mediatracker.isErrorID(0)) {
			image = null;
		}
		return image;
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO 自动生成方法存根

	}

	public void valueChanged(ListSelectionEvent arg0) {
		// TODO 自动生成方法存根

	}

}
