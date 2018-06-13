package com.yebai.common.utils;

import com.yebai.common.utils.bean.Girl;
import com.yebai.common.utils.generator.ClassUtil;

public class App {
	public static void main(String[] args) {
		Girl girl = ClassUtil.build(Girl.class);
		System.out.println(girl);
	}
}
