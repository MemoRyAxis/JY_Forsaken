package com.interfaceModule.assetsInfo;

import java.awt.*;
import java.awt.event.*;
import java.net.*;

import javax.swing.*;

import com.dataOperate.TypeBean;
import com.interfaceModule.sysMod.TypeInfo;

/**
 * @author LGM_C4 �豸I��Ϣ�ۺϹ����� �ṩ�����棬�������༯��
 */
public class AssetsInfo extends JFrame implements ActionListener, ItemListener {

	Container contentPane;
	JPanel centerPanel = new JPanel();
	JPanel upPanel = new JPanel();
	JPanel downPanel = new JPanel();

	// ���ÿ�ܴ�С
	Dimension faceSize = new Dimension(800, 500);

	// ����ͼ�ν���Ԫ��
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();
	JLabel jLabel5 = new JLabel();
	JLabel jLabel6 = new JLabel();
	JLabel jLabel7 = new JLabel();
	JLabel jLabel8 = new JLabel();
	JLabel jLabel9 = new JLabel();

	JTextField jTextField1 = new JTextField(15); // �豸���
	JTextField jTextField2 = new JTextField(15); // �豸����
	JTextField jTextField3 = new JTextField(15); // ��������
	JTextField jTextField4 = new JTextField(15); // �豸�ͺ�
	JTextField jTextField5 = new JTextField(15); // �豸�۸�
	JTextField jTextField6 = new JTextField(15); // ��������
	JTextField jTextField7 = new JTextField(15); // �ʲ�״̬
	JTextField jTextField8 = new JTextField(15); // ��ע
	JTextField jTextField9 = new JTextField(46);

	JComboBox jComboBox1 = null;
	JComboBox jComboBox2 = null;

	JButton searchInfo = new JButton();
	JButton addInfo = new JButton();
	JButton modifyInfo = new JButton();
	JButton deleteInfo = new JButton();
	JButton clearInfo = new JButton();
	JButton saveInfo = new JButton();
	JButton exitInfo = new JButton();

	JButton jBSee = new JButton();
	JButton jBSearch = new JButton();
	JButton jBExit = new JButton();
	JButton jBSum = new JButton();
	JButton jBGrade = new JButton();

	GridBagLayout gridBag = new GridBagLayout();
	GridBagConstraints gridBagCon;

	public AssetsInfo() {
		// ���ÿ�ܴ�С
		this.setSize(faceSize);
		// ���ñ���
		this.setTitle("�豸�ۺ���Ϣ����");
		this.setResizable(false);
		// ���ó���ͼ��
		this.setIconImage(getImage("image/smile.png"));

		try {
			Init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void Init() throws Exception {
		contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		Font font = new Font("Dialog", 0, 12);

		// �в���岼��
		centerPanel.setLayout(gridBag);

		jLabel1.setText("�豸���");
		jLabel1.setFont(font);
		gridBagCon = new GridBagConstraints();
		gridBagCon.gridx = 0;
		gridBagCon.gridy = 0;
		gridBagCon.insets = new Insets(10, 10, 10, 1);
		gridBag.setConstraints(jLabel1, gridBagCon);
		centerPanel.add(jLabel1);

		gridBagCon = new GridBagConstraints();
		gridBagCon.gridx = 1;
		gridBagCon.gridy = 0;
		gridBagCon.insets = new Insets(10, 1, 10, 15);
		gridBag.setConstraints(jTextField1, gridBagCon);
		centerPanel.add(jTextField1);

		jLabel2.setText("�豸����");
		jLabel2.setFont(font);
		gridBagCon = new GridBagConstraints();
		gridBagCon.gridx = 2;
		gridBagCon.gridy = 0;
		gridBagCon.insets = new Insets(10, 15, 10, 1);
		gridBag.setConstraints(jLabel2, gridBagCon);
		centerPanel.add(jLabel2);

		gridBagCon = new GridBagConstraints();
		gridBagCon.gridx = 3;
		gridBagCon.gridy = 0;
		gridBagCon.insets = new Insets(10, 1, 10, 10);
		gridBag.setConstraints(jTextField2, gridBagCon);
		centerPanel.add(jTextField2);

		jLabel3.setText("��������");
		jLabel3.setFont(font);
		gridBagCon = new GridBagConstraints();
		gridBagCon.gridx = 0;
		gridBagCon.gridy = 1;
		gridBagCon.insets = new Insets(10, 10, 10, 1);
		gridBag.setConstraints(jLabel3, gridBagCon);
		centerPanel.add(jLabel3);

		TypeBean tbean = new TypeBean();
		String[] allType = tbean.searchAllForAssets();
		jComboBox1 = new JComboBox(allType);
		gridBagCon = new GridBagConstraints();
		gridBagCon.gridx = 1;
		gridBagCon.gridy = 1;
		gridBagCon.insets = new Insets(10, 1, 10, 15);
		gridBag.setConstraints(jComboBox1, gridBagCon);
		centerPanel.add(jComboBox1);

		jLabel4.setText("�豸�ͺ�");
		jLabel4.setFont(font);
		gridBagCon = new GridBagConstraints();
		gridBagCon.gridx = 2;
		gridBagCon.gridy = 1;
		gridBagCon.insets = new Insets(10, 15, 10, 1);
		gridBag.setConstraints(jLabel4, gridBagCon);
		centerPanel.add(jLabel4);

		gridBagCon = new GridBagConstraints();
		gridBagCon.gridx = 3;
		gridBagCon.gridy = 1;
		gridBagCon.insets = new Insets(10, 1, 10, 10);
		gridBag.setConstraints(jTextField4, gridBagCon);
		centerPanel.add(jTextField4);

		jLabel5.setText("�豸�۸�");
		jLabel5.setFont(font);
		gridBagCon = new GridBagConstraints();
		gridBagCon.gridx = 0;
		gridBagCon.gridy = 2;
		gridBagCon.insets = new Insets(10, 10, 10, 1);
		gridBag.setConstraints(jLabel5, gridBagCon);
		centerPanel.add(jLabel5);

		gridBagCon = new GridBagConstraints();
		gridBagCon.gridx = 1;
		gridBagCon.gridy = 2;
		gridBagCon.insets = new Insets(10, 1, 10, 15);
		gridBag.setConstraints(jTextField5, gridBagCon);
		centerPanel.add(jTextField5);

		jLabel6.setText("��������");
		jLabel6.setFont(font);
		gridBagCon = new GridBagConstraints();
		gridBagCon.gridx = 2;
		gridBagCon.gridy = 2;
		gridBagCon.insets = new Insets(10, 15, 10, 1);
		gridBag.setConstraints(jLabel6, gridBagCon);
		centerPanel.add(jLabel6);

		gridBagCon = new GridBagConstraints();
		gridBagCon.gridx = 3;
		gridBagCon.gridy = 2;
		gridBagCon.insets = new Insets(10, 1, 10, 10);
		gridBag.setConstraints(jTextField6, gridBagCon);
		centerPanel.add(jTextField6);

		jLabel7.setText("�豸״̬");
		jLabel7.setFont(font);
		gridBagCon = new GridBagConstraints();
		gridBagCon.gridx = 0;
		gridBagCon.gridy = 3;
		gridBagCon.insets = new Insets(10, 10, 10, 1);
		gridBag.setConstraints(jLabel7, gridBagCon);
		centerPanel.add(jLabel7);

		gridBagCon = new GridBagConstraints();
		gridBagCon.gridx = 1;
		gridBagCon.gridy = 3;
		gridBagCon.insets = new Insets(10, 1, 10, 15);
		gridBag.setConstraints(jTextField7, gridBagCon);
		centerPanel.add(jTextField7);

		jLabel8.setText("��           ע");
		jLabel8.setFont(font);
		gridBagCon = new GridBagConstraints();
		gridBagCon.gridx = 2;
		gridBagCon.gridy = 3;
		gridBagCon.insets = new Insets(10, 15, 10, 1);
		gridBag.setConstraints(jLabel8, gridBagCon);
		centerPanel.add(jLabel8);

		gridBagCon = new GridBagConstraints();
		gridBagCon.gridx = 3;
		gridBagCon.gridy = 3;
		gridBagCon.insets = new Insets(10, 1, 10, 10);
		gridBag.setConstraints(jTextField8, gridBagCon);
		centerPanel.add(jTextField8);

		contentPane.add(centerPanel, BorderLayout.CENTER);

		jTextField1.setEditable(false);
		jTextField2.setEditable(false);
		jTextField3.setEditable(false);
		jTextField4.setEditable(false);
		jTextField5.setEditable(false);
		jTextField6.setEditable(false);
		jTextField7.setEditable(false);
		jTextField8.setEditable(false);

	}

	/**
	 * �²���岼��
	 */
	public void downInit() {
		Font font = new Font("Dialog", 0, 12);

		searchInfo.setText("��ѯ");
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
		saveInfo.setText("����");
		saveInfo.setFont(font);
		downPanel.add(saveInfo);
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
		saveInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		exitInfo.addActionListener(this);

		jComboBox1.addItemListener(this);

		modifyInfo.setEnabled(false);
		deleteInfo.setEnabled(false);
		saveInfo.setEnabled(false);
		clearInfo.setEnabled(false);

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

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == searchInfo) {// ��ѯ

		} else if (obj == addInfo) {// ����

		} else if (obj == modifyInfo) {// �޸�
		} else if (obj == deleteInfo) {// ɾ��
		} else if (obj == saveInfo) {// ����
		} else if (obj == clearInfo) {// ���

			setNull();
		} else if (obj == exitInfo) {// �˳�
			this.dispose();
		}

	}

	private void setNull() {

		jTextField1.setText(null);
		jTextField2.setText(null);
		jTextField3.setText(null);
		jTextField4.setText(null);
		jTextField5.setText(null);
		jTextField6.setText(null);
		jTextField7.setText(null);
		jTextField8.setText(null);
	}

}
