package com.zhiyou.udfs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.hadoop.hive.ql.exec.UDF;

public class LogDateConvert extends UDF {

	public static final SimpleDateFormat format = 
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	// 输入数据的日期格式时代有localSrc和市区的, localSrc适应未,
	// 可以使用英文格式来进行匹配装换
	public static final SimpleDateFormat srcFormat = 
			new SimpleDateFormat(
					"[dd/MMM/yyyy:HH:mm:ss Z]",Locale.ENGLISH);

	
	
	public String evaluate(String dateStr) {

		try {
			Date oldDate = srcFormat.parse(dateStr);
			return format.format(oldDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	
	
	
	public static void main(String[] args) {
		LogDateConvert logDateConvert = new LogDateConvert();
		System.out.println(
				logDateConvert
				.evaluate("[14/Jun/2014:10:30:14 -0400]"));
	}
	
}
