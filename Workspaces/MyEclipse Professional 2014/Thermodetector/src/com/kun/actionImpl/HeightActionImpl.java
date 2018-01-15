package com.kun.actionImpl;

import java.util.List;

import com.kun.action.HeightAction;
import com.kun.dao.HeightDao;

public class HeightActionImpl implements HeightAction {

	private HeightDao hDao = new HeightDao();
	
	public List<String> selectHeightAll() {
		// TODO Auto-generated method stub
		return hDao.selectHeightAll();
	}

	public int selectHeightIdByHi(String height) {
		// TODO Auto-generated method stub
		return hDao.selectHeightIdByHi(height);
	}

}
