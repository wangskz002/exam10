package com.bw.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.bw.utils.DateUtils;
//3)编写对应的Junit测试类进行测试。10分。 (每个方法完整测试通过给2分)
public class DemoTest {

	@Test
	public void getAge() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date parse = sdf.parse("1996-06-06");
		int age = DateUtils.getAge(parse);
		System.out.println(age);
	}
	
	@Test
	public void getDateByMonthInit () throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date parse = sdf.parse("2019-06-06 23:12:05");
		 Date dateByMonthInit = DateUtils.getDateByMonthInit(parse);
		System.out.println(sdf.format(dateByMonthInit));
	}
	
	@Test
	public void getDateByMonthLast () throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date parse = sdf.parse("2019-07-10 23:12:05");
		 Date dateByMonthInit = DateUtils.getDateByMonthLast(parse);
		System.out.println(sdf.format(dateByMonthInit));
	}
	
	@Test
	public void getDaysByFuture () throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date parse = sdf.parse("2020-07-10 23:12:05");
	 int daysByFuture = DateUtils.getDaysByFuture(parse);
		System.out.println(daysByFuture);
	}
	
	@Test
	public void getDaysByDeparted () throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date parse = sdf.parse("2019-11-10 23:12:05");
	 int daysByFuture = DateUtils.getDaysByDeparted(parse);
		System.out.println(daysByFuture);
	}
}

