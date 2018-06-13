package com.yebai.common.utils.bean;

import com.yebai.common.utils.anno.RandomInt;
import com.yebai.common.utils.anno.RandomString;

public class Girl {
	@RandomString(length = 3)
	private String name;

	@RandomInt(range = 100)
	private int age;

	@Override
	public String toString() {
		return "Girl{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
