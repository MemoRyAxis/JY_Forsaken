package com.mainInterface;

import javax.swing.UIManager;

import java.awt.*;

/**
 * @author 刘骁义
 * 
 */
public class EquipmentMS {
	boolean packFrame = false;

	/**
	 * 构造函数
	 * 设置运行时窗口的位置
	 */
	public EquipmentMS() {
		EquipmentMain frame = new EquipmentMain();
		if (packFrame) {
			frame.pack();
		} else {
			frame.validate();
		}
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		frame.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);
		frame.setVisible(true);
	}
	public static void main(String [] args){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		} 
		new EquipmentMS();
	}


}