package com.zhiyou.udfs;

import org.apache.hadoop.hive.ql.exec.UDF;


public class GetProduct extends UDF{

	public String evaluate(String requestStr){
		
		String arr = requestStr.split("product/")[1];
		
		String product = arr.split("%")[0];
		
		return product;
	}
	
	
	
}
