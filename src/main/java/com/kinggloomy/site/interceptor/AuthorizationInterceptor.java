package com.kinggloomy.site.interceptor;

import com.kinggloomy.site.annotation.Authorization;
import com.kinggloomy.site.core.Utils;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Harlan King on 2017/7/6.
 */
public class AuthorizationInterceptor extends BaseInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            Authorization authorization = ((HandlerMethod) handler)
                    .getMethodAnnotation(Authorization.class);

            // 没有声明需要权限,或者声明不验证权限
            if (authorization == null || authorization.validate() == false)
                return true;
            else {
              logger.info("开始验证后台权限");
                if(Utils.getInstance().validateLogin(request)){
                    logger.info("权限验证通过");
                    return true;
                } else {
                    logger.info("权限验证失败，返回登录页面");
                    response.sendRedirect(request.getContextPath()+"/manager/login");
                    return false;
                }
            }
        } else
            return true;
    }


}
