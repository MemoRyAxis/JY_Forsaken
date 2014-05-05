package com.interfaceModule.person;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import com.dataOperate.PersonBean;

public class DeletePerson extends PersonInfo {

	private static final long serialVersionUID = 1L;
	String id_str = "";

	public DeletePerson() {
		this.setTitle("ɾ����Ա��Ϣ");
		this.setResizable(false);

		jTextField1.setEditable(false);
		jTextField1.setText("���ѯ��Ա���");
		jTextField2.setEditable(false);
		jTextField3.setEditable(false);
		jTextField4.setEditable(false);
		jTextField5.setEditable(false);
		jTextField6.setEditable(false);

		// ����������ʱ����λ��
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - 400) / 2,
				(screenSize.height) / 2 + 45);
	}

	public void downInit() {
		Font font = new Font("Dialog", 0, 12);

		searchInfo.setText("��Ա��Ų�ѯ");
		searchInfo.setFont(font);
		downPanel.add(searchInfo);
		deleteInfo.setText("ɾ��");
		deleteInfo.setFont(font);
		downPanel.add(deleteInfo);
		exitInfo.setText("�˳�");
		exitInfo.setFont(font);
		downPanel.add(exitInfo);

		searchInfo.setEnabled(true);
		deleteInfo.setEnabled(false);
		exitInfo.setEnabled(true);

		// ����¼�����
		searchInfo.addActionListener(this);
		deleteInfo.addActionListener(this);
		exitInfo.addActionListener(this);

		contentPane.add(downPanel, BorderLayout.SOUTH);

	}

	/*
	 * �¼�����
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String[] s = new String[5];

		if (obj == exitInfo) {// �˳�
			this.dispose();
		} else if (obj == deleteInfo) {
			int ifdel = JOptionPane.showConfirmDialog(null, "��ȷ��Ҫɾ��ô��", "������ʾ",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);

			if (ifdel == JOptionPane.YES_OPTION) {
				PersonBean ab = new PersonBean();
				ab.delete(jTextField1.getText());

				this.dispose();
				DeletePerson delete = new DeletePerson();
				delete.downInit();
				delete.pack();
				delete.setVisible(true);
			} else {
				return;
			}

		} else if (obj == searchInfo) {// ��Ų�ѯ
			ModifyPersonSearch modify_search = new ModifyPersonSearch(this);
			modify_search.pack();
			modify_search.setVisible(true);
			id_str = modify_search.getID();
			PersonBean searchA = new PersonBean();
			s = searchA.search(id_str);

			if (s == null) {
				JOptionPane.showMessageDialog(null, "ľ�������¼");
				jTextField1.setText("���ѯ�豸���");
				jTextField2.setText("");
				jTextField3.setText("");
				jTextField4.setText("");
				jTextField5.setText("");
				jTextField6.setText("");
				deleteInfo.setEnabled(false);
				return;
			} else {
				jTextField1.setText(id_str);
				jTextField2.setText(s[0]);
				jTextField3.setText(s[1]);
				jTextField4.setText(s[2]);
				jTextField5.setText(s[3]);
				jTextField6.setText(s[4]);
				deleteInfo.setEnabled(true);
			}
		}
	}

}
