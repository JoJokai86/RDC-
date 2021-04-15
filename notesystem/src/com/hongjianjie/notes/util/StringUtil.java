package com.hongjianjie.notes.util;

/**
 * 工具类判断字符串是否为空
 * @author JJ
 *
 */
public class StringUtil {
	public static boolean isEmpty(String str){
		if(str==null || "".equals(str.trim())){
			return true;
		}
		return false;
	}
}
