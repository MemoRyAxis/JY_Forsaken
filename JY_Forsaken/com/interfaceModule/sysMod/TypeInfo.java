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

	JPanel downPanel = new JPanel();// �������õ����

	Dimension faceSize = new Dimension(400, 400);// �����ܴ�С

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

	JButton exitInfo = new JButton();// ����ͼ�ν���Ԫ��

	JScrollPane jScrollPane1;

	JTable jTable;

	ListSelectionModel listSelectionModel = null;

	String[] colName = { "�豸���", "��������", "������Ա" };

	String[][] colValue;// ������

	GridBagLayout girdBag = new GridBagLayout();

	GridBagConstraints girdBagCon;

	public TypeInfo() {
		this.setSize(faceSize);// ���ÿ�ܴ�С
		this.setTitle("�豸������Ϣ");// ���ñ���
		this.setResizable(true);
		this.setIconImage(getImage("image/android.png"));// ���ó���ͼ��

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
		Font font = new Font("Dialog", 0, 12);// ��������

		//�в���岼��
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

		jLable1.setText("���");
		jLable1.setFont(font);
		centerPanel.add(jLable1);
		centerPanel.add(jTextField1);

		jLable2.setText("��������");
		jLable2.setFont(font);
		centerPanel.add(jLable2);
		centerPanel.add(jTextField2);

		jLable3.setText("������Ա");
		jLable3.setFont(font);
		centerPanel.add(jLable3);
		centerPanel.add(jTextField3);
		contentPane.add(centerPanel, BorderLayout.CENTER);

		jTextField1.setEditable(false);
		jTextField2.setEditable(false);
		jTextField3.setEditable(false);

	}

	/**
	 * �²����Ĳ���
	 */
	public void downInit() {
		Font font = new Font("Dialog", 0, 12);// ��������
		searchInfo.setText("��ȡ�µı��");
		searchInfo.setFont(font);
		downPanel.add(searchInfo);
		addInfo.setText("����");
		addInfo.setFont(font);
		downPanel.add(addInfo);
		modifyInfo.setText("�޸�");
		modifyInfo.setFont(font);
		downPanel.add(modifyInfo);
		deleteInfo.setText("ɾ��");
		deleteInfo.setFont(font);
		downPanel.add(deleteInfo);
		clearInfo.setText("���");
		clearInfo.setFont(font);
		downPanel.add(clearInfo);
		exitInfo.setText("�˳�");
		exitInfo.setFont(font);
		downPanel.add(exitInfo);

		contentPane.add(downPanel, BorderLayout.SOUTH);

		// ����¼�����
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
	 * �¼�����
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == searchInfo) {// ��ȡ�±��
			setNull();
			TypeBean bean = new TypeBean();
			jTextField1.setText("" + bean.getId());
			jTextField2.setEditable(true);
			jTextField3.setEditable(true);

			addInfo.setEnabled(true);
			modifyInfo.setEnabled(true);
			deleteInfo.setEnabled(true);

		} else if (obj == addInfo) {// ����
			TypeBean bean = new TypeBean();
			bean.add(jTextField1.getText(), jTextField2.getText(),
					jTextField3.getText());
			this.dispose();

			TypeInfo typeMan = new TypeInfo();
			typeMan.downInit();
			typeMan.pack();
			typeMan.setVisible(true);

		} else if (obj == modifyInfo) {// �޸�
			TypeBean bean = new TypeBean();
			bean.modify(jTextField1.getText(), jTextField2.getText(),
					jTextField3.getText());
			this.dispose();

			TypeInfo typeMan = new TypeInfo();
			typeMan.downInit();
			typeMan.pack();
			typeMan.setVisible(true);
		} else if (obj == deleteInfo) {// ɾ��
			TypeBean bean = new TypeBean();
			bean.delete(jTextField1.getText());
			this.dispose();

			TypeInfo typeMan = new TypeInfo();
			typeMan.downInit();
			typeMan.pack();
			typeMan.setVisible(true);
		} else if (obj == clearInfo) {// ���
			setNull();
		} else if (obj == exitInfo) {// �˳�
			this.dispose();
		}
		jTable.revalidate();

	}

	/**
	 * ����ı�����
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
	 * �����ѡ�е�ʱ�Ĳ���
	 */
	public void valueChanged(ListSelectionEvent lse) {
		int[] selectedRow = jTable.getSelectedRows();
		int[] selectedCol = jTable.getSelectedColumns();
		// �����ı���ʾ����

		for (int i = 0; i < selectedRow.length; i++) {
			for (int j = 0; j < selectedCol.length; j++) {
				jTextField1.setText(colValue[selectedRow[i]][0]);
				jTextField2.setText(colValue[selectedRow[i]][1]);
				jTextField3.setText(colValue[selectedRow[i]][2]);
			}
		}

		// �����Ƿ�ɲ���
		jTextField2.setEditable(true);
		jTextField3.setEditable(true);
		searchInfo.setEnabled(true);
		addInfo.setEnabled(false);
		modifyInfo.setEnabled(true);
		deleteInfo.setEnabled(true);
		clearInfo.setEnabled(true);

	}

}
