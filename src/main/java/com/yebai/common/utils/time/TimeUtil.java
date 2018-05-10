package com.yebai.common.utils.time;

import org.apache.commons.lang3.StringUtils;

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
 * @intent 常用的时间处理函数
 * @attention 包含date time两个字段的参数必然是local date time的完整字符串形式
 * 			  以此类推date和time
 *
 * 			  所有api本着简洁、短小、不混淆、在工程中高效易用为原则
 * @author Zhang Yebai
 * @date 2018/4/4 16:11
 * @log modified at 2018-05-10 by Zhang Yebai
 ****************************************************/
public class TimeUtil {
	private TimeUtil(){}

	public static final class Time{
		private Time(){}
		public static final String DATE_TIME_PATTERN_DEFAULT = "yyyy-MM-dd HH:mm:ss";
		public static final String DATE_TIME_PATTERN_TINY = "yyyyMMddHHmmss";
		public static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd";
		public static final String TIME_FORMAT_PATTERN = "HH:mm:ss";

		public static final DateTimeFormatter FORMATTER_DEFAULT = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN_DEFAULT);
	}

	/* ********************************************Tidy Time API*************************************************** */
	/****************************************************
	 *
	 * @intent 获取dateTime的整点时间, example : 2018-03-04 12:32:05 -> 2018-03-04 12:00:00
	 * @param hours 以LocalDateTime.now为基准向前推算hours小时, example: hours = 2, 则2018-03-04 12:32:05 -> 2018-03-04 10:00:00
	 * @date 2018/4/20 14:17
	 * @return tidy-LocalDateTime
	 * @author Zhang Yebai
	 ****************************************************/
	public static LocalDateTime tidyNow(int hours){
		return tidy(null, hours);
	}

	/****************************************************
	 *
	 * @intent 获取dateTime的整点时间, example : 2018-03-04 12:32:05 -> 2018-03-04 12:00:00
	 * @param pattern 取整后的时间输出格式, 可以为null, 如果为null则取TimeUtil.Time.DATE_TIME_PATTERN_DEFAULT
	 * @param hours 以dateTime为基准向前推算hours小时, example: hours = 2, 则2018-03-04 12:32:05 -> 2018-03-04 10:00:00
	 * @date 2018/4/20 14:17
	 * @return tidy-LocalDateTime的字符串形式
	 * @author Zhang Yebai
	 ****************************************************/
	public static String tidyNowString(String pattern, int hours){
		return tidyString(null, pattern, hours);
	}

	/****************************************************
	 *
	 * @intent 获取dateTime的整点时间, example : 2018-03-04 12:32:05 -> 2018-03-04 12:00:00
	 * @param dateTime local date time, 如果为null,则取LocalDateTime.now
	 * @param pattern 取整后的时间输出格式, 可以为null, 如果为null则取TimeUtil.Time.DATE_TIME_PATTERN_DEFAULT
	 * @param hours 以dateTime为基准向前推算hours小时, example: hours = 2, 则2018-03-04 12:32:05 -> 2018-03-04 10:00:00
	 * @date 2018/4/20 14:17
	 * @return tidy-LocalDateTime的字符串形式
	 * @author Zhang Yebai
	 ****************************************************/
	public static String tidyString(LocalDateTime dateTime, String pattern, int hours){
		return tidy(dateTime, hours)
				.format(StringUtils.isBlank(pattern) ? Time.FORMATTER_DEFAULT : DateTimeFormatter.ofPattern(pattern));

	}

	/****************************************************
	 *
	 * @intent 获取dateTime的整点时间, example : 2018-03-04 12:32:05 -> 2018-03-04 12:00:00
	 * @param dateTime local date time, 如果为null,则取LocalDateTime.now
	 * @param hours 以dateTime为基准向前推算hours小时, example: hours = 2, 则2018-03-04 12:32:05 -> 2018-03-04 10:00:00
	 * @date 2018/4/20 14:17
	 * @return tidy-LocalDateTime
	 * @author Zhang Yebai
	 ****************************************************/
	public static LocalDateTime tidy(LocalDateTime dateTime, int hours){
		dateTime = null == dateTime ? LocalDateTime.now() : dateTime;
		LocalDateTime dateTimeTarget = dateTime.plusHours(-hours);
		return  LocalDateTime
				.of(dateTimeTarget.toLocalDate(), LocalTime.of(dateTimeTarget.getHour(), 0, 0));
	}






	/* ********************************************Time Format API*************************************************** */
	/****************************************************
	 *
	 * @intent 获取dateTime的整点时间, example : 2018-03-04 12:32:05 -> 2018-03-04 12:00:00
	 * @param dateTime local date time, 如果为null,则取LocalDateTime.now
	 * @date 2018/4/20 14:17
	 * @return LocalDateTime-String
	 * @author Zhang Yebai
	 ****************************************************/
	public static String time(LocalDateTime dateTime){
		return time(dateTime, null);
	}

	/****************************************************
	 *
	 * @intent 获取dateTime的整点时间, example : 2018-03-04 12:32:05 -> 2018-03-04 12:00:00
	 * @param dateTime local date time, 如果为null,则取LocalDateTime.now
	 * @param pattern  LocalDateTime输出格式, 可以为null, 如果为null则取TimeUtil.Time.DATE_TIME_PATTERN_DEFAULT
	 * @date 2018/4/20 14:17
	 * @return LocalDateTime-String
	 * @author Zhang Yebai
	 ****************************************************/
	public static String time(LocalDateTime dateTime, String pattern){
		return dateTime.format(StringUtils.isBlank(pattern) ? Time.FORMATTER_DEFAULT : DateTimeFormatter.ofPattern(pattern));
	}

	/****************************************************
	 * @intent 获取LocalDateTime.now的字符串输出
	 * @param pattern  LocalDateTime输出格式, 可以为null, 如果为null则取TimeUtil.Time.DATE_TIME_PATTERN_DEFAULT
	 * @date 2018/4/20 14:17
	 * @return LocalDateTime-now-String
	 * @author Zhang Yebai
	 ****************************************************/
	public static String now(String pattern){
		return time(LocalDateTime.now(), pattern);
	}

	/****************************************************
	 * @intent 获取LocalDateTime.now的字符串输出
	 * @date 2018/4/20 14:17
	 * @return LocalDateTime-now-String
	 * @author Zhang Yebai
	 ****************************************************/
	public static String now(){
		return now(null);
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

	/* ********************************************Time Format API*************************************************** */
	public static List<String> listLatestDateAsString(int size){
		return listLatestDateAsString(size, null);
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
				DateTimeFormatter.ofPattern(null == datePattern ? TimeUtil.Time.DATE_FORMAT_PATTERN : datePattern);
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
		return beginDateTimeOfDay(date)
				.format(DateTimeFormatter.ofPattern(null == dateTimePattern ? TimeUtil.Time.DATE_TIME_PATTERN_DEFAULT : dateTimePattern));
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
		return endDateTimeOfDay(date)
				.format(DateTimeFormatter.ofPattern(null == dateTimePattern ? TimeUtil.Time.DATE_TIME_PATTERN_DEFAULT : dateTimePattern));
	}
	
	
	public static long goneMinutes(LocalDateTime begin){
		return goneMinutes(begin, null);
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
		return goneHours(begin, null);
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
		return goneDays(begin, null);
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
		return goneMonths(begin, null);
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

	public static long goneSeconds(LocalDateTime start){
		return goneSeconds(start, null);
	}

	public static long goneSeconds(LocalDateTime start, LocalDateTime end){
		return ChronoUnit.SECONDS.between(start, null == end ? LocalDateTime.now() : end);
	}
	/****************************************************
	 * @author Zhang Yebai
	 * @description 从字符串中解析LocalDateTime, 默认使用<code>Config.Time.DATE_TIME_PATTERN_DEFAULT</code>格式解析
	 * @note null
	 * @date 2018/4/8 16:32
	 * @return LocalDateTime
	 ****************************************************/
	public static LocalDateTime parseDateTime(String dateTime){
		return parseDateTime(dateTime, null);
	}
	
	/****************************************************
	 * @author Zhang Yebai
	 * @description 从字符串中解析LocalDateTime, 如果pattern为null或者blank则默认使用<code>Config.Time.DATE_TIME_PATTERN_DEFAULT</code>格式解析
	 * @note null
	 * @date 2018/4/8 16:34
	 * @return LocalDateTime
	 ****************************************************/
	public static LocalDateTime parseDateTime(String dateTime, String pattern){
		checkArgument(StringUtils.isNotBlank(dateTime));
		return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(null == pattern ? TimeUtil.Time.DATE_TIME_PATTERN_DEFAULT : pattern));
	}
	
	/****************************************************
	 * @author Zhang Yebai
	 * @description 从字符串中解析LocalDate, 默认使用 <code>Config.Time.DATE_FORMAT_PATTERN</code>格式解析
	 * @note null
	 * @date 2018/4/8 16:32
	 * @return LocalDate
	 ****************************************************/
	public static LocalDate parseDate(String date){
		return parseDate(date, null);
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
		return LocalDate.parse(date, DateTimeFormatter.ofPattern(null == pattern ? TimeUtil.Time.DATE_FORMAT_PATTERN : pattern));
	}
	
	/****************************************************
	 * @author Zhang Yebai
	 * @description 从字符串中解析LocalTime默认使用 <code>Config.Time.TIME_FORMAT_PATTERN</code>格式解析
	 * @note null
	 * @date 2018/4/8 16:36
	 * @return LocalTime
	 ****************************************************/
	public static LocalTime parseTime(String time){
		return parseTime(time, null);
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
		return LocalTime.parse(time, DateTimeFormatter.ofPattern(null == pattern ? TimeUtil.Time.TIME_FORMAT_PATTERN : pattern));
	}
}
