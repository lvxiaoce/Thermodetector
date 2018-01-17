package com.kun.utils;

import java.util.ArrayList;
import java.util.List;

import com.kun.bean.TherInfBean;
/**
 *  客户端分页工具类
 * @author 
 *
 */
public class PageUtils {
	/**
	 * 根据总数据和每页的数据量算出总的页数
	 * @param allData 所有的数据
	 * @param itemsData 一页有几条数据
	 * @return
	 */
	public static int getAllNumberPages(int allData,int itemsData){
		int allNumberPages = 0;
		if(allData%itemsData == 0){
			allNumberPages = allData/itemsData;
		}else{
			allNumberPages = allData/itemsData + 1;
		}
		
		return allNumberPages;
	}
	
	/**
	 * 获得每一页的数据
	 * @param list 数据库返回的总数据
	 * @param nowPage 当前页数
	 * @param eachData 每页几条数据
	 * @param totalPage 总页数
	 * @return
	 */
	public static List<TherInfBean> getEachPageList(List<TherInfBean> list,int nowPage,int eachData,int totalPage){
		
		List<TherInfBean> eachPageList = new ArrayList<TherInfBean>();
		//计算数组从哪里开始
		int nowIndex = (nowPage-1)*eachData;

		if(list.isEmpty()){
			return eachPageList;
		}
		
		int dataNumber = nowIndex+eachData;
		//如果当前页数等于总页数,算出剩余的数据
		if(nowPage == totalPage){
			dataNumber = list.size();
		}
		
		for(int i=nowIndex;i<dataNumber;i++){
			TherInfBean tBean = list.get(i);
			eachPageList.add(tBean);
		}
		return eachPageList;
	}
}
