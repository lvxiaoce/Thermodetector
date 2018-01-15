package com.kun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kun.bean.TherInfBean;
import com.kun.utils.DbUtil;
public class TherInfDao {
	
	/**
	 * 获得sys_therinf的数据
	 * 
	 * @param conn
	 * @param UserBean
	 * @return
	 * @throws Exception
	 */
	public List<TherInfBean> selectTherListAll(){
		List<TherInfBean> list = new ArrayList<TherInfBean>();
		Connection conn = null;
		String sql = "select * from sys_therinf left join sys_time on sys_therinf.time_id = sys_time.id "
				+ "left join sys_height on sys_therinf.height_id = sys_height.id;";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DbUtil.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				TherInfBean tBean = new TherInfBean();
				tBean.setTime(rs.getString("time"));
				tBean.setHeight(rs.getString("height"));
				tBean.setSouth3(rs.getString("south3"));
				tBean.setSouth2(rs.getString("south2"));
				tBean.setSouth1(rs.getString("south1"));
				tBean.setCore(rs.getString("core"));
				tBean.setNorth1(rs.getString("north1"));
				tBean.setNorth2(rs.getString("north2"));
				tBean.setNorth3(rs.getString("north3"));
				tBean.setEast3(rs.getString("east3"));
				tBean.setEast2(rs.getString("east2"));
				tBean.setEast1(rs.getString("east1"));
				tBean.setWest1(rs.getString("west1"));
				tBean.setWest2(rs.getString("west2"));
				tBean.setWest3(rs.getString("west3"));
				list.add(tBean);
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
