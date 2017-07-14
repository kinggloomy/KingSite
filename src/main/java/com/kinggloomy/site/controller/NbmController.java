package com.kinggloomy.site.controller;

import com.kinggloomy.site.annotation.SelfAuth;
import com.kinggloomy.site.core.Config;
import com.kinggloomy.site.core.Utils;
import com.kinggloomy.site.model.dto.GlobalDTO;
import com.kinggloomy.site.service.ArticleService;
import com.kinggloomy.site.service.GlobalService;
import com.kinggloomy.site.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/12.
 */
@Controller
@RequestMapping("nbm")
public class NbmController extends IndexController{
    @RequestMapping("/nbm")
    @SelfAuth
    public String  noBodyButMe(HttpServletRequest request, ModelMap map){
        try {
            logger.info("IP：[" +
                    Utils.getInstance().getIpAddr(request)+"]访问网站，进入主页");
            map.put("articles",articleService.publicArticle());
            map.put("banners",imageService.findIdsByType(Config.IMG_BANNER_TYPE));
            map.put("albums",imageService.findIdsByType(Config.IMG_ALBUM_TYPE));
            List<GlobalDTO> globals = globalService.findAll();
            Map<String,Object> globalMap = new HashMap<>();
            for(GlobalDTO g :globals){
                globalMap.put(g.getGlobalKey(),g);
            }
            map.put("globals",globalMap);
            map.put("image_url","manager/image/show/");
        } catch (Exception e) {
            logger.error("log记录出错",e);
        }

        return "front/index";
    }


}
