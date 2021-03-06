package com.interfaceModule.assetsInfo;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

import com.dataOperate.AssetsBean;

/**
 * @author LGM_C4 
 * 设备信息管理模块 根据设备编号查询设备信息，以供调用者修改或删除
 * 
 */
public class ModifyAssetsSearch extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;

	Container contentPane;
	String[] s;
	// 框架的大小
	Dimension faceSize = new Dimension(300, 100);
	JLabel jLabel1 = new JLabel();
	JComboBox selectID;
	JButton searchInfo = new JButton();

	public ModifyAssetsSearch(JFrame frame) {

		super(frame, true);
		this.setTitle("设备编号查询");
		this.setResizable(false);
		try {
			Init();
		} catch (Exception e) {
			e.printStackTrace();

		}

		// 设置运行位置，使对话框居中
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int) (screenSize.width - 400) / 2,
				(int) (screenSize.height - 300) / 2 + 45);
	}

	private void Init() throws Exception {
		this.setSize(faceSize);
		contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());

		jLabel1.setText("请输入或者选择设备编号：");
		jLabel1.setFont(new Font("Dialog", 0, 12));
		contentPane.add(jLabel1);

		AssetsBean getId = new AssetsBean();
		s = getId.getAllId();

		selectID = new JComboBox(s);

		selectID.setEditable(true);
		selectID.setFont(new Font("Dialog", 0, 12));
		contentPane.add(selectID);

		searchInfo.setText("查询");
		searchInfo.setFont(new Font("Dialog", 0, 12));
		contentPane.add(searchInfo);

		searchInfo.addActionListener(this);

	}

	/**
	 * 返回选择编号
	 */
	public String getID() {
		return (String) this.selectID.getSelectedItem();
	}

	/*
	 * 事件处理
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == selectID) {// 退出
			this.dispose();
		} else if (obj == searchInfo) {// 修改
			this.dispose();
		}
	}

}
