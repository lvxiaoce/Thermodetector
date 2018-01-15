package com.kun.action;

import java.util.List;

public interface TimeAction {
	
	public List<String> selectTimeAll();
	
	public boolean addTime(String time);
	
	public int selectTimeIdByTi(String time);
}
