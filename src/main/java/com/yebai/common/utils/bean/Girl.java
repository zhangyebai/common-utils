package com.yebai.common.utils.bean;

import com.yebai.common.utils.anno.RandomDouble;
import com.yebai.common.utils.anno.RandomInt;
import com.yebai.common.utils.anno.RandomList;
import com.yebai.common.utils.anno.RandomString;

import java.util.List;

public class Girl {
	@RandomString(length = 4)
	private String name;

	@RandomInt(range = 100)
	private int age;

	@RandomDouble(high = 50, low = 4, base = 40)
	private double weight;

	@RandomList(target = Daughter.class, length = 3)
	private List<Daughter> daughters;

	@Override
	public String toString() {
		return "Girl{" +
				"name='" + name + '\'' +
				", age=" + age +
				", weight=" + weight +
				", daughters=" + daughters +
				'}';
	}
}

