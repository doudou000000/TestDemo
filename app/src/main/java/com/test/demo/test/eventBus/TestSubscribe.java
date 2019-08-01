package com.test.demo.test.eventBus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestSubscribe {

     TestThreadMode threadMode() default TestThreadMode.MAIN; // = TestThreadMode.MAIN;

     boolean stick() default false;

}
