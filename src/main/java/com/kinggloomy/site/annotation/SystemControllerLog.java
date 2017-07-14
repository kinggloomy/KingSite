package com.kinggloomy.site.annotation;

import java.lang.annotation.*;

/**
 * 在Controller的方法上使用此注解，该方法在映射时会检查会log输出访问IP记录
 * @see
 * @author Harlan King
 * @date 2015/7/11.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public  @interface SystemControllerLog {

    String description()  default "";


}