package com.ecan.util;

public class StringUtil {

	public static String defaultString(String str,String dufaultStr){
		if(str == null){
			return dufaultStr;
		}
		return str;
	} 
	
}
