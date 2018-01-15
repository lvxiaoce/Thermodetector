package com.kun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
}
