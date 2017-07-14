package com.kinggloomy.site.dao;

import com.kinggloomy.site.model.ImageModel;
import java.util.List;

public interface ImageModelMapper {
    Integer deleteByPrimaryKey(Integer id);

    Integer insert(ImageModel record);

    ImageModel selectByPrimaryKey(Integer id);

    List<ImageModel> selectAll();

    List<ImageModel> selectByType(String type);

    Integer updateByPrimaryKey(ImageModel record);
}