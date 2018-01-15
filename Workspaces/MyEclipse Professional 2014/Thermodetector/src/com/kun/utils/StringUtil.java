package com.kun.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	
	public static boolean isEmpty(String str){
		if("".equals(str)||str==null){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean isNotEmpty(String str){
		if(!"".equals(str) && str!=null){
			return true;
		}else{
			return false;
		}
	}
	
	 public static boolean isMatches(String bot){
		  boolean flag=false;
		  try{
		   String regex="^[1-9]+[0-9]*$";
		   Pattern p=Pattern.compile(regex);
		   Matcher m=p.matcher(bot);
		   if(m.find()){
//		     System.out.println("successss");
		    return true;
		   }else{
//		    System.out.println("falsss");
		   }
		  }catch(Exception e){
		   e.printStackTrace();
		  }
		  return flag;
		}
}
