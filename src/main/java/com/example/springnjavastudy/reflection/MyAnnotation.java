package com.example.springnjavastudy.reflection;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})  //Type하고 Field에만 붙일수있다.
@Inherited
public @interface MyAnnotation {

    // Primitive Type과 Reference Type들을 선언할 수 있다.
    String name() default "keesun";

    int number() default 100;

}
