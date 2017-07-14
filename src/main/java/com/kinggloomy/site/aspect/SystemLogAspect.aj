package com.kinggloomy.site.aspect;

import com.kinggloomy.site.annotation.SystemControllerLog;
import com.kinggloomy.site.core.Config;
import com.kinggloomy.site.core.Utils;
import com.kinggloomy.site.model.UserModel;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/7/12.
 */
@Aspect
@Component
public class SystemLogAspect {
    private  static  final Logger logger = LoggerFactory.getLogger(SystemLogAspect. class);

    //Service层切点
    @Pointcut("@annotation(com.kinggloomy.site.annotation.SystemServiceLog)")
    public  void serviceAspect() {
    }

    //Controller层切点
    @Pointcut("@annotation(com.kinggloomy.site.annotation.SystemControllerLog)")
    public  void controllerAspect() {
    }
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //读取session中的用户
        UserModel user = (UserModel) session.getAttribute(Config.CURRENT_USER_KEY);
        //请求的IP

        try {
            String ip = Utils.getInstance().getIpAddr(request);
            //*========控制台输出=========*//
            System.out.println("=====前置通知开始=====");
            System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            System.out.println("方法描述:" + getControllerMethodDescription(joinPoint));
            System.out.println("请求人:" + user.getNickname());
            System.out.println("请求IP:" + ip);
            System.out.println("=====前置通知结束=====");
           logger.info("=====前置通知开始=====");
           logger.info("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
           logger.info("方法描述:" + getControllerMethodDescription(joinPoint));
           logger.info("请求人:" + user.getNickname());
           logger.info("请求IP:" + ip);
           logger.info("=====前置通知结束=====");
        }  catch (Exception e) {
            //记录本地异常日志
            logger.error("==前置通知异常==");
            logger.error("异常信息:{}", e.getMessage());
        }
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public  static String getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(SystemControllerLog. class).description();
                    break;
                }
            }
        }
        return description;
    }
}
