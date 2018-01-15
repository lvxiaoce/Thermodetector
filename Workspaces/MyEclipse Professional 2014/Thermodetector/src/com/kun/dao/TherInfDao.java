package com.kun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kun.action.HeightAction;
import com.kun.action.TimeAction;
import com.kun.actionImpl.HeightActionImpl;
import com.kun.actionImpl.TimeActionImpl;
import com.kun.bean.TherInfBean;
import com.kun.bean.UserBean;
import com.kun.utils.DbUtil;
public class TherInfDao {
	
	private HeightAction hAction = new HeightActionImpl();
	private TimeAction tAction = new TimeActionImpl();
	
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
	
	/**
	 * 添加温度数据
	 * @param TherInfBean
	 * @return
	 */
	public boolean addTherInf(TherInfBean tBean){
		Connection conn = null;
		boolean flag = false;
		
//		boolean tflag = tAction.addTime(tBean.getTime());
//		
//		if(!tflag){
//			return flag;
//		}
		
		int heightId = hAction.selectHeightIdByHi(tBean.getHeight());
		
		int timeId = tAction.selectTimeIdByTi(tBean.getTime());
		
		try {
			conn = DbUtil.getConn();
			String sql = "insert into sys_therinf values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, timeId);
			ps.setInt(2, heightId);
			ps.setString(3, tBean.getSouth3());
			ps.setString(4, tBean.getSouth2());
			ps.setString(5, tBean.getSouth1());
			ps.setString(6, tBean.getCore());
			ps.setString(7, tBean.getNorth1());
			ps.setString(8, tBean.getNorth2());
			ps.setString(9, tBean.getNorth3());
			ps.setString(10, tBean.getEast3());
			ps.setString(11, tBean.getEast2());
			ps.setString(12, tBean.getEast1());
			ps.setString(13, tBean.getWest1());
			ps.setString(14, tBean.getWest2());
			ps.setString(15, tBean.getWest3());
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
