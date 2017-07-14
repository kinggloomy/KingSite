package com.kinggloomy.site.controller;

import com.kinggloomy.site.annotation.Authorization;
import com.kinggloomy.site.core.Config;
import com.kinggloomy.site.core.ResultModel;
import com.kinggloomy.site.core.ResultStatus;
import com.kinggloomy.site.core.Utils;
import com.kinggloomy.site.model.ArticleModel;
import com.kinggloomy.site.model.RoleModel;
import com.kinggloomy.site.model.UserModel;
import com.kinggloomy.site.service.ArticleService;
import com.kinggloomy.site.service.ArticleTypeService;
import com.kinggloomy.site.service.RolesService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/24.
 */

@Controller
@RequestMapping("manager/article/")
@SessionAttributes("user")
public class ArticleController extends BaseController {
    private ArticleService articleService;
    private ArticleTypeService typeService;
    private RolesService rolesService;


    @RequestMapping("list")
    @Authorization
    public ModelAndView articleList(ModelMap map) {
        if (map.get("user") != null) {
            UserModel user = (UserModel) map.get("user");
            List<RoleModel> roles = rolesService.finaByUser(user);
            for (RoleModel role : roles) {
                if (role.getRoleKey().equals(Config.ROLE_ADMIN)) {
                    map.put("list", articleService.findAll());
                    return new ModelAndView("manager/article_list", map);
                }
            }
            map.put("list", articleService.findArticleByUser(user.getId()));
            return new ModelAndView("manager/article_list", map);
        }
        return new ModelAndView(new RedirectView("login"));
    }

    @RequestMapping("{id}")
    @Authorization
    public ModelAndView articleInfo(@PathVariable Integer id, ModelMap map) {
        map.put("article", articleService.findById(id));
        return new ModelAndView("manager/article_info", map);
    }

    @RequestMapping("toAdd")
    @Authorization
    public ModelAndView toAddArticle(ModelMap map) {

        map.put("types", typeService.findAll());
        return new ModelAndView("manager/article_edit", map);
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
    @Authorization
    public ModelAndView editArticle(@PathVariable Integer id, HttpServletRequest request, ModelMap map) {
        String msg;

        if (id != -1) {
            msg = "]将要编辑文章";
            map.put("article", articleService.findDTOById(id));
        } else {
            msg = "]将要添加文章";
            map.put("article", new ArticleModel());
        }
        try {
            logger.info("IP：[" +
                    Utils.getInstance().getIpAddr(request) +
                    msg);
        } catch (Exception e) {
            logger.error("log记录出错", e);
        }
        map.put("types", typeService.findAll());
        return new ModelAndView("manager/article_edit", map);
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    @Authorization
    public ResultModel saveArticle(@RequestBody ArticleModel article, HttpServletRequest request, ModelMap map) {
        if (article != null&&article.getTitle()!=null) {
            try {
                if (article.getPrivateFlag() == null) {
                    article.setPrivateFlag(false);
                }
                String ip = Utils.getInstance().getIpAddr(request);
                if (article.getId() != null) {
                    articleService.update(article);
                    logger.info("IP：[" + ip + "]已修改文章:" + article.getTitle());
                    return new ResultModel(ResultStatus.SUCCESS, "修改成功");
                }
                article.setAuthorUserId(((UserModel)map.get("user")).getId());
                article.setPublishDate(new Date());
                articleService.addBean(article);
                logger.info("IP：[" + ip + "]已添加文章:" + article.getTitle());
                return new ResultModel(ResultStatus.SUCCESS, "添加成功");
            } catch (Exception e) {
                e.printStackTrace();
                return new ResultModel(ResultStatus.ERROR, e.toString());
            }
        }
        return new ResultModel(ResultStatus.ERROR,"传入参数错误");

    }

    @RequestMapping("delete/{id}")
    @ResponseBody
    @Authorization
    public String deleteArticle(@PathVariable Integer id, ModelMap map) {
        articleService.deleteById(id);
        return Config.SUCCESS;
    }

    public ArticleService getArticleService() {
        return articleService;
    }

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    public ArticleTypeService getTypeService() {
        return typeService;
    }

    @Autowired
    public void setTypeService(ArticleTypeService typeService) {
        this.typeService = typeService;
    }

    public RolesService getRolesService() {
        return rolesService;
    }

    @Autowired
    public void setRolesService(RolesService rolesService) {
        this.rolesService = rolesService;
    }
}
