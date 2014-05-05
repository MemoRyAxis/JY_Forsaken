package com.interfaceModule.use;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.text.*;

import javax.swing.*;
import javax.swing.event.*;

import com.dataOperate.AssetsBean;
import com.dataOperate.AssetsTrjnBean;
import com.dataOperate.PersonBean;

/**
 * @author LGM_C4 设备领用
 * 
 */
public class UseAssets extends JFrame implements ActionListener,
		ListSelectionListener, ItemListener {
	private static final long serialVersionUID = 1L;

	Container contentPane;
	// 定义所用的面板
	JPanel mainPanel = new JPanel();
	JPanel upPanel = new JPanel();
	JPanel centerPanel = new JPanel();
	JPanel downPanel = new JPanel();

	// 定义图形界面元素
	JLabel jLabel = new JLabel();
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();

	String JourNo = "1";
	String FromAcc = "设备借用";// 操作类型
	String AssetsID = null; // 设备编号
	JComboBox jComboBox1 = null; // 领用人
	String PersonID = "1";
	JTextField jTextField1 = new JTextField(15);// 设备名称
	JTextField jTextField2 = new JTextField(15);// 用途
	JTextField jTextField3 = new JTextField(15);// 备注
	JButton modifyInfo = new JButton();
	JButton clearInfo = new JButton();

	// 定义表格
	JScrollPane jScrollPanel;
	JTable jTable;
	ListSelectionModel listSelectionModel = null;
	String[] colName = { "设备编号", "名称", "类别", "型号", "价格" };
	String[][] colValue;

	GridBagLayout gridBag = new GridBagLayout();
	GridBagConstraints gridBagCon;

	public UseAssets() {
		this.setLayout(new BorderLayout());
		this.setTitle("设备领用管理");
		// 设置程序图标
		this.setIconImage(getImage("image/smile.png"));
		// 设置运行时临时窗口的位置
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int) (screenSize.width - 400) / 2,
				((int) screenSize.height - 500) / 2 + 45);

		try {
			Init();
			makeFrame();// 生成主界面
			addListener();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 添加事件侦听
	 */
	private void addListener() throws Exception {
		modifyInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		jComboBox1.addItemListener(this);

	}

	/**
	 * 清空文本
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
	 * 生成主界面
	 */
	public void makeFrame() throws Exception {
		contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(upPanel, BorderLayout.SOUTH);

	}

	/**
	 * 上部面板布局
	 */
	public void Init() throws Exception {
		AssetsBean bean = new AssetsBean();
		upPanel.setLayout(gridBag);
		Font font = new Font("Dialog", 0, 12);
		try {
			jLabel.setText("设备领用管理");
			jLabel.setFont(new Font("Dialog", 0, 16));
			gridBagCon = new GridBagConstraints();
			gridBagCon.gridx = 0;
			gridBagCon.gridy = 0;
			gridBagCon.gridwidth = 4;
			gridBagCon.gridheight = 1;
			gridBagCon.insets = new Insets(0, 10, 0, 10);
			gridBag.setConstraints(jLabel, gridBagCon);
			upPanel.add(jLabel);

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

			jLabel1.setText("设备名称:");
			jLabel1.setFont(font);
			gridBagCon = new GridBagConstraints();
			gridBagCon.gridx = 0;
			gridBagCon.gridy = 2;
//			gridBagCon.gridwidth = 2;
//			gridBagCon.gridheight = 1;
			gridBagCon.insets = new Insets(10, 20, 10, 1);
			gridBag.setConstraints(jLabel1, gridBagCon);
			upPanel.add(jLabel1);
			
			gridBagCon = new GridBagConstraints();
			gridBagCon.gridx = 1;
			gridBagCon.gridy = 2;
			gridBagCon.insets = new Insets(10, 1, 10, 20);
			gridBag.setConstraints(jTextField1, gridBagCon);
			upPanel.add(jTextField1);

			jLabel2.setText("领用人员:");
			jLabel2.setFont(font);
			gridBagCon = new GridBagConstraints();
			gridBagCon.gridx = 2;
			gridBagCon.gridy = 2;
			gridBagCon.insets = new Insets(10, 20, 10, 1);
			gridBag.setConstraints(jLabel2, gridBagCon);
			upPanel.add(jLabel2);

			PersonBean pbean = new PersonBean();
			String[] allType = pbean.searchAllName();
			jComboBox1 = new JComboBox(allType);
			gridBagCon = new GridBagConstraints();
			gridBagCon.gridx = 3;
			gridBagCon.gridy = 2;
			gridBagCon.insets = new Insets(10, 1, 10, 20);
			gridBag.setConstraints(jComboBox1, gridBagCon);
			upPanel.add(jComboBox1);

			jLabel3.setText("用          途:");
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

			jLabel4.setText("备          注:");
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

			modifyInfo.setText("领用");
			modifyInfo.setFont(font);
			gridBagCon = new GridBagConstraints();
			gridBagCon.gridx = 0;
			gridBagCon.gridy = 4;
			gridBagCon.gridwidth = 2;
			gridBagCon.gridheight = 1;
			gridBagCon.insets = new Insets(10, 80, 10, 20);
			gridBag.setConstraints(modifyInfo, gridBagCon);
			upPanel.add(modifyInfo);

			clearInfo.setText("清空");
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

	/*
	 * 下拉菜单处理
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			String tempStr = "" + e.getItem();
			int i = tempStr.indexOf("-");
			PersonID = tempStr.substring(0, i);
		}

	}

	/**
	 * 事件处理
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == modifyInfo) {// 修改
			AssetsBean bean = new AssetsBean();
			bean.updateStatus(AssetsID, "借出");

			AssetsTrjnBean atbean = new AssetsTrjnBean();
			JourNo = "" + atbean.getId();// 获取ID
			java.util.Date now = new java.util.Date();
			DateFormat date = DateFormat.getDateTimeInstance();
			String f4 = "" + date.format(now);
			atbean.add(JourNo, "设备借用", AssetsID, f4, PersonID,
					jTextField2.getText(), jTextField2.getText());
			// 重新生成界面
			this.dispose();

			UseAssets useAssets = new UseAssets();
			useAssets.pack();
			useAssets.setVisible(true);
		} else if (obj == clearInfo) {// 清空
			setNull();
		}
		jTable.revalidate();

	}

	/*
	 * 当表格被选中时的操作
	 */
	@Override
	public void valueChanged(ListSelectionEvent lse) {
		int[] selectedRow = jTable.getSelectedRows();
		int[] selectedCol = jTable.getSelectedColumns();
		// 定义文本框显示的内容
		for (int i = 0; i < selectedRow.length; i++) {
			for (int j = 0; j < selectedCol.length; j++) {
				jTextField1.setText(colValue[selectedRow[i]][1]);// 名称
				AssetsID = colValue[selectedRow[i]][0];// 设备编号
			}
		}
		// 设置是否可操作
		jTextField2.setEnabled(true);
		jTextField3.setEnabled(true);
		modifyInfo.setEnabled(true);
		clearInfo.setEnabled(true);

	}

}
