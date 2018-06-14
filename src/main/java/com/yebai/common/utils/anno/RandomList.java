package com.yebai.common.utils.anno;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD})
public @interface RandomList {
	Class target() default Object.class;
	int length() default 10;
}
