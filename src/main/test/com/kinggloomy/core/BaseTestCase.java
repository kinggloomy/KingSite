package com.kinggloomy.core;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
import org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by Administrator on 2017/7/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring-mvc.xml","classpath*:/applicationContext.xml"})
public class BaseTestCase {

    private static HandlerMapping handlerMapping;
    private static HandlerAdapter handlerAdapter;

    /**
     * 读取spring MVC配置文件
     * @throws UnsupportedEncodingException
     */
    public static void setUp() throws UnsupportedEncodingException {
        if (handlerMapping == null) {
            File file = new File(Thread.currentThread().getContextClassLoader().getResource("").getPath());
            String separator = File.separator;
            String path = URLDecoder.decode(file.getAbsolutePath(), "utf-8").replace("", "").replace("\\", "/");
            String[] configs = { "file:" + path + separator + "servlet-context.xml",
                    "file:" + path + separator + "service-context.xml" };
            XmlWebApplicationContext context = new XmlWebApplicationContext();
            context.setConfigLocations(configs);
            MockServletContext msc = new MockServletContext();
            context.setServletContext(msc);
            context.refresh();
            msc.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, context);
            handlerMapping = (HandlerMapping) context.getBean(DefaultAnnotationHandlerMapping.class);
            handlerAdapter = (HandlerAdapter) context.getBean(context
                    .getBeanNamesForType(AnnotationMethodHandlerAdapter.class)[0]);
        }
    }

    /**
     * 执行request对象请求的action
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ModelAndView excuteAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HandlerExecutionChain chain = handlerMapping.getHandler(request);
        ModelAndView model = null;/* handlerAdapter.handle(request, response, chain.getHandler());*/
        // 这里需要声明request的实际类型，否则会报错
        request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);
        try {
            model = handlerAdapter.handle(request, response, chain.getHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;

    }
}
