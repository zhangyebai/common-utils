package com.yebai.common.utils.generator;

import com.yebai.common.utils.anno.RandomDouble;
import com.yebai.common.utils.anno.RandomInt;
import com.yebai.common.utils.anno.RandomList;
import com.yebai.common.utils.anno.RandomString;

import java.lang.reflect.Field;

public class ClassUtil {
	private ClassUtil(){}

	public static <T> T build(Class<T> clazz){
		try {
			final T t =  clazz.newInstance();
			Field[] fields = clazz.getDeclaredFields();
			Field.setAccessible(fields, true);
			for (Field field : fields) {
				field.setAccessible(true);
				if (field.isAnnotationPresent(RandomString.class)) {
					RandomString randomString = field.getDeclaredAnnotation(RandomString.class);
					field.set(t, RandomUtil.randomString(randomString.length()));
				} else if (field.isAnnotationPresent(RandomInt.class)) {
					RandomInt randomInt = field.getDeclaredAnnotation(RandomInt.class);
					field.set(t, RandomUtil.randomInt(randomInt.range()));
				}else if(field.isAnnotationPresent(RandomDouble.class)){
					RandomDouble randomDouble = field.getDeclaredAnnotation(RandomDouble.class);
					field.set(t, RandomUtil.randomDouble(randomDouble.high(), randomDouble.low(), randomDouble.base()));
				}else if(field.isAnnotationPresent(RandomList.class)){
					RandomList randomList = field.getDeclaredAnnotation(RandomList.class);
					field.set(t, AutoInjectionUtil.listInjection(randomList.target(), randomList.length()));
				}
			}
			return t;
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
