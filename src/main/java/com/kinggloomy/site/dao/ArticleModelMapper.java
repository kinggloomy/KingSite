package com.kinggloomy.site.dao;

import com.kinggloomy.site.model.ArticleModel;
import com.kinggloomy.site.model.dto.ArticleDTO;

import java.util.List;

public interface ArticleModelMapper extends BaseMapper<ArticleModel> {

    ArticleModel selectByTitle(String title);
    ArticleDTO selectDTOByPrimaryKey(Integer id);
    ArticleDTO selectAllDTO();
    List<ArticleModel> selectPrivateByUser(Integer userId);
    List<ArticleModel> selectPrivateDTOByUser(Integer userId);
    List<ArticleModel> selectPublicArticle();
    ArticleDTO selectDTOByID(Integer id);
    List<ArticleDTO> selectDTOByUserId(Integer id);
}