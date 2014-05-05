package com.mainInterface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.*;

import javax.swing.*;

import com.interfaceModule.assetsInfo.*;
import com.interfaceModule.person.AddPerson;
import com.interfaceModule.person.DeletePerson;
import com.interfaceModule.person.ModifyPerson;
import com.interfaceModule.sysMod.*;
import com.interfaceModule.use.BackAssets;
import com.interfaceModule.use.InvalidAssets;
import com.interfaceModule.use.UseAssets;

public class EquipmentMain extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Dimension faceSize = new Dimension(600, 450);// 设置框架的大小

	Image icon;// 程序图标

	JMenuBar mainMenu = new JMenuBar();// 建立菜单栏

	JMenu menuSystem = new JMenu();

	JMenuItem itemTypeMan = new JMenuItem();

	JMenuItem itemExit = new JMenuItem();// 建立“系统管理”菜单组

	JMenu menuEquipment = new JMenu();

	JMenuItem itemAddEquipment = new JMenuItem();

	JMenuItem itemModifyEquipment = new JMenuItem();

	JMenuItem itemDeleteEquipment = new JMenuItem();

	JMenu itemSelectEquipment = new JMenu();

	JMenuItem itemSelectEquipmentAll = new JMenuItem();

	JMenuItem itemSelectEquipmentID = new JMenuItem();// 建立“设备信息管理”菜单组

	JMenu menuPerson = new JMenu();

	JMenuItem itemAddPerson = new JMenuItem();

	JMenuItem itemModifyPerson = new JMenuItem();

	JMenuItem itemDeletePerson = new JMenuItem();

	JMenu itemSelectPerson = new JMenu();

	JMenuItem itemSelectPersonAll = new JMenuItem();

	JMenuItem itemSelectPersonID = new JMenuItem();// 建立“人员信息管理”菜单组

	JMenu menuUsing = new JMenu();

	JMenuItem itemUsing = new JMenuItem();

	JMenuItem itemSelectUsing = new JMenuItem();// 建立“设备领用”菜单组

	JMenu menuBack = new JMenu();

	JMenuItem itemBack = new JMenuItem();

	JMenuItem itemSelectBack = new JMenuItem();// 建立“设备归还”菜单组

	JMenu menuInvalid = new JMenu();

	JMenuItem itemInvalid = new JMenuItem();

	JMenuItem itemSelectInvalid = new JMenuItem();// 建立“设备报废”菜单组

	/**
	 * 构造函数，初始化程序
	 */
	public EquipmentMain() {
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 添加管家的事件关闭处理
		this.pack();
		this.setSize(faceSize);// 设置框架大小
		this.setTitle("Forsaken的计算机设备管理系统");// 添加标题
		icon = getImage("image/icon.png");
		this.setIconImage(icon);// 设置程序图标
		try {
			Init();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	/**
	 * 菜单组件程序初始化
	 */
	private void Init() {
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());

		Font font = new Font("Dialog", 0, 12);
		menuSystem.setText("系统管理");
		menuSystem.setFont(font);
		menuEquipment.setText("设备信息管理");
		menuEquipment.setFont(font);
		menuPerson.setText("人员信息管理");
		menuPerson.setFont(font);
		menuUsing.setText("设备领用");
		menuUsing.setFont(font);
		menuBack.setText("设备归还");
		menuBack.setFont(font);
		menuInvalid.setText("设备报废");
		menuInvalid.setFont(font);// 添加菜单组件

		itemTypeMan.setText("设备分配信息");
		itemTypeMan.setFont(font);
		itemExit.setText("退出");
		itemExit.setFont(font);// 生成“系统管理”菜单组件

		itemAddEquipment.setText("增加");
		itemAddEquipment.setFont(font);
		itemModifyEquipment.setText("修改");
		itemModifyEquipment.setFont(font);
		itemDeleteEquipment.setText("删除");
		itemDeleteEquipment.setFont(font);
		itemSelectEquipment.setText("查询");
		itemSelectEquipment.setFont(font);
		itemSelectEquipmentAll.setText("查询所有");
		itemSelectEquipmentAll.setFont(font);
		itemSelectEquipmentID.setText("按编号查询");
		itemSelectEquipmentID.setFont(font);// 生成“设备信息管理”菜单

		itemAddPerson.setText("人员信息添加");
		itemAddPerson.setFont(font);
		itemModifyPerson.setText("人员信息修改");
		itemModifyPerson.setFont(font);
		itemDeletePerson.setText("人员信息删除");
		itemDeletePerson.setFont(font);
		itemSelectPerson.setText("人员信息查询");
		itemSelectPerson.setFont(font);
		itemSelectPersonAll.setText("查询所有");
		itemSelectPersonAll.setFont(font);
		itemSelectPersonID.setText("按编号查询");
		itemSelectPersonID.setFont(font);// 生成“人员信息管理”菜单

		itemUsing.setText("设备领用管理");
		itemUsing.setFont(font);
		itemSelectUsing.setText("领用信息查询");
		itemSelectUsing.setFont(font);// 生成“设备领用”菜单

		itemBack.setText("设备归还管理");
		itemBack.setFont(font);
		itemSelectBack.setText("设备归还查询");
		itemSelectBack.setFont(font);// 生成“设备归还”菜单

		itemInvalid.setText("设备报废管理");
		itemInvalid.setFont(font);
		itemSelectInvalid.setText("报废信息查询");
		itemSelectInvalid.setFont(font);// 生成“设备报废”菜单

		menuSystem.add(itemTypeMan);
		menuSystem.add(itemExit);// 添加“系统管理”菜单组

		menuEquipment.add(itemAddEquipment);
		menuEquipment.add(itemModifyEquipment);
		menuEquipment.add(itemDeleteEquipment);
		menuEquipment.addSeparator();
		menuEquipment.add(itemSelectEquipment);
		itemSelectEquipment.add(itemSelectEquipmentAll);
		itemSelectEquipment.add(itemSelectEquipmentID);// 添加“设备信息管理”菜单组

		menuPerson.add(itemAddPerson);
		menuPerson.add(itemModifyPerson);
		menuPerson.add(itemDeletePerson);
		menuPerson.addSeparator();// 分离器
		menuPerson.add(itemSelectPerson);
		itemSelectPerson.add(itemSelectPersonAll);
		itemSelectPerson.add(itemSelectPersonID);// 添加“人员信息管理”菜单组

		menuUsing.add(itemUsing);
		menuUsing.add(itemSelectUsing);// 添加“设备领用”菜单组

		menuBack.add(itemBack);
		menuBack.add(itemSelectBack);// 添加“设备归还”菜单组

		menuInvalid.add(itemInvalid);
		menuInvalid.add(itemSelectInvalid);// 添加“设备报废”菜单组

		mainMenu.add(menuSystem);
		mainMenu.add(menuEquipment);
		mainMenu.add(menuPerson);
		mainMenu.add(menuUsing);
		mainMenu.add(menuBack);
		mainMenu.add(menuInvalid);
		this.setJMenuBar(mainMenu);// 添加所有的菜单组

		itemTypeMan.addActionListener(this);
		itemExit.addActionListener(this);
		itemAddEquipment.addActionListener(this);
		itemModifyEquipment.addActionListener(this);
		itemDeleteEquipment.addActionListener(this);
		itemSelectEquipmentAll.addActionListener(this);
		itemSelectEquipmentID.addActionListener(this);
		itemAddPerson.addActionListener(this);
		itemModifyPerson.addActionListener(this);
		itemDeletePerson.addActionListener(this);
		itemSelectPersonAll.addActionListener(this);
		itemSelectPersonID.addActionListener(this);
		itemUsing.addActionListener(this);
		itemSelectUsing.addActionListener(this);
		itemBack.addActionListener(this);
		itemSelectBack.addActionListener(this);
		itemInvalid.addActionListener(this);
		itemSelectInvalid.addActionListener(this);// 添加事件侦听

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		// 关闭程序的操作，这是一个匿名类
	}

	/*
	 * 事件处理
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == itemExit) {// 退出
			System.exit(0);
		} else if (obj == itemTypeMan) { // 设备信息管理
			TypeInfo typeMan = new TypeInfo();
			typeMan.downInit();
			typeMan.pack();
			typeMan.setVisible(true);
		} else if (obj == itemAddEquipment) {// 增加设备信息
			AddAssets add = new AddAssets();
			add.downInit();
			add.pack();
			add.setVisible(true);

		} else if (obj == itemModifyEquipment) {// 修改设备信息
			ModifyAssets modify = new ModifyAssets();
			modify.downInit();
			modify.pack();
			modify.setVisible(true);
			// System.out.println("enter : itemModifyEquipment");
		} else if (obj == itemDeleteEquipment) {// 删除设备信息
			DeleteAssets delete = new DeleteAssets();
			delete.downInit();
			delete.pack();
			delete.setVisible(true);
		} else if (obj == itemAddPerson) {// 增加人员信息
			AddPerson add = new AddPerson();
			add.downInit();
			add.pack();
			add.setVisible(true);
		} else if (obj == itemModifyPerson) {// 修改人员信息
			ModifyPerson modify = new ModifyPerson();
			modify.downInit();
			modify.pack();
			modify.setVisible(true);
		} else if (obj == itemDeletePerson) {// 删除人员信息
			DeletePerson delete = new DeletePerson();
			delete.downInit();
			delete.pack();
			delete.setVisible(true);

		} else if (obj == itemUsing) {// 资产领用
			UseAssets use = new UseAssets();
			use.pack();
			use.setVisible(true);
		} else if (obj == itemBack) {// 设备归还
			BackAssets back = new BackAssets();
			back.pack();
			back.setVisible(true);
		} else if (obj == itemInvalid) {// 设备报废
			InvalidAssets invalid = new InvalidAssets();
			invalid.pack();
			invalid.setVisible(true);

		}

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

}