package com.kun.actionImpl;

import java.util.List;

import com.kun.action.TimeAction;
import com.kun.dao.TimeDao;

public class TimeActionImpl implements TimeAction {
	private TimeDao tDao = new TimeDao();

	public List<String> selectTimeAll() {
		// TODO Auto-generated method stub
		return tDao.selectTimeAll();
	}

	public boolean addTime(String time) {
		// TODO Auto-generated method stub
		return tDao.addTime(time);
	}

	public int selectTimeIdByTi(String time) {
		// TODO Auto-generated method stub
		return tDao.selectTimeIdByTi(time);
	}

}
