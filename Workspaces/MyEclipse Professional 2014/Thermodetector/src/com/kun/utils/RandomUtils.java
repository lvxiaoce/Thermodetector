package com.kun.utils;

import java.text.DecimalFormat;

/**
 * 测试数据来源
 * @author funinhr
 *
 */
public class RandomUtils {
	public String testRandomNumber(double thermodete){
		String sum = "";
		for (int i = 0; i <=13; i++) {  
	        double s = (0+Math.random()*(20))*(Math.random()>0.5?1:-1);
	        DecimalFormat df = new DecimalFormat("#.0");
	        if(i==0){
	        	sum += ">+00"+df.format(thermodete+s);
	        }else if(i>0 && i<14){
	        	sum += "+00"+df.format(thermodete+s);
	        }
	    }
		return sum;
	}
}
