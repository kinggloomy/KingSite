package com.kinggloomy.site.controller;

import com.kinggloomy.site.annotation.Authorization;
import com.kinggloomy.site.core.Config;
import com.kinggloomy.site.core.ResultModel;
import com.kinggloomy.site.core.ResultStatus;
import com.kinggloomy.site.model.dto.GlobalDTO;
import com.kinggloomy.site.service.GlobalService;
import com.kinggloomy.site.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */
@Controller
@RequestMapping("manager/global/")
@SessionAttributes("user")
public class GlobalController extends BaseController {
    private ImageService imageService;
    private GlobalService globalService;

    @RequestMapping("")
    @Authorization
    public ModelAndView global(HttpServletRequest request, ModelMap map) {
        map.put("globals", globalService.findAll());
        return new ModelAndView("manager/global", map);
    }

    @RequestMapping("show/{key}")
    @ResponseBody
    @Authorization
    public GlobalDTO globalShow(@PathVariable("key") String key, HttpServletRequest request, ModelMap map) {
        GlobalDTO dto = key.equals("-1") ? new GlobalDTO() : globalService.findById(key);
        switch (key) {
            case Config.GLOBAL_ABOUT_CODE:
            case Config.GLOBAL_REASON_CODE:
                if (dto == null || dto.getContent() == null) {
                    dto = new GlobalDTO();
                    dto.setGlobalKey(key);
                }
                break;
        }
        return dto;
    }

    @RequestMapping("about")
    @Authorization
    public ModelAndView about(HttpServletRequest request, ModelMap map) {
        map.put("global", Config.GLOBAL_ABOUT_CODE);
        return new ModelAndView("manager/global", map);
    }

    @RequestMapping("reason")
    @Authorization
    public ModelAndView reason(HttpServletRequest request, ModelMap map) {
        map.put("global", Config.GLOBAL_REASON_CODE);
        return new ModelAndView("manager/global", map);
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    @Authorization
    public ResultModel save(@RequestBody GlobalDTO global, HttpServletRequest request, ModelMap map) {
        if (global != null && global.getGlobalKey() != null) ;
        {
            if (global.getImageId() != null) {
                if (imageService.findById(global.getImageId()).getId().intValue() == global.getImageId()) {
                    String key = globalService.saveOrUpdate(global);
                    return ResultModel.ok(key);
                }
            } else {
                String key = globalService.saveOrUpdate(global);
                return ResultModel.ok(key);
            }
        }
        return ResultModel.error(ResultStatus.ERROR);

    }

    @RequestMapping("global/delete/{key}")
    @ResponseBody
    @Authorization
    public ResultModel delete(@PathVariable("key") String key, HttpServletRequest request, ModelMap map) {
        try {
            GlobalDTO dto = globalService.findById(key);
            globalService.deleteById(key);
            imageService.deleteById(dto.getImageId(), request);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultModel.error(ResultStatus.ERROR);
        }
        return ResultModel.ok();
    }

    public ImageService getImageService() {
        return imageService;
    }

    @Autowired
    public void setImageService(ImageService imageService) {
        this.imageService = imageService;
    }

    public GlobalService getGlobalService() {
        return globalService;
    }

    @Autowired
    public void setGlobalService(GlobalService globalService) {
        this.globalService = globalService;
    }
}
