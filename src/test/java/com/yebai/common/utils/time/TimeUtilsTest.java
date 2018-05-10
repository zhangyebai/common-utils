package com.yebai.common.utils.time;

import org.junit.Test;

import java.time.LocalDateTime;

public class TimeUtilsTest {
	
	@Test
	public void listLatestDate() {
		System.out.println(TimeUtil.listLatestDateAsString(20));
	}
	
	@Test
	public void listLatestDateAsString() {
	}
	
	@Test
	public void listLatestDateAsString1() {
	}
	
	@Test
	public void beginDateTimeOfDay() {
	}
	
	@Test
	public void beginDateTimeOfDay1() {
	}
	
	@Test
	public void endDateTimeOfDay() {
	}
	
	@Test
	public void endDateTimeOfDay1() {
	}
	
	@Test
	public void goneMinutes() {
		System.out.println(TimeUtil.goneMinutes(LocalDateTime.of(2018, 04, 04, 12, 00, 00)));
		assert 256 == TimeUtil.goneMinutes(LocalDateTime.of(2018, 04, 04, 12, 00, 00));
	}
	
	@Test
	public void goneMinutes1() {
	}
	
	@Test
	public void goneHours() {
	}
	
	@Test
	public void goneHours1() {
	}
	
	@Test
	public void goneDays() {
	}
	
	@Test
	public void goneDays1() {
	}
	
	@Test
	public void goneMonths() {
	}
	
	@Test
	public void goneMonths1() {
	}
	
	@Test
	public void parseDateTime() {
	}
	
	@Test
	public void parseDateTime1() {
	}
	
	@Test
	public void parseDate() {
	}
	
	@Test
	public void parseDate1() {
	}
	
	@Test
	public void parseTime() {
	}
	
	@Test
	public void parseTime1() {
	}
}