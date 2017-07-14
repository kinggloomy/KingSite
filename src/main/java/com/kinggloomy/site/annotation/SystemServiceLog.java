package com.kinggloomy.site.annotation;

/**
 * Created by Administrator on 2017/7/12.
 */

import java.lang.annotation.*;

/**
 *自定义注解 拦截service
 */

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public  @interface SystemServiceLog {

    String description()  default "";


}