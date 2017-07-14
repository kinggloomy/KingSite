package com.kinggloomy.site.controller;

import com.kinggloomy.site.annotation.Authorization;
import com.kinggloomy.site.core.Config;
import com.kinggloomy.site.core.ResultModel;
import com.kinggloomy.site.core.ResultStatus;
import com.kinggloomy.site.model.ImageModel;
import com.kinggloomy.site.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by Administrator on 2017/6/28.
 */
@Controller
@RequestMapping("manager/image/")
@SessionAttributes("user")
public class ImageController extends BaseController {
    private ImageService imageService;

    @RequestMapping("edit/{type}")
    @Authorization
    public ModelAndView banner(@PathVariable("type") String type, ModelMap map) {
        map.put("imgType",type);
        return new ModelAndView("manager/image", map);
    }


    @RequestMapping("ids/{type}")
    @ResponseBody
    @Authorization
    public Integer[] albumUrls(@PathVariable("type")String type, HttpServletRequest request, ModelMap map) {
        List<Integer> list = imageService.findIdsByType(type);
        map.put("imageIds", list);
        Integer[] urls = new Integer[list.size()];
        return list.toArray(urls);
    }

    @RequestMapping("deleteById/{id}")
    @ResponseBody
    @Authorization
    public ResultModel albumDeleteById(@PathVariable("id") Integer id, HttpServletRequest request, ModelMap map) {
        try {
            imageService.deleteById(id, request);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultModel.error(ResultStatus.ERROR);
        }
        return ResultModel.ok();
    }

    @RequestMapping("upload/{type}")
    @ResponseBody
    @Authorization
    public ResultModel uploadImage(@PathVariable("type") String type, @RequestParam("file") MultipartFile[] files, HttpServletRequest request) {
        try {
            imageService.uploadImage(files, request, type);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResultModel(ResultStatus.ERROR, "参数错误");
        }
        return new ResultModel(ResultStatus.SUCCESS,type+"添加成功");

}

    @RequestMapping("show/{id}.jpg")
    @Authorization(validate = false)
    public void imageShow(@PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response) {
        ImageModel image = imageService.findById(id);
        FileInputStream fis = null;
        response.setContentType(image.getContentType());
        try {
            OutputStream out = response.getOutputStream();
            String path = request.getSession().getServletContext().getRealPath(image.getPath()) + image.getName();
            File file = new File(path);
            fis = new FileInputStream(file);
            byte[] b = new byte[fis.available()];
            fis.read(b);
            out.write(b);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ImageService getImageService() {
        return imageService;
    }

    @Autowired
    public void setImageService(ImageService imageService) {
        this.imageService = imageService;
    }
}
