package com.thejava;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface AnotherAnnotation {
    String value() default "hwanwoo";
    int number() default 100;
}
