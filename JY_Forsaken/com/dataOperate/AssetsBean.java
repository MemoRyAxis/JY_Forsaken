package com.dataOperate;

import java.util.*;
import java.sql.*;

import javax.swing.*;

/**
 * @author LGM_C4 �й��豸��Ϣ���ݿ��������
 */
public class AssetsBean {
	String sql;
	ResultSet rs = null;

	String field1; // assetsID
	String field2; // assetsName
	String field3; // typeID
	String field4; // model
	String field5; // price
	String field6; // buyDate
	String field7; // status
	String field8; // other

	String colName;// ����
	String colValue;// ��ֵ
	String volValue2;// ��ֵ

	/**
	 * ����豸��Ϣ
	 */
	public void add(String f1, String f2, String f3, String f4, String f5,
			String f6, String f7, String f8) {
		Database DB = new Database();

		this.field1 = f1;
		this.field2 = f2;
		this.field3 = f3;
		this.field4 = f4;
		this.field5 = f5;
		this.field6 = f6;
		this.field7 = f7;
		this.field8 = f8;

		if (field1 == null || field1.equals("")) {
			JOptionPane.showMessageDialog(null, "�������豸���", "����",
					JOptionPane.ERROR_MESSAGE);
			return;

		} else if (field2 == null || field2.equals("")) {
			JOptionPane.showMessageDialog(null, "�������豸����", "����",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else if (field3 == null || field3.equals("")) {
			JOptionPane.showMessageDialog(null, "��������������", "����",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else if (field4 == null || field4.equals("")) {
			JOptionPane.showMessageDialog(null, "�������豸�ͺ�", "����",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else if (field5 == null || field5.equals("")) {
			JOptionPane.showMessageDialog(null, "�������豸�۸�", "����",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			sql = "insert into Assets(AssetsID,Name,TypeID,Model,Price,BuyDate,Status,Other) values ('"
					+ field1
					+ "','"
					+ field2
					+ "','"
					+ field3
					+ "','"
					+ field4
					+ "','"
					+ field5
					+ "','"
					+ field6
					+ "','"
					+ field7
					+ "','"
					+ field8 + "')";
			try {
				DB.OpenConn();
				DB.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "��ร��ɹ�������˼�¼��");
			} catch (Exception e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "��Ŷ������ʧ����~", "����",
						JOptionPane.ERROR_MESSAGE);
			}finally{
				DB.closeStmt();
				DB.closeConn();
			}

		}

	}
}
