package com.kun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kun.bean.UserBean;
import com.kun.utils.DbUtil;

public class TimeDao {
	
	/**
	 * 获得sys_time的数据
	 * 
	 * @param conn
	 * @param UserBean
	 * @return
	 * @throws Exception
	 */
	public List<String> selectTimeAll(){
		List<String> list = new ArrayList<String>();
		Connection conn = null;
		String sql = "select * from sys_time";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DbUtil.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("time"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtil.closeConn(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	/**
	 * 新增时间记录
	 * @param UserBean
	 * @return
	 */
	public boolean addTime(String time){
		Connection conn = null;
		boolean flag = false;
		try {
			conn = DbUtil.getConn();
			String sql = "insert into sys_time values(null,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, time);
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
	
	/**
	 * 通过时间戳获得时间唯一id
	 * 
	 * @param conn
	 * @param UserBean
	 * @return
	 * @throws Exception
	 */
	public int selectTimeIdByTi(String time){
		int timeId = 0;
		Connection conn = null;
		String sql = "select * from sys_time where time=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DbUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,time);
			rs = ps.executeQuery();
			if (rs.next()) {
				timeId = rs.getInt("id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtil.closeConn(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return timeId;
	}
}
