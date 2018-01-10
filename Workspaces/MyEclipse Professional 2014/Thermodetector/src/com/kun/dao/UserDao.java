package com.kun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.kun.bean.UserBean;
import com.kun.utils.DbUtil;


public class UserDao {

	/**
	 * 登录验证
	 * 
	 * @param conn
	 * @param UserBean
	 * @return
	 * @throws Exception
	 */
	public static boolean login(UserBean UserBean){
		Connection conn = null;
		boolean flag = false;
		try {
			conn = DbUtil.getConn();
			String sql = "select * from sys_user where username=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, UserBean.getUsername());
			ps.setString(2, UserBean.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				DbUtil.closeConn(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	/**
	 * 用户注册
	 * @param UserBean
	 * @return
	 */
	public static boolean register(UserBean UserBean){
		Connection conn = null;
		boolean flag = false;
		try {
			conn = DbUtil.getConn();
			String sql = "insert into sys_user values(null,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, UserBean.getUsername());
			ps.setString(2, UserBean.getPassword());
			if (ps.executeUpdate()>=1) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				DbUtil.closeConn(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
}
