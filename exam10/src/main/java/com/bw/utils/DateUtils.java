package com.bw.utils;


import java.util.Calendar;
import java.util.Date;
//2)正确实现5个方法， 不得有bug，要求性能高。50分(每个方法10分)
public class DateUtils {

	public static int getAge (Date src) {
		Date d = new Date();
		long time = d.getTime();
		long time2 = src.getTime();
		int i  = (int)((time - time2)/1000/60/60/24/365);
		return i;
	}
	//根据传入的参数获取该日期的月初日期，
	//例如给定的日期为“2019-09-19 19:29:39”，返回“2019-09-01 00:00:00”
	public static Date getDateByMonthInit (Date src) {
		Calendar instance = Calendar.getInstance();
		instance.setTime(src);
		instance.set(Calendar.DAY_OF_MONTH, 1);
		instance.set(Calendar.HOUR_OF_DAY, 0);
		instance.set(Calendar.MINUTE, 0);
		instance.set(Calendar.SECOND, 0);
		Date time = instance.getTime();
		return time;
		
	}
	//根据传入的参数获取该日器的月末日期，例如给定的日期为“2019-09-19 19:29:39”，
	//返回“2019-09-30 23:59:59”，注意月大月小以及闰年。
	public static Date getDateByMonthLast(Date src) {
		Calendar instance = Calendar.getInstance();
		instance.setTime(src);
		int j = instance.get(Calendar.YEAR);
		int i = instance.get(Calendar.MONTH);
		System.out.println(i);
		if(i == 1){
			if(j % 4 == 0 && j % 100 != 0 || j % 400 == 0 ){
				instance.set(Calendar.DAY_OF_YEAR, 29);
			}else{
				instance.set(Calendar.DAY_OF_YEAR, 28);
			}
		}
		switch (i+1) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 11:
			instance.set(Calendar.DAY_OF_MONTH, 31);
			break;
		default:
			instance.set(Calendar.DAY_OF_MONTH, 30);
			break;
		}
		instance.set(Calendar.HOUR_OF_DAY, 23);
		instance.set(Calendar.MINUTE, 59);
		instance.set(Calendar.SECOND, 59);
		
		Date time = instance.getTime();
		return time;
			
		
		
	}
	
	//求未来日期离今天还剩的天数
	public static int getDaysByFuture (Date future) {
		Calendar instance = Calendar.getInstance();
		instance.setTime(future);
		Calendar now = Calendar.getInstance();
		if(instance.before(now)){
			throw new IllegalArgumentException();
		}
		Date d = new Date();
		long time2 = d.getTime();
		long time = future.getTime();
		int i  = (int)((time -time2)/1000/60/60/24);
		return i;
		
	}
	//求过去日期离今天过去的天数
	public static int getDaysByDeparted (Date departed) {
		Calendar instance = Calendar.getInstance();
		instance.setTime(departed);
		Calendar now = Calendar.getInstance();
		if(now.before(instance)){
			throw new IllegalArgumentException();
		}
		Date d = new Date();
		long time2 = d.getTime();
		long time = departed.getTime();
		int i  = (int)((time2 -time)/1000/60/60/24);
		return i;
		}
	
}
