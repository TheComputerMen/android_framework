package com.jd.framework.utils;

public class JStringUtil {

	public static boolean isNotBlack(String msg){
		if(msg == null || msg.trim().length() == 0){
			return false;
		}
		return true;
	}
}
