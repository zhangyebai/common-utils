package com.yebai.common.utils.generator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoInjectionUtil {
	private AutoInjectionUtil(){}

	public static <T> List<T> listInjection(Class<T> clazz, int length){
		if(clazz.isInstance(String.class)){
			return null;
		}else if (clazz.isInstance(Integer.class)){
			return null;
		}else if(clazz.isInstance(Double.class)){
			return null;
		}else{
			return IntStream.range(0, length).mapToObj(index -> ClassUtil.build(clazz)).collect(Collectors.toList());
		}
	}

}
