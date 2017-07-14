package com.kinggloomy.site.service;

import com.kinggloomy.site.model.ArticleModel;
import com.kinggloomy.site.model.UserModel;
import com.kinggloomy.site.model.dto.ArticleDTO;

import java.util.List;

public interface ArticleService extends BaseService<ArticleModel> {


    List<ArticleModel> privateArticle(UserModel user);

    List<ArticleModel> publicArticle();

    ArticleDTO findDTOById(Integer id);
    List<ArticleDTO> findArticleByUser(Integer userId);
}
