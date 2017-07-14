package com.kinggloomy.site.annotation;

/**
 * 在Controller的方法上使用此注解，该方法在映射时会检查用户是否登录，未登录返回401错误
 * @see com.kinggloomy.site.interceptor.AuthorizationInterceptor
 * @author Harlan King
 * @date 2015/7/11.
 */
public @interface SelfAuth {
    boolean validate() default true;
}
