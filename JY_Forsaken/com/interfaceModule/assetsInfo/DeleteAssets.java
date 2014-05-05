package com.interfaceModule.assetsInfo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import com.dataOperate.AssetsBean;

/**
 * @author LGM_C4 设备信息管理模块 删除设备信息
 * 
 */
public class DeleteAssets extends AssetsInfo {
	private static final long serialVersionUID = 1L;
	String id_str = "";

	public DeleteAssets() {
		this.setTitle("删除设备信息");
		this.setResizable(false);

		jTextField1.setEditable(false);
		jTextField1.setText("请查询编号");
		jTextField2.setEditable(false);
		jTextField3.setEditable(false);
		jTextField4.setEditable(false);
		jTextField5.setEditable(false);
		jTextField6.setEditable(false);
		jTextField7.setEditable(false);
		jTextField8.setEditable(false);
		jComboBox1.setEditable(false);
		jComboBox1.setEnabled(false);

		// 设置运行临时窗口位置
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - 400) / 2,
				(screenSize.height) / 2 + 45);
	}

	public void downInit() {
		Font font = new Font("Dialog", 0, 12);

		searchInfo.setText("设备编号查询");
		searchInfo.setFont(font);
		downPanel.add(searchInfo);
		deleteInfo.setText("删除");
		deleteInfo.setFont(font);
		downPanel.add(deleteInfo);
		exitInfo.setText("退出");
		exitInfo.setFont(font);
		downPanel.add(exitInfo);

		searchInfo.setEnabled(true);
		deleteInfo.setEnabled(false);
		exitInfo.setEnabled(true);

		// 添加事件侦听
		searchInfo.addActionListener(this);
		deleteInfo.addActionListener(this);
		exitInfo.addActionListener(this);

		contentPane.add(downPanel, BorderLayout.SOUTH);

	}

	/*
	 * 事件处理
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String[] s = new String[8];

		if (obj == exitInfo) {// 退出
			this.dispose();
		} else if (obj == deleteInfo) {
			int ifdel = JOptionPane.showConfirmDialog(null, "你确定要删除么？", "友情提示",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);

			if (ifdel == JOptionPane.YES_OPTION) {
				AssetsBean ab = new AssetsBean();
				ab.delete(jTextField1.getText());

				this.dispose();
				DeleteAssets delete = new DeleteAssets();
				delete.downInit();
				delete.pack();
				delete.setVisible(true);
			} else {
				return;
			}

		} else if (obj == searchInfo) {// 编号查询
			ModifyAssetsSearch modify_search = new ModifyAssetsSearch(this);
			modify_search.pack();
			modify_search.setVisible(true);
			id_str = modify_search.getID();
			AssetsBean searchA = new AssetsBean();
			s = searchA.search(id_str);

			if (s == null) {
				JOptionPane.showMessageDialog(null, "木有这个记录");
				jTextField1.setText("请查询设备编号");
				jTextField2.setText("");
				jTextField3.setText("");
				jTextField4.setText("");
				jTextField5.setText("");
				jTextField6.setText("");
				jTextField7.setText("");
				jTextField8.setText("");
				deleteInfo.setEnabled(false);
				return;
			} else {
				jTextField1.setText(id_str);
				jTextField2.setText(s[0]);
				jTextField3.setText(s[1]);
				int index = Integer.parseInt(s[1]) - 1;
				jComboBox1.setSelectedIndex(index);
				jTextField4.setText(s[2]);
				jTextField5.setText(s[3]);
				jTextField6.setText(s[4]);
				jTextField7.setText(s[5]);
				jTextField8.setText(s[6]);
				deleteInfo.setEnabled(true);
			}
		}

	}

}
