package com.argus.web.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {
	public static List<String> asList(String ...params){
		
		if(params==null){
			return null;
		}
		
		List<String> result=new ArrayList<String>();
		for(int i=0;i<params.length;i++){
			result.add(params[i]);
		}
		
		return result;
	}
	
	public static String toSemicolonString(List<String> list){
		if(list==null || list.size()==0){
			return null;
		}
		
		StringBuffer result=new StringBuffer();
		for(String str:list){
			result.append(str).append(";");
		}
		
		return result.toString();
	}
}
