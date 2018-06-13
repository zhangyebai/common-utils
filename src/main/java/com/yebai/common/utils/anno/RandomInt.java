package com.yebai.common.utils.anno;


import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD})
public @interface RandomInt {
	int range() default 1000;
}
