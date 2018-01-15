package com.kun.actionImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kun.action.HeightAction;
import com.kun.action.TestAction;
import com.kun.bean.TherInfBean;
import com.kun.utils.RandomUtils;

public class TestActionImpl implements TestAction {

	private HeightAction hiAction = new HeightActionImpl();
	private RandomUtils ranUtil = new RandomUtils();
	
	public List<TherInfBean> RandomTestList() {
		// TODO Auto-generated method stub
		List<TherInfBean> list = new ArrayList<TherInfBean>();
		
		List<String> listHi = hiAction.selectHeightAll();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		
		for (int i = 0; i < listHi.size(); i++) {
			TherInfBean tBean = new TherInfBean();
			String time = df.format(new Date());
			tBean.setTime(time);
			tBean.setHeight(listHi.get(i));
			String itemStr = ranUtil.testRandomNumber(Double.parseDouble(listHi.get(i)));
			System.out.println(time+"时间的第"+i+"条"+itemStr);
		}
		return list;
	}

}
