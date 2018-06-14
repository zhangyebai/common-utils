package com.yebai.common.utils.bean;

import com.yebai.common.utils.anno.RandomDouble;
import com.yebai.common.utils.anno.RandomInt;
import com.yebai.common.utils.anno.RandomString;

public class Girl {
	@RandomString(length = 4)
	private String name;

	@RandomInt(range = 100)
	private int age;

	@RandomDouble(high = 50, low = 4, base = 40)
	private double weight;

	@Override
	public String toString() {
		return "Girl{" +
				"name='" + name + '\'' +
				", age=" + age +
				", weight=" + weight +
				'}';
	}
}
