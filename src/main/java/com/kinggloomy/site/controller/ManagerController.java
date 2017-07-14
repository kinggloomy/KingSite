package com.kinggloomy.site.controller;

import com.kinggloomy.site.annotation.Authorization;
import com.kinggloomy.site.model.UserModel;
import com.kinggloomy.site.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by Administrator on 2017/5/16.
 */
@Controller
@RequestMapping("manager/")
@SessionAttributes("user")
public class ManagerController extends BaseController {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Authorization
    @RequestMapping("index")
    public ModelAndView index(ModelMap map){
        return new ModelAndView("manager/index");
    }

    @RequestMapping("login")

    public ModelAndView login(UserModel user, ModelMap map) {
           user =  userService.login(user);
           if(user!=null&&user.getId()!=null) {
               map.addAttribute("user",user);
               return new ModelAndView("redirect:index") ;
           }
           map.put("error","user login fail");
           return new ModelAndView("manager/login");
    }
    @RequestMapping("logout")
    @Authorization
    public ModelAndView logout(ModelMap map) {
        map.remove("user");
        map.addAttribute("logout",true);
        return new ModelAndView("manager/login");
    }
}
