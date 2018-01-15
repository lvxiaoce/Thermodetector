package com.kun.actionImpl;

import com.kun.action.UserAction;
import com.kun.bean.UserBean;
import com.kun.dao.UserDao;

public class UserActionImpl implements UserAction {
	private UserDao uDao = new UserDao();
	
	public boolean login(UserBean UserBean) {
		return uDao.login(UserBean);
	}

	public boolean register(UserBean UserBean) {
		return uDao.register(UserBean);
	}

}
