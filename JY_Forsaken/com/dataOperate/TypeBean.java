package com.dataOperate;

import java.sql.*;

import java.util.*;

import javax.swing.*;

import com.dataOperate.*;

public class TypeBean {
	String sql;
	ResultSet rs = null;

	String field1; // TypeID
	String field2; // B_Type
	String field3; // S_Type

	String colName;// ����
	String colValue; // ��ֵ
	String colValue2; // ��ֵ

	/**
	 * �����Ϣ
	 */
	public void add(String f1, String f2, String f3) {
		Database DB = new Database();
		this.field1 = f1;
		this.field2 = f2;
		this.field3 = f3;

		if (field2 == null || field2.equals("")) {
			JOptionPane.showMessageDialog(null, "��������������", "����",
					JOptionPane.ERROR_MESSAGE);
			return;

		} else if (field3 == null || field3.equals("")) {
			JOptionPane.showMessageDialog(null, "�����������Ա", "����",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			sql = "insert into AssetsType(TypeID,B_Type,S_Type) values ('"
					+ field1 + "','" + field2 + "','" + field3 + "')";
			try {
				DB.OpenConn();
				DB.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "����һ���¼�¼,ŷҮ��");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "��Ŷ��û����~", "����",
						JOptionPane.ERROR_MESSAGE);

			} finally {
				DB.closeStmt();
				DB.closeConn();
			}
		}

	}

	/**
	 * �޸���Ϣ
	 */
	public void modify(String f1, String f2, String f3) {

		Database DB = new Database();
		this.field1 = f1;
		this.field2 = f2;
		this.field3 = f3;

		if (field2 == null || field2.equals("")) {
			JOptionPane.showMessageDialog(null, "��������������", "����",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			sql = "update AssetsType set B_Type = '" + field2 + "',S_Type = '"
					+ field3 + "' where TypeID = " + field1 + " ";

			try {
				DB.OpenConn();
				DB.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "���ѳɹ��޸���������¼��");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "��ʧ����", "����",
						JOptionPane.ERROR_MESSAGE);
			} finally {
				DB.closeStmt();
				DB.closeConn();
			}
		}

	}

	/**
	 * @param ɾ����Ϣ
	 */
	public void delete(String f1) {
		Database DB = new Database();
		this.field1 = f1;
		sql = "delete from AssetsType where TypeID = " + field1 + "";

		try {
			DB.OpenConn();
			DB.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "�ɹ��ĸɵ���һ�����ݣ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "ľ��ɾ��~", "����",
					JOptionPane.ERROR_MESSAGE);

		} finally {
			DB.closeStmt();
			DB.closeConn();
		}
	}

	/**
	 * @param ����Ų�ѯ
	 * 
	 */
	public String[] search(String f1) {
		Database DB = new Database();
		this.field1 = f1;
		String[] s = new String[7];
		sql = "select * from AssetsType Where TypeID = " + field1 + "";
		try {
			DB.OpenConn();
			rs = DB.executeQuery(sql);
			if (rs.next()) {
				s[0] = rs.getString("TypeID");
				s[1] = rs.getString("B_Type");
				s[2] = rs.getString("S_Type");
			} else
				s = null;
		} catch (Exception e) {

		} finally {
			DB.closeStmt();
			DB.closeConn();
		}

		return s;

	}

	/**
	 * ��ѯ���м�¼
	 */
	public String[][] searchAll() {
		Database DB = new Database();
		String[][] sn = null;
		int row = 0;
		int i = 0;
		sql = "select * from AssetsType order by TypeID";
		try {
			DB.OpenConn();
			rs = DB.executeQuery(sql);
			if (rs.last()) {
				row = rs.getRow();
			}
			if (row == 0) {
				sn = new String[1][6];
				sn[0][0] = "  ";
				sn[0][1] = "  ";
				sn[0][2] = "  ";
			} else {
				sn = new String[row][6];
				rs.first();
				rs.previous();
				while (rs.next()) {
					sn[i][0] = rs.getString("TypeID");
					sn[i][1] = rs.getString("B_Type");
					sn[i][2] = rs.getString("S_Type");
					i++;
				}
			}
		} catch (Exception e) {

		} finally {
			DB.closeStmt();
			DB.closeConn();

		}
		return null;

	}
	

}
