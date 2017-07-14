package com.kinggloomy.site.controller;


import com.kinggloomy.site.model.UserModel;
import com.kinggloomy.site.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/5/15.
 */

public class BaseController {
    private UserService userService;
    protected  Logger logger = LoggerFactory.getLogger(getClass());

    protected UserModel getSessionUser(HttpServletRequest request){
        return (UserModel)request.getSession().getAttribute("user");

    }

}
