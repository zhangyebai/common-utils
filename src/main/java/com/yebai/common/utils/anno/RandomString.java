package com.yebai.common.utils.anno;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD})
public @interface RandomString {
	int length() default 8;
}
