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

	Dimension faceSize = new Dimension(600, 450);// ���ÿ�ܵĴ�С

	Image icon;// ����ͼ��

	JMenuBar mainMenu = new JMenuBar();// �����˵���

	JMenu menuSystem = new JMenu();

	JMenuItem itemTypeMan = new JMenuItem();

	JMenuItem itemExit = new JMenuItem();// ������ϵͳ�����˵���

	JMenu menuEquipment = new JMenu();

	JMenuItem itemAddEquipment = new JMenuItem();

	JMenuItem itemModifyEquipment = new JMenuItem();

	JMenuItem itemDeleteEquipment = new JMenuItem();

	JMenu itemSelectEquipment = new JMenu();

	JMenuItem itemSelectEquipmentAll = new JMenuItem();

	JMenuItem itemSelectEquipmentID = new JMenuItem();// �������豸��Ϣ�����˵���

	JMenu menuPerson = new JMenu();

	JMenuItem itemAddPerson = new JMenuItem();

	JMenuItem itemModifyPerson = new JMenuItem();

	JMenuItem itemDeletePerson = new JMenuItem();

	JMenu itemSelectPerson = new JMenu();

	JMenuItem itemSelectPersonAll = new JMenuItem();

	JMenuItem itemSelectPersonID = new JMenuItem();// ��������Ա��Ϣ�����˵���

	JMenu menuUsing = new JMenu();

	JMenuItem itemUsing = new JMenuItem();

	JMenuItem itemSelectUsing = new JMenuItem();// �������豸���á��˵���

	JMenu menuBack = new JMenu();

	JMenuItem itemBack = new JMenuItem();

	JMenuItem itemSelectBack = new JMenuItem();// �������豸�黹���˵���

	JMenu menuInvalid = new JMenu();

	JMenuItem itemInvalid = new JMenuItem();

	JMenuItem itemSelectInvalid = new JMenuItem();// �������豸���ϡ��˵���

	/**
	 * ���캯������ʼ������
	 */
	public EquipmentMain() {
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ��ӹܼҵ��¼��رմ���
		this.pack();
		this.setSize(faceSize);// ���ÿ�ܴ�С
		this.setTitle("Forsaken�ļ�����豸����ϵͳ");// ��ӱ���
		icon = getImage("image/icon.png");
		this.setIconImage(icon);// ���ó���ͼ��
		try {
			Init();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	/**
	 * �˵���������ʼ��
	 */
	private void Init() {
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());

		Font font = new Font("Dialog", 0, 12);
		menuSystem.setText("ϵͳ����");
		menuSystem.setFont(font);
		menuEquipment.setText("�豸��Ϣ����");
		menuEquipment.setFont(font);
		menuPerson.setText("��Ա��Ϣ����");
		menuPerson.setFont(font);
		menuUsing.setText("�豸����");
		menuUsing.setFont(font);
		menuBack.setText("�豸�黹");
		menuBack.setFont(font);
		menuInvalid.setText("�豸����");
		menuInvalid.setFont(font);// ��Ӳ˵����

		itemTypeMan.setText("�豸������Ϣ");
		itemTypeMan.setFont(font);
		itemExit.setText("�˳�");
		itemExit.setFont(font);// ���ɡ�ϵͳ�����˵����

		itemAddEquipment.setText("����");
		itemAddEquipment.setFont(font);
		itemModifyEquipment.setText("�޸�");
		itemModifyEquipment.setFont(font);
		itemDeleteEquipment.setText("ɾ��");
		itemDeleteEquipment.setFont(font);
		itemSelectEquipment.setText("��ѯ");
		itemSelectEquipment.setFont(font);
		itemSelectEquipmentAll.setText("��ѯ����");
		itemSelectEquipmentAll.setFont(font);
		itemSelectEquipmentID.setText("����Ų�ѯ");
		itemSelectEquipmentID.setFont(font);// ���ɡ��豸��Ϣ�����˵�

		itemAddPerson.setText("��Ա��Ϣ���");
		itemAddPerson.setFont(font);
		itemModifyPerson.setText("��Ա��Ϣ�޸�");
		itemModifyPerson.setFont(font);
		itemDeletePerson.setText("��Ա��Ϣɾ��");
		itemDeletePerson.setFont(font);
		itemSelectPerson.setText("��Ա��Ϣ��ѯ");
		itemSelectPerson.setFont(font);
		itemSelectPersonAll.setText("��ѯ����");
		itemSelectPersonAll.setFont(font);
		itemSelectPersonID.setText("����Ų�ѯ");
		itemSelectPersonID.setFont(font);// ���ɡ���Ա��Ϣ�����˵�

		itemUsing.setText("�豸���ù���");
		itemUsing.setFont(font);
		itemSelectUsing.setText("������Ϣ��ѯ");
		itemSelectUsing.setFont(font);// ���ɡ��豸���á��˵�

		itemBack.setText("�豸�黹����");
		itemBack.setFont(font);
		itemSelectBack.setText("�豸�黹��ѯ");
		itemSelectBack.setFont(font);// ���ɡ��豸�黹���˵�

		itemInvalid.setText("�豸���Ϲ���");
		itemInvalid.setFont(font);
		itemSelectInvalid.setText("������Ϣ��ѯ");
		itemSelectInvalid.setFont(font);// ���ɡ��豸���ϡ��˵�

		menuSystem.add(itemTypeMan);
		menuSystem.add(itemExit);// ��ӡ�ϵͳ�����˵���

		menuEquipment.add(itemAddEquipment);
		menuEquipment.add(itemModifyEquipment);
		menuEquipment.add(itemDeleteEquipment);
		menuEquipment.addSeparator();
		menuEquipment.add(itemSelectEquipment);
		itemSelectEquipment.add(itemSelectEquipmentAll);
		itemSelectEquipment.add(itemSelectEquipmentID);// ��ӡ��豸��Ϣ�����˵���

		menuPerson.add(itemAddPerson);
		menuPerson.add(itemModifyPerson);
		menuPerson.add(itemDeletePerson);
		menuPerson.addSeparator();// ������
		menuPerson.add(itemSelectPerson);
		itemSelectPerson.add(itemSelectPersonAll);
		itemSelectPerson.add(itemSelectPersonID);// ��ӡ���Ա��Ϣ�����˵���

		menuUsing.add(itemUsing);
		menuUsing.add(itemSelectUsing);// ��ӡ��豸���á��˵���

		menuBack.add(itemBack);
		menuBack.add(itemSelectBack);// ��ӡ��豸�黹���˵���

		menuInvalid.add(itemInvalid);
		menuInvalid.add(itemSelectInvalid);// ��ӡ��豸���ϡ��˵���

		mainMenu.add(menuSystem);
		mainMenu.add(menuEquipment);
		mainMenu.add(menuPerson);
		mainMenu.add(menuUsing);
		mainMenu.add(menuBack);
		mainMenu.add(menuInvalid);
		this.setJMenuBar(mainMenu);// ������еĲ˵���

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
		itemSelectInvalid.addActionListener(this);// ����¼�����

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		// �رճ���Ĳ���������һ��������
	}

	/*
	 * �¼�����
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == itemExit) {// �˳�
			System.exit(0);
		} else if (obj == itemTypeMan) { // �豸��Ϣ����
			TypeInfo typeMan = new TypeInfo();
			typeMan.downInit();
			typeMan.pack();
			typeMan.setVisible(true);
		} else if (obj == itemAddEquipment) {// �����豸��Ϣ
			AddAssets add = new AddAssets();
			add.downInit();
			add.pack();
			add.setVisible(true);

		} else if (obj == itemModifyEquipment) {// �޸��豸��Ϣ
			ModifyAssets modify = new ModifyAssets();
			modify.downInit();
			modify.pack();
			modify.setVisible(true);
			// System.out.println("enter : itemModifyEquipment");
		} else if (obj == itemDeleteEquipment) {// ɾ���豸��Ϣ
			DeleteAssets delete = new DeleteAssets();
			delete.downInit();
			delete.pack();
			delete.setVisible(true);
		} else if (obj == itemAddPerson) {// ������Ա��Ϣ
			AddPerson add = new AddPerson();
			add.downInit();
			add.pack();
			add.setVisible(true);
		} else if (obj == itemModifyPerson) {// �޸���Ա��Ϣ
			ModifyPerson modify = new ModifyPerson();
			modify.downInit();
			modify.pack();
			modify.setVisible(true);
		} else if (obj == itemDeletePerson) {// ɾ����Ա��Ϣ
			DeletePerson delete = new DeletePerson();
			delete.downInit();
			delete.pack();
			delete.setVisible(true);

		} else if (obj == itemUsing) {// �ʲ�����
			UseAssets use = new UseAssets();
			use.pack();
			use.setVisible(true);
		} else if (obj == itemBack) {// �豸�黹
			BackAssets back = new BackAssets();
			back.pack();
			back.setVisible(true);
		} else if (obj == itemInvalid) {// �豸����
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