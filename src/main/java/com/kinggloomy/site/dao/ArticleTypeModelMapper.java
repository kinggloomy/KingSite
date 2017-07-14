package com.kinggloomy.site.dao;

import com.kinggloomy.site.model.ArticleTypeModel;

public interface ArticleTypeModelMapper extends BaseMapper<ArticleTypeModel>{

    ArticleTypeModel selectByName(String name);
}