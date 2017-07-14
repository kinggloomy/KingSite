package com.kinggloomy.site.interceptor;


import com.kinggloomy.site.annotation.SelfAuth;
import com.kinggloomy.site.controller.BaseController;
import com.kinggloomy.site.core.Utils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Harlan King on 2017/7/6.
 */
public class SelfInterceptor extends BaseInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            SelfAuth authorization = ((HandlerMethod) handler)
                    .getMethodAnnotation(SelfAuth.class);

            // 没有声明需要权限,或者声明不验证权限
            if (authorization == null || authorization.validate() == false)
                return true;
            else {
                // 这里写自己的验证方法，验证失败则返回false;
                System.out.println("validating");

                if(Utils.getInstance().validateLogin(request)){
                    //验证成功则返回true，继续页面处理
                    return true;
                } else {
                    //验证失败则重定向地址到登陆页面，返回false中断原有的页面处理
                    response.sendRedirect(request.getContextPath()+"/manager/login");
                    return false;
                }
            }
        } else
            return true;
    }


}
