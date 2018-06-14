package com.yebai.common.utils.generator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomUtil {
	private static final int CHINESE_BEGIN = 0X4E00;
	private static final int CHINESE_END = 0X9FBF;
	private static final int RANGE = CHINESE_END - CHINESE_BEGIN;

	/**
	 *
	 * Chinese only
	 * */
	public static String randomString(int length) {
		final StringBuilder sb = new StringBuilder();
		for (int index = 0; index < length; ++index) {
			sb.append((char) (new Random(System.nanoTime()).nextInt(RANGE) + CHINESE_BEGIN));
		}
		return sb.toString();
	}

	public static int randomInt(int range){
		return new Random(System.nanoTime()).nextInt(range + 1);
	}

	@SuppressWarnings(value = "unused")
	public static double randomDoubleBackup(int high, int low, int base){
		return new BigDecimal(randomInt(high - base) + base + new Random(System.nanoTime()).nextDouble())
				.setScale(low, BigDecimal.ROUND_HALF_UP)
				.doubleValue();
	}

	/**
	 * 关注一下上下两个方法的实现效率
	 * 上: 两次seed获取, 两次random运算 一次强制类型转换
	 * 下: 一次double乘法运算 一次seed获取 一次强制类型转换
	 * */
	public static double randomDouble(int high, int low, int base){
		return new BigDecimal(new Random(System.nanoTime()).nextDouble() * (high - base) + base)
				.setScale(low, BigDecimal.ROUND_HALF_UP)
				.doubleValue();
	}
}
