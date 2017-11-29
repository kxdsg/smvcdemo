package com.argus.web.annotation;

import java.lang.annotation.*;

/**
 * @author xingding
 * @date 2017/11/28.
 */

@Documented
@Inherited
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface HeaderExtProp {
    String value() default "";
}
