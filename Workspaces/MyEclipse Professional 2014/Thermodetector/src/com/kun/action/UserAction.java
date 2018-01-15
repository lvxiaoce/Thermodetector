package com.kun.action;

import com.kun.bean.UserBean;

public interface UserAction {
	/**
	 * 登录验证
	 * @param UserBean
	 * @return
	 */
	public boolean login(UserBean UserBean);
	/**
	 * 注册
	 * @param UserBean
	 * @return
	 */
	public boolean register(UserBean UserBean);
}
