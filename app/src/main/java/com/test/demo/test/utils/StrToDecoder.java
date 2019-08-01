package com.test.demo.test.utils;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class StrToDecoder {

	public static String strToDecoder1(String str){
		try {
			return URLDecoder.decode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String strToDecoder2(String str){
		try {
			return new String(str.getBytes("utf-8"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String strToDecoder3(String str){
		try {
			return URLDecoder.decode(str, "GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
