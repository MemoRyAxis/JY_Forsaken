package com.dataOperate;

import java.sql.*;

import javax.swing.JOptionPane;

public class PersonBean {
	String sql;
	ResultSet rs = null;

	String field1; // personID
	String field2; // Name
	String field3; // sex
	String field4; // dept
	String field5; // job
	String field6; // other

	String colName;// 列名
	String colValue;// 列值
	String volValue2;// 列值

	/**
	 * 添加信息
	 */
	public void add(String f1, String f2, String f3, String f4, String f5,
			String f6) {
		Database DB = new Database();

		this.field1 = f1;
		this.field2 = f2;
		this.field3 = f3;
		this.field4 = f4;
		this.field5 = f5;
		this.field6 = f6;

		if (field2 == null || field2.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入人员名称", "错误",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else if (field3 == null || field3.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入性别", "错误",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else if (field4 == null || field4.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入工作部门", "错误",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			sql = "insert into Person(PersonID,Name,Sex,Dept,Job,Other) values ('"
					+ field1
					+ "','"
					+ field2
					+ "','"
					+ field3
					+ "','"
					+ field4
					+ "','" + field5 + "','" + field6 + "')";
			try {
				DB.OpenConn();
				DB.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "哇喔，成功的添加了记录！");
			} catch (Exception e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "啊哦，保存失败了~", "错误",
						JOptionPane.ERROR_MESSAGE);
			} finally {
				DB.closeStmt();
				DB.closeConn();
			}
		}

	}

	/**
	 * 修改信息
	 */
	public void modify(String f1, String f2, String f3, String f4, String f5,
			String f6) {
		Database DB = new Database();

		this.field1 = f1;
		this.field2 = f2;
		this.field3 = f3;
		this.field4 = f4;
		this.field5 = f5;
		this.field6 = f6;

		if (field2 == null || field2.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入人员名称", "错误",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else if (field3 == null || field3.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入性别", "错误",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else if (field4 == null || field4.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入工作部门", "错误",
					JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			sql = "update Person set name = '" + field2 + "', Sex = '" + field3
					+ "', Dept = '" + field4 + "', Job = '" + field5
					+ "', Other = '" + field6 + "' where PersonID = " + field1
					+ "";

			try {
				DB.OpenConn();
				DB.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "成功修改一条记录，欧耶！");
			} catch (Exception e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "啊哦，更新失败了~", "错误",
						JOptionPane.ERROR_MESSAGE);

			} finally {
				DB.closeStmt();
				DB.closeConn();
			}

		}

	}

	/**
	 * 删除信息
	 */
	public void delete(String f1) {
		Database DB = new Database();
		this.field1 = f1;

		sql = "delete from Person where PersonID = " + field1 + "";
		try {
			DB.OpenConn();
			DB.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "欧耶，成功干掉了一个数据！");
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "呃，没删掉~", "错误",
					JOptionPane.ERROR_MESSAGE);
		} finally {
			DB.closeStmt();
			DB.closeConn();
		}

	}

	/**
	 * 按编号查询
	 */
	public String[] search(String f1) {
		Database DB = new Database();
		this.field1 = f1;
		String[] s = new String[5];
		sql = "select * from Person where PersonID = " + field1 + "";
		try {
			DB.OpenConn();
			rs = DB.executeQuery(sql);
			if (rs.next()) {
				s[0] = rs.getString("Name");
				s[1] = rs.getString("Sex");
				s[2] = rs.getString("Dept");
				s[3] = rs.getString("Job");
				s[4] = rs.getString("Other");
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
	 * 为设备管理者提供查询
	 */
	public String[] searchAllName() {

		Database DB = new Database();
		String[] sn = null;
		int row = 0;
		int i = 0;
		sql = "select personid,name from person order by personid";
		try {
			DB.OpenConn();
			rs = DB.executeQuery(sql);
			if (rs.last()) {
				row = rs.getRow();
			}
			if (row == 0) {
				sn[0] = "";
				sn[1] = "";
			} else {
				sn = new String[row];
				rs.first();
				rs.previous();
				while (rs.next()) {
					sn[i] = rs.getString("personid") + "-"
							+ rs.getString("name");
					i++;
				}
			}
		} catch (Exception e) {
		} finally {
			DB.closeStmt();
			DB.closeConn();

		}
		return sn;

	}

	/**
	 * 人员信息综合查询（查询所有记录）
	 */
	public String[][] searchAll() {
		Database DB = new Database();
		String[][] sn = null;
		int row = 0;
		int i = 0;
		sql = "select * from Person order by PersonID";
		try {
			DB.OpenConn();
			rs = DB.executeQuery(sql);
			if (rs.last()) {
				row = rs.getRow();
			}
			if (row == 0) {
				sn = null;
			} else {
				sn = new String[row][6];
				rs.first();
				rs.previous();
				while (rs.next()) {
					sn[i][0] = rs.getString("PersonID");
					sn[i][1] = rs.getString("Name");
					sn[i][2] = rs.getString("Sex");
					sn[i][3] = rs.getString("Dept");
					sn[i][4] = rs.getString("Job");
					sn[i][5] = rs.getString("Other");
					i++;
				}
			}
		} catch (Exception e) {

		} finally {
			DB.closeStmt();
			DB.closeConn();

		}
		return sn;

	}

	/**
	 * 设备信息查询（按ID）
	 */
	public String[][] searchAll(String f1) {
		this.field1 = f1;
		Database DB = new Database();
		String[][] sn = null;
		int row = 0;
		int i = 0;
		sql = "select * from Person where PersonID=" + field1
				+ " order by PersonID";
		try {
			DB.OpenConn();
			rs = DB.executeQuery(sql);
			if (rs.last()) {
				row = rs.getRow();
			}
			if (row == 0) {
				sn = null;
			} else {
				sn = new String[row][6];
				rs.first();
				rs.previous();
				while (rs.next()) {
					sn[i][0] = rs.getString("PersonID");
					sn[i][1] = rs.getString("Name");
					sn[i][2] = rs.getString("Sex");
					sn[i][3] = rs.getString("Dept");
					sn[i][4] = rs.getString("Job");
					sn[i][5] = rs.getString("Other");
					i++;
				}
			}
		} catch (Exception e) {

		} finally {
			DB.closeStmt();
			DB.closeConn();
		}
		return sn;

	}

	/**
	 * 获得新的ID
	 */
	public int getId() {

		Database DB = new Database();
		int ID = 1;
		sql = "select max(PersonID) from Person";
		try {
			DB.OpenConn();
			rs = DB.executeQuery(sql);
			if (rs.next()) {
				ID = rs.getInt(1) + 1;
			} else {
				ID = 1;
			}
		} catch (Exception e) {

		} finally {
			DB.closeStmt();
			DB.closeConn();
		}
		return ID;
	}

	/**
	 * 获得表中所有编号
	 */
	public String[] getAllId() {
		String[] s = null;
		int row = 0;
		int i = 0;
		Database DB = new Database();
		sql = "select PersonID from Person";
		try {
			DB.OpenConn();
			rs = DB.executeQuery(sql);
			if (rs.last()) {
				row = rs.getRow();
			}
			if (row == 0) {
				s = null;
			} else {
				s = new String[row];
				rs.first();
				rs.previous();
				while (rs.next()) {
					s[i] = rs.getString(1);
					i++;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DB.closeStmt();
			DB.closeConn();
		}
		return s;
	}

	/**
	 * 根据编号查询信息
	 */
	public String getPersonName(String f1) {
		Database DB = new Database();
		this.field1 = f1;
		String s = "";
		sql = "select name from Person where PersonID =" + field1 + "";
		try {
			DB.OpenConn();
			rs = DB.executeQuery(sql);
			if (rs.next()) {
				s = rs.getString("name");
			} else {
				s = null;
			}
		} catch (Exception e) {

		} finally {
			DB.closeStmt();
			DB.closeConn();
		}
		return s;
	}
}
