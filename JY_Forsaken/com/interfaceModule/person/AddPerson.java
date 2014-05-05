package com.interfaceModule.person;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import com.dataOperate.PersonBean;

public class AddPerson extends PersonInfo {

	private static final long serialVersionUID = 1L;
	PersonBean pb = new PersonBean();

	public AddPerson() {
		this.setTitle("�����Ա��Ϣ");
		this.setResizable(false);
		jTextField1.setEditable(false);
		jTextField1.setText("" + pb.getId());
		jTextField2.setEditable(true);
		jTextField3.setEditable(true);
		jTextField4.setEditable(true);
		jTextField5.setEditable(true);
		jTextField6.setEditable(true);

		// ��������ʱ��ʱ���ڵ�λ��
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - 400) / 2,
				(screenSize.height - 300) / 2 + 45);

	}

	public void downInit() {
		Font font = new Font("Dialog", 0, 12);
		addInfo.setText("����");
		addInfo.setFont(font);
		downPanel.add(addInfo);
		clearInfo.setText("���");
		clearInfo.setFont(font);
		downPanel.add(clearInfo);
		exitInfo.setText("�˳�");
		exitInfo.setFont(font);
		downPanel.add(exitInfo);

		// ����¼�����
		addInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		exitInfo.addActionListener(this);

		this.contentPane.add(downPanel, BorderLayout.SOUTH);

	}

	/*
	 * �¼�����
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == exitInfo) {// �˳�
			this.dispose();
		} else if (obj == addInfo) {// ����
			jTextField1.setEnabled(false);
			jTextField2.setEnabled(false);
			jTextField3.setEnabled(false);
			jTextField4.setEnabled(false);
			jTextField5.setEnabled(false);
			jTextField6.setEnabled(false);
			jTextField7.setEnabled(false);
			jTextField8.setEnabled(false);

			addInfo.setEnabled(false);
			clearInfo.setEnabled(false);
			exitInfo.setEnabled(false);

			// �����Ϣ

			PersonBean pb1 = new PersonBean();
			pb1.add(jTextField1.getText(), jTextField2.getText(),
					jTextField3.getText(), jTextField4.getText(),
					jTextField5.getText(), jTextField6.getText());

			this.dispose();
			// �������ɽ���
			AddPerson ap = new AddPerson();
			ap.downInit();
			ap.pack();
			ap.setVisible(true);

		} else if (obj == clearInfo) {// ���
			setNull();
			jTextField1.setText("" + pb.getId());
		}
	}
}
