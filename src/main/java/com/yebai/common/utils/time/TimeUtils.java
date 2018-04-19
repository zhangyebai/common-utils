package com.yebai.common.utils.time;

import com.yebai.common.utils.config.Config;
import org.apache.commons.lang3.StringUtils;
//import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.google.common.base.Preconditions.checkArgument;

/****************************************************
 * @author Zhang Yebai
 * @description 
 * @date 2018/4/4 16:11
 ****************************************************/
public class TimeUtils {
	private TimeUtils(){}

	public static LocalDateTime tidy(LocalDateTime dateTime, int hours){
		if(null == dateTime){
			dateTime = LocalDateTime.now();
		}

		LocalDateTime tidyTemp = dateTime.plusHours(-hours);
		LocalDateTime tidyDateTime = LocalDateTime.of(tidyTemp.toLocalDate(),
				LocalTime.of(tidyTemp.getHour(), 0, 0));
		return tidyDateTime;
	}

	public static String tidy(LocalDateTime dateTime, String pattern, int hours){
		if(null == pattern || StringUtils.isBlank(pattern.trim())){
			pattern = Config.Time.DATE_TIME_FORMAT_PATTERN;
		}
		return TimeUtils.tidy(dateTime, hours).format(DateTimeFormatter.ofPattern(pattern));
	}

	public static String tidyNow(int hours){
		return TimeUtils.tidy(null, null, hours);
	}

	public static String now(String pattern){
		return LocalDateTime
				.now()
				.format(DateTimeFormatter.ofPattern(null == pattern ? Config.Time.DATE_TIME_FORMAT_PATTERN : pattern));
	}

	public static String now(){
		return TimeUtils.now(null);
	}
	
	/****************************************************
	 * @author Zhang Yebai
	 * @description 获取包括今天在内的往前推算的 size - 1 天
	 * @note null
	 * @date 2018/4/3 11:17
	 * @return 以日期形式返回
	 ****************************************************/
	public static List<LocalDate> listLatestDate(int size){
		checkArgument(size > 0);
		final LocalDate today = LocalDate.now();
		return IntStream.range(0, size).mapToObj(index -> today.plusDays(index - size + 1)).collect(Collectors.toList());
	}
	
	
	public static List<String> listLatestDateAsString(int size){
		return TimeUtils.listLatestDateAsString(size, null);
	}
	
	/****************************************************
	 * @author Zhang Yebai
	 * @description 获取包括今天在内的往前推算的 size - 1 天
	 * @note null
	 * @date 2018/4/3 12:48
	 * @return 以给定正则表达式形式返回，如果正则为空，使用默认的日期格式
	 ****************************************************/
	public static List<String> listLatestDateAsString(int size, String datePattern){
		checkArgument(size > 0);
		final LocalDate today = LocalDate.now();
		final DateTimeFormatter dateTimeFormatter =
				DateTimeFormatter.ofPattern(null == datePattern ? Config.Time.DATE_FORMAT_PATTERN : datePattern);
		return IntStream.range(0, size)
				.mapToObj(index -> today.plusDays(index - size + 1).format(dateTimeFormatter))
				.collect(Collectors.toList());
	}
	
	/****************************************************
	 * @author Zhang Yebai
	 * @description 获取指定的日期当天的开始时间，如果指定日期为空则表示今天的开始时间
	 * @note null
	 * @date 2018/4/3 12:49
	 * @return	以日期-时间形式返回某天的开始时间
	 ****************************************************/
	public static LocalDateTime beginDateTimeOfDay(LocalDate date){
		return LocalDateTime.of(null == date ? LocalDate.now() : date, LocalTime.MIN);
	}
	
	/****************************************************
	 * @author Zhang Yebai
	 * @description 获取指定的日期当天的开始时间，如果指定日期为空则表示今天的开始时间
	 * @note null
	 * @date 2018/4/3 12:03
	 * @return   以给定日期格式返回，如果不指定日期格式则按照默认日期格式返回
	 ****************************************************/
	public static String beginDateTimeOfDay(LocalDate date, String dateTimePattern){
		return TimeUtils.beginDateTimeOfDay(date)
				.format(DateTimeFormatter.ofPattern(null == dateTimePattern ? Config.Time.DATE_TIME_FORMAT_PATTERN : dateTimePattern));
	}
	
	/****************************************************
	 * @author Zhang Yebai
	 * @description @see <code>beginDateTimeOfDay</code>
	 * @note null
	 * @date 2018/4/3 12:52
	 * @return
	 ****************************************************/
	public static LocalDateTime endDateTimeOfDay(LocalDate date){
		return LocalDateTime.of(null == date ? LocalDate.now() : date, LocalTime.MAX);
	}
	
	
	/****************************************************
	 * @author Zhang Yebai
	 * @description @see beginDateTimeOfDay
	 * @note null
	 * @date 2018/4/3 12:52
	 * @return
	 ****************************************************/
	public static String endDateTimeOfDay(LocalDate date, String dateTimePattern){
		return TimeUtils.endDateTimeOfDay(date)
				.format(DateTimeFormatter.ofPattern(null == dateTimePattern ? Config.Time.DATE_TIME_FORMAT_PATTERN : dateTimePattern));
	}
	
	
	public static long goneMinutes(LocalDateTime begin){
		return TimeUtils.goneMinutes(begin, null);
	}
	
	/****************************************************
	 * @author Zhang Yebai
	 * @description 计算两个时间中间消逝的分钟数
	 * @note 结束时间可以为null, 如果为null则表示now
	 * @date 2018/4/3 12:52
	 * @return
	 ****************************************************/
	public static long goneMinutes(LocalDateTime begin, LocalDateTime end){
		checkArgument(null != begin);
		return ChronoUnit.MINUTES.between(begin, null == end ? LocalDateTime.now() : end);
	}
	
	
	public static long goneHours(LocalDateTime begin){
		return TimeUtils.goneHours(begin, null);
	}
	
	/****************************************************
	 * @author Zhang Yebai
	 * @description 计算两个时间中间消逝的小时数
	 * @note 结束时间可以为null, 如果为null则表示now
	 * @date 2018/4/3 12:52
	 * @return
	 ****************************************************/
	public static long goneHours(LocalDateTime begin, LocalDateTime end){
		checkArgument(null != begin);
		return ChronoUnit.HOURS.between(begin, null == end ? LocalDateTime.now() : end);
	}
	
	
	
	public static long goneDays(LocalDate begin){
		return TimeUtils.goneDays(begin, null);
	}
	
	/****************************************************
	 * @author Zhang Yebai
	 * @description 计算两个时间中间消逝的天数
	 * @note 结束时间可以为null, 如果为null则表示now
	 * @date 2018/4/3 12:52
	 * @return
	 ****************************************************/
	public static long goneDays(LocalDate begin, LocalDate end){
		checkArgument( null != begin);
		return ChronoUnit.DAYS.between(begin, null == end ? LocalDate.now() : end);
	}
	
	public static long goneMonths(LocalDate begin){
		return TimeUtils.goneMonths(begin, null);
	}
	
	/****************************************************
	 * @author Zhang Yebai
	 * @description 计算两个时间中间消逝的月数
	 * @note 结束时间可以为null, 如果为null则表示now
	 * @date 2018/4/3 12:52
	 * @return
	 ****************************************************/
	public static long goneMonths(LocalDate begin, LocalDate end){
		checkArgument(null != begin);
		return ChronoUnit.MONTHS.between(begin, null == end ? LocalDate.now() : end);
	}
	
	/****************************************************
	 * @author Zhang Yebai
	 * @description 从字符串中解析LocalDateTime, 默认使用<code>Config.Time.DATE_TIME_FORMAT_PATTERN</code>格式解析
	 * @note null
	 * @date 2018/4/8 16:32
	 * @return LocalDateTime
	 ****************************************************/
	public static LocalDateTime parseDateTime(String dateTime){
		return TimeUtils.parseDateTime(dateTime, null);
	}
	
	/****************************************************
	 * @author Zhang Yebai
	 * @description 从字符串中解析LocalDateTime, 如果pattern为null或者blank则默认使用<code>Config.Time.DATE_TIME_FORMAT_PATTERN</code>格式解析
	 * @note null
	 * @date 2018/4/8 16:34
	 * @return LocalDateTime
	 ****************************************************/
	public static LocalDateTime parseDateTime(String dateTime, String pattern){
		checkArgument(StringUtils.isNotBlank(dateTime));
		return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(null == pattern ? Config.Time.DATE_TIME_FORMAT_PATTERN : pattern));
	}
	
	/****************************************************
	 * @author Zhang Yebai
	 * @description 从字符串中解析LocalDate, 默认使用 <code>Config.Time.DATE_FORMAT_PATTERN</code>格式解析
	 * @note null
	 * @date 2018/4/8 16:32
	 * @return LocalDate
	 ****************************************************/
	public static LocalDate parseDate(String date){
		return TimeUtils.parseDate(date, null);
	}
	
	/****************************************************
	 * @author Zhang Yebai
	 * @description 从字符串中解析LocalDate, 如果pattern为null或者blank则默认使用 <code>Config.Time.DATE_FORMAT_PATTERN</code>格式解析
	 * @note null
	 * @date 2018/4/8 16:35
	 * @return LocalDate
	 ****************************************************/
	public static LocalDate parseDate(String date, String pattern){
		checkArgument(StringUtils.isNotBlank(date));
		return LocalDate.parse(date, DateTimeFormatter.ofPattern(null == pattern ? Config.Time.DATE_FORMAT_PATTERN : pattern));
	}
	
	/****************************************************
	 * @author Zhang Yebai
	 * @description 从字符串中解析LocalTime默认使用 <code>Config.Time.TIME_FORMAT_PATTERN</code>格式解析
	 * @note null
	 * @date 2018/4/8 16:36
	 * @return LocalTime
	 ****************************************************/
	public static LocalTime parseTime(String time){
		return TimeUtils.parseTime(time, null);
	}
	
	/****************************************************
	 * @author Zhang Yebai
	 * @description 从字符串中解析LocalTime,如果pattern为null or blank 则默认使用 <code>Config.Time.TIME_FORMAT_PATTERN</code>格式解析
	 * @note null
	 * @date 2018/4/8 16:36
	 * @return LocalTime
	 ****************************************************/
	public static LocalTime parseTime(String time, String pattern){
		checkArgument(StringUtils.isNotBlank(time));
		return LocalTime.parse(time, DateTimeFormatter.ofPattern(null == pattern ? Config.Time.TIME_FORMAT_PATTERN : pattern));
	}
}
