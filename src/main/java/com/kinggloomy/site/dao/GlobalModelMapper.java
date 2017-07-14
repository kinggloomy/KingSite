package com.kinggloomy.site.dao;

import com.kinggloomy.site.model.GlobalModel;
import com.kinggloomy.site.model.dto.GlobalDTO;

import java.util.List;

public interface GlobalModelMapper {
    String deleteByPrimaryKey(String globalKey);

    Integer insert(GlobalModel record);

    GlobalModel selectByPrimaryKey(String globalKey);

    GlobalDTO selectDTOByPrimaryKey(String globalKey);

    List<GlobalModel> selectAll();

    Integer updateByPrimaryKey(GlobalModel record);
}