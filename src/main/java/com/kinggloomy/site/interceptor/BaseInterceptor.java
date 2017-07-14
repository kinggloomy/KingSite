package com.kinggloomy.site.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Created by Administrator on 2017/7/11.
 */
public class BaseInterceptor extends HandlerInterceptorAdapter {
    protected Logger logger = LoggerFactory.getLogger(getClass());
}
