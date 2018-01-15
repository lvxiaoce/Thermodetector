package com.kun.actionImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kun.action.HeightAction;
import com.kun.action.TestAction;
import com.kun.bean.TherInfBean;
import com.kun.utils.RandomUtils;
import com.kun.utils.StringUtil;

public class TestActionImpl implements TestAction {

	private HeightAction hiAction = new HeightActionImpl();
	private RandomUtils ranUtil = new RandomUtils();
	
	public List<TherInfBean> RandomTestList() {
		// TODO Auto-generated method stub
		List<TherInfBean> list = new ArrayList<TherInfBean>();
		
		List<String> listHi = hiAction.selectHeightAll();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		
		String itemStr = "";
		
		String time = df.format(new Date());
		
		for (int i = 0; i < listHi.size(); i++) {
			
			TherInfBean tBean = new TherInfBean();
			
			tBean.setTime(time);
			
			tBean.setHeight(listHi.get(i));
			
			itemStr = ranUtil.testRandomNumber(Double.parseDouble(listHi.get(i)));
			
			itemStr = itemStr.substring(2,itemStr.length());
			
			String[] itemTher = itemStr.split("\\+");
			
			tBean.setSouth3(itemTher[0].substring(2,itemTher[0].length()));
			tBean.setSouth2(itemTher[1].substring(2,itemTher[1].length()));
			tBean.setSouth1(itemTher[2].substring(2,itemTher[2].length()));
			tBean.setCore(itemTher[3].substring(2,itemTher[3].length()));
			tBean.setNorth1(itemTher[4].substring(2,itemTher[4].length()));
			tBean.setNorth2(itemTher[5].substring(2,itemTher[5].length()));
			tBean.setNorth3(itemTher[6].substring(2,itemTher[6].length()));
			tBean.setEast3(itemTher[7].substring(2,itemTher[7].length()));
			tBean.setEast2(itemTher[8].substring(2,itemTher[8].length()));
			tBean.setEast1(itemTher[9].substring(2,itemTher[9].length()));
			tBean.setWest1(itemTher[10].substring(2,itemTher[10].length()));
			tBean.setWest2(itemTher[11].substring(2,itemTher[11].length()));
			tBean.setWest3(itemTher[12].substring(2,itemTher[12].length()));
			
			list.add(tBean);
		}
		return list;
	}

}
