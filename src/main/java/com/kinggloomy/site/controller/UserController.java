package com.kinggloomy.site.controller;

import com.kinggloomy.site.annotation.Authorization;
import com.kinggloomy.site.core.Config;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/5/24.
 */

@Controller
@RequestMapping("manager/user/")
@SessionAttributes("user")
public class UserController extends BaseController {
    @RequestMapping("list")
    @Authorization
    public ModelAndView userList(ModelMap map){
        return new ModelAndView("manager/user_list");
    }
    @RequestMapping("{id}")
    @Authorization
    public ModelAndView userInfo(@PathVariable  String id,ModelMap map){
        return new ModelAndView("manager/user_info");
    }
    @RequestMapping("edit/{id}")
    @Authorization
    public String editUser(@PathVariable  String id,ModelMap map){
        return Config.SUCCESS;
    }
    @RequestMapping("toAdd")
    @Authorization
    public ModelAndView toAddUser(ModelMap map){
        return new ModelAndView("manager/user_edit");
    }
    @RequestMapping("add/{id}")
    @Authorization
    public String addUser(@PathVariable  String id,ModelMap map){
        return Config.SUCCESS;
    }
    @RequestMapping("delete/{id}")
    @Authorization
    public String deleteUser(@PathVariable  String id,ModelMap map){
        return Config.SUCCESS;
    }
}
