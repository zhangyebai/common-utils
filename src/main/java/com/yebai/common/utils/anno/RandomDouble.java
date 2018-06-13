package com.yebai.common.utils.anno;


import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD})
public @interface RandomDouble {
	int high()default 1000;
	int low() default 2;
	int base() default 0;
}
