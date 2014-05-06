package com.interfaceModule.infoSelect;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.URL;
import java.net.URLClassLoader;

import javax.swing.*;

import com.dataOperate.AssetsBean;
import com.dataOperate.PersonBean;

public class ResultInfo extends JFrame {

	private static final long serialVersionUID = 1L;

	JLabel jLabel1 = new JLabel();
	JButton jBExit = new JButton();
	JScrollPane jScrollPane1;
	JTable jTable;

	String sNum;
	String[][] colValue;
	String sColValue;
	String sColName;
	String sFromValue;
	String sToValue;
	String tableID;

	/**
	 * ����Assets�����еļ�¼
	 */
	public void resultAssetsAll() {
		this.setTitle("��Ϣ��ѯ���");
		// ���ó���ͼ��
		this.setIconImage(getImage("image/smile.png"));
		// ��������ʱ��ʱ���ڵ�λ��
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int) (screenSize.width - 400) / 2,
				((int) screenSize.height - 500) / 2 + 45);

		String[] colName = { "�豸���", "�豸����", "������Ϣ", "�ͺ�", "�۸�", "��������", "״̬",
				"��ע" };
		AssetsBean bean = new AssetsBean();
		try {

			colValue = bean.searchAll();
			if (colValue == null) {
				JOptionPane.showMessageDialog(null, "ľ�з��������ļ�¼��");
				this.dispose();
			} else {
				jTable = new JTable(colValue, colName);
				jScrollPane1 = new JScrollPane(jTable);

				this.getContentPane().add(jScrollPane1, BorderLayout.CENTER);
				this.pack();
				this.setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����Assets���ض�ID��¼
	 */
	public void resultAssetsID(String ID) {
		this.tableID = ID;
		this.setTitle("��Ϣ��ѯ���");
		this.setIconImage(getImage("image/android.png"));
		// ��������λ��
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int) (screenSize.width - 400) / 2,
				((int) screenSize.height - 500) / 2 + 45);
		String[] colName = { "�豸���", "�豸����", "������Ϣ", "�ͺ�", "�۸�", "��������", "״̬",
				"��ע" };
		AssetsBean bean = new AssetsBean();
		try {
			colValue = bean.searchAll(tableID);
			if (colValue == null) {
				this.dispose();
				JOptionPane.showMessageDialog(null, "û�з��������ļ�¼");

			} else {
				jTable = new JTable(colValue, colName);
				jScrollPane1 = new JScrollPane(jTable);
				this.getContentPane().add(jScrollPane1, BorderLayout.CENTER);
				this.pack();
				this.setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * ����Person������м�¼
	 */
	public void resultPersonAll() {
		this.setTitle("��Ϣ��ѯ���");
		// ���ÿ�ܴ�С
		this.setSize(new Dimension(1500, 450));
		this.setIconImage(getImage("image/android.png"));
		// ��������λ��
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int) (screenSize.width - 400) / 2,
				((int) screenSize.height - 500) / 2 + 45);

		String[] colName = { "��Ա���", "����", "�Ա�", "����", "ְλ", "����" };
		PersonBean bean = new PersonBean();
		try {
			colValue = bean.searchAll();
			if (colValue == null) {
				JOptionPane.showMessageDialog(null, "ľ�з�����������~");
				this.dispose();
			} else {
				jTable = new JTable(colValue, colName);
				jScrollPane1 = new JScrollPane(jTable);

				this.getContentPane().add(jScrollPane1, BorderLayout.CENTER);
				this.pack();
				this.setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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

}
