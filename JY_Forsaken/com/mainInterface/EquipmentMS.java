package com.mainInterface;

import javax.swing.UIManager;

import java.awt.*;

/**
 * @author ������
 * 
 */
public class EquipmentMS {
	boolean packFrame = false;

	/**
	 * ���캯��
	 * ��������ʱ���ڵ�λ��
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
			// TODO �Զ����� catch ��
			e.printStackTrace();
		} 
		new EquipmentMS();
	}


}