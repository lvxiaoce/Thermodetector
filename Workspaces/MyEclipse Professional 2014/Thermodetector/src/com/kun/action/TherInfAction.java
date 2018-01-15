package com.kun.action;

import java.util.List;

import com.kun.bean.TherInfBean;

public interface TherInfAction {
	/**
	 * 获得sys_therinf的数据
	 * 
	 * @param conn
	 * @param UserBean
	 * @return
	 * @throws Exception
	 */
	public List<TherInfBean> selectTherListAll();
	
	public boolean addTherInf(TherInfBean tBean);
	
	public List<TherInfBean> serchTimeTherListAll(String time);
	
	public List<TherInfBean> serchHeightTherListAll(String height);
}
