package com.kun.actionImpl;

import java.util.List;

import com.kun.action.TherInfAction;
import com.kun.bean.TherInfBean;
import com.kun.dao.TherInfDao;

public class TherInfActionImpl implements TherInfAction {

	private TherInfDao tDao = new TherInfDao();
	
	public List<TherInfBean> selectTherListAll() {
		return tDao.selectTherListAll();
	}

	public boolean addTherInf(TherInfBean tBean) {
		// TODO Auto-generated method stub
		return tDao.addTherInf(tBean);
	}

}
