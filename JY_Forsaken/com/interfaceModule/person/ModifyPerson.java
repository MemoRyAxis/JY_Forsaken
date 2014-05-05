package com.interfaceModule.person;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import com.dataOperate.PersonBean;

/**
 * @author LGM_C4 修改人员信息的类
 * 
 */
public class ModifyPerson extends PersonInfo {

	private static final long serialVersionUID = 1L;

	String id_str = "";

	public ModifyPerson() {
		this.setTitle("修改设备信息");
		this.setResizable(false);

		jTextField1.setEditable(false);
		jTextField1.setText("请查询编号");
		jTextField2.setEditable(false);
		jTextField3.setEditable(false);
		jTextField4.setEditable(false);
		jTextField5.setEditable(false);
		jTextField6.setEditable(false);

		// 设置运行临时窗口位置
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - 400) / 2,
				(screenSize.height) / 2 + 45);
	}

	public void downInit() {
		Font font = new Font("Dialog", 0, 12);

		searchInfo.setText("人员编号查询");
		searchInfo.setFont(font);
		downPanel.add(searchInfo);
		modifyInfo.setText("修改");
		modifyInfo.setFont(font);
		downPanel.add(modifyInfo);
		clearInfo.setText("清空");
		clearInfo.setFont(font);
		downPanel.add(clearInfo);
		exitInfo.setText("退出");
		exitInfo.setFont(font);
		downPanel.add(exitInfo);

		searchInfo.setEnabled(true);
		modifyInfo.setEnabled(false);
		clearInfo.setEnabled(true);
		exitInfo.setEnabled(true);

		// 添加事件侦听
		searchInfo.addActionListener(this);
		modifyInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		exitInfo.addActionListener(this);

		this.contentPane.add(downPanel, BorderLayout.SOUTH);

	}

	/*
	 * 事件处理
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String[] s = new String[6];

		if (obj == exitInfo) {// 退出
			this.dispose();
		} else if (obj == modifyInfo) {// 修改
			PersonBean modifyPerson = new PersonBean();
			modifyPerson.modify(jTextField1.getText(), jTextField2.getText(),
					jTextField3.getText(), jTextField4.getText(),
					jTextField5.getText(), jTextField6.getText());
			modifyPerson.search(jTextField1.getText());

			s = modifyPerson.search(id_str);

			jTextField2.setText(s[0]);
			jTextField3.setText(s[1]);
			jTextField4.setText(s[2]);
			jTextField5.setText(s[3]);
			jTextField6.setText(s[4]);
		} else if (obj == clearInfo) { // 清空
			setNull();
			jTextField1.setText("请查询编号");
		} else if (obj == searchInfo) {// 编号查询
			ModifyPersonSearch modify_search = new ModifyPersonSearch(this);
			modify_search.pack();
			modify_search.setVisible(true);
			try {
				id_str = modify_search.getID();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "没有这个编号~");
			}

			PersonBean searchA = new PersonBean();
			s = searchA.search(id_str);
			if (s == null) {
				JOptionPane.showMessageDialog(null, "木有这个记录");
				jTextField1.setText("请查询编号");
				jTextField2.setText("");
				jTextField3.setText("");
				jTextField4.setText("");
				jTextField5.setText("");
				jTextField6.setText("");

				jTextField1.setEditable(false);
				jTextField2.setEditable(false);
				jTextField3.setEditable(false);
				jTextField4.setEditable(false);
				jTextField5.setEditable(false);
				jTextField6.setEditable(false);
				return;

			} else {
				jTextField1.setText(id_str);
				jTextField2.setText(s[0]);
				jTextField3.setText(s[1]);
				jTextField4.setText(s[2]);
				jTextField5.setText(s[3]);
				jTextField6.setText(s[4]);

				jTextField2.setEditable(true);
				jTextField3.setEditable(true);
				jTextField4.setEditable(true);
				jTextField5.setEditable(true);
				jTextField6.setEditable(true);
				modifyInfo.setEnabled(true);

			}

		}

	}
}
