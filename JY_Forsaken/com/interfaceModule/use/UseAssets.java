package com.interfaceModule.use;

import java.awt.*;
import java.awt.event.*;
import java.net.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.dataOperate.AssetsBean;
import com.dataOperate.AssetsTrjnBean;
import com.dataOperate.PersonBean;
import com.sun.corba.se.spi.ior.MakeImmutable;

/**
 * @author LGM_C4 �豸����
 * 
 */
public class UseAssets extends JFrame implements ActionListener,
		ListSelectionListener, ItemListener {
	private static final long serialVersionUID = 1L;

	Container contentPane;
	// �������õ����
	JPanel mainPanel = new JPanel();
	JPanel upPanel = new JPanel();
	JPanel centerPanel = new JPanel();
	JPanel downPanel = new JPanel();

	// ����ͼ�ν���Ԫ��
	JLabel jLabel = new JLabel();
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();

	String JourNo = "1";
	String FromAcc = "�豸����";// ��������
	String AssetsID = null; // �豸���
	JComboBox jComboBox1 = null; // ������
	String PersonID = "1";
	JTextField jTextField1 = new JTextField();// �豸����
	JTextField jTextField2 = new JTextField();// ��;
	JTextField jTextField3 = new JTextField();// ��ע
	JButton modifyInfo = new JButton();
	JButton clearInfo = new JButton();

	// ������
	JScrollPane jScrollPanel;
	JTable jTable;
	ListSelectionModel listSelectionModel = null;
	String[] colName = { "�豸���", "����", "���", "�ͺ�", "�۸�" };
	String[][] colValue;

	GridBagLayout gridBag = new GridBagLayout();
	GridBagConstraints gridBagCon;

	public UseAssets() {
		this.setLayout(new BorderLayout());
		this.setTitle("�豸���ù���");
		// ���ó���ͼ��
		this.setIconImage(getImage("image/smile.png"));
		// ��������ʱ��ʱ���ڵ�λ��
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - 400) / 2,
				(screenSize.height - 300) / 2 + 45);

		try {
			Init();
			makeFrame();// ����������
			addListener();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * ����¼�����
	 */
	private void addListener() throws Exception {
		modifyInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		jComboBox1.addItemListener(this);

	}

	/**
	 * ����ı�
	 */
	public void setNull() {

		jTextField1.setText(null);
		jTextField2.setText(null);
		jTextField3.setText(null);
		jTextField1.setEnabled(false);
		jTextField2.setEnabled(false);
		jTextField3.setEnabled(false);
	}

	/**
	 * ����������
	 */
	private void makeFrame() throws Exception {
		contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(upPanel, BorderLayout.SOUTH);

	}

	/**
	 * �ϲ���岼��
	 */
	private void Init() throws Exception {
		AssetsBean bean = new AssetsBean();
		upPanel.setLayout(gridBag);
		Font font = new Font("Dialog", 0, 16);
		try {
			jLabel1.setText("�豸���ù���");
			jLabel1.setFont(font);
			gridBagCon = new GridBagConstraints();
			gridBagCon.gridx = 0;
			gridBagCon.gridy = 0;
			gridBagCon.gridwidth = 4;
			gridBagCon.gridheight = 1;
			gridBagCon.insets = new Insets(0, 10, 0, 10);
			gridBag.setConstraints(jLabel1, gridBagCon);
			centerPanel.add(jLabel1);

			colValue = bean.searchAllForUse();
			jTable = new JTable(colValue, colName);
			jTable.setPreferredScrollableViewportSize(new Dimension(450, 280));
			listSelectionModel = jTable.getSelectionModel();
			listSelectionModel
					.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listSelectionModel.addListSelectionListener(this);
			jScrollPanel = new JScrollPane(jTable);
			jScrollPanel.setPreferredSize(new Dimension(450, 280));

			gridBagCon = new GridBagConstraints();
			gridBagCon.gridx = 0;
			gridBagCon.gridy = 1;
			gridBagCon.gridwidth = 4;
			gridBagCon.gridheight = 1;
			gridBagCon.insets = new Insets(0, 0, 10, 0);
			gridBag.setConstraints(jScrollPanel, gridBagCon);
			upPanel.add(jScrollPanel);

			jLabel1.setText("�豸����:");
			jLabel1.setFont(font);
			gridBagCon = new GridBagConstraints();
			gridBagCon.gridx = 0;
			gridBagCon.gridy = 2;
			gridBagCon.insets = new Insets(10, 20, 10, 1);
			gridBag.setConstraints(jLabel1, gridBagCon);
			upPanel.add(jLabel1);

			gridBagCon = new GridBagConstraints();
			gridBagCon.gridx = 1;
			gridBagCon.gridy = 2;
			gridBagCon.insets = new Insets(10, 1, 10, 20);
			gridBag.setConstraints(jTextField1, gridBagCon);
			upPanel.add(jTextField1);

			jLabel2.setText("������Ա:");
			jLabel2.setFont(font);
			gridBagCon = new GridBagConstraints();
			gridBagCon.gridx = 2;
			gridBagCon.gridy = 2;
			gridBagCon.insets = new Insets(10, 20, 10, 1);
			gridBag.setConstraints(jLabel1, gridBagCon);
			upPanel.add(jLabel2);

			PersonBean pbean = new PersonBean();
			String[] allType = pbean.searchAllName();
			gridBagCon = new GridBagConstraints();
			gridBagCon.gridx = 3;
			gridBagCon.gridy = 2;
			gridBagCon.insets = new Insets(10, 1, 10, 20);
			gridBag.setConstraints(jComboBox1, gridBagCon);
			upPanel.add(jComboBox1);

			jLabel3.setText("��          ;:");
			jLabel3.setFont(font);
			gridBagCon = new GridBagConstraints();
			gridBagCon.gridx = 0;
			gridBagCon.gridy = 3;
			gridBagCon.insets = new Insets(10, 20, 10, 1);
			gridBag.setConstraints(jLabel3, gridBagCon);
			upPanel.add(jLabel3);

			gridBagCon = new GridBagConstraints();
			gridBagCon.gridx = 1;
			gridBagCon.gridy = 3;
			gridBagCon.insets = new Insets(10, 1, 10, 20);
			gridBag.setConstraints(jTextField2, gridBagCon);
			upPanel.add(jTextField2);

			jLabel4.setText("��          ע");
			jLabel4.setFont(font);
			gridBagCon = new GridBagConstraints();
			gridBagCon.gridx = 2;
			gridBagCon.gridy = 3;
			gridBagCon.insets = new Insets(10, 20, 10, 1);
			gridBag.setConstraints(jLabel4, gridBagCon);
			upPanel.add(jLabel4);

			gridBagCon = new GridBagConstraints();
			gridBagCon.gridx = 3;
			gridBagCon.gridy = 3;
			gridBagCon.insets = new Insets(10, 1, 10, 20);
			gridBag.setConstraints(jTextField3, gridBagCon);
			upPanel.add(jTextField3);

			modifyInfo.setText("����");
			modifyInfo.setFont(font);
			gridBagCon = new GridBagConstraints();
			gridBagCon.gridx = 0;
			gridBagCon.gridy = 4;
			gridBagCon.gridwidth = 2;
			gridBagCon.gridheight = 1;
			gridBagCon.insets = new Insets(10, 80, 10, 20);
			gridBag.setConstraints(modifyInfo, gridBagCon);
			upPanel.add(modifyInfo);

			clearInfo.setText("���");
			clearInfo.setFont(font);
			gridBagCon = new GridBagConstraints();
			gridBagCon.gridx = 2;
			gridBagCon.gridy = 4;
			gridBagCon.gridwidth = 2;
			gridBagCon.gridheight = 1;
			gridBagCon.insets = new Insets(10, 20, 10, 80);
			gridBag.setConstraints(clearInfo, gridBagCon);
			upPanel.add(clearInfo);

			jTextField1.setEnabled(false);
			jTextField2.setEnabled(false);
			jTextField3.setEnabled(false);

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

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * �¼�����
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == modifyInfo){//�޸�
			AssetsBean bean = new AssetsBean();
			bean.updateStatus(AssetsID, "���");
			
			AssetsTrjnBean atbean = new AssetsTrjnBean();
		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub

	}

}
