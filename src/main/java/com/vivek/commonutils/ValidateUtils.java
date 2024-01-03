package com.vivek.commonutils;

public class ValidateUtils {
	
	public static boolean isStringEmpty(String s) {
		
		return s==null || s.isBlank();
	}
	
	public static boolean isEmpty(Object object) {
		return object==null?true:false;
		
	}

}
