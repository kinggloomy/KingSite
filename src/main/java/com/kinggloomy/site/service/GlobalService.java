package com.kinggloomy.site.service;

import com.kinggloomy.site.model.GlobalModel;
import com.kinggloomy.site.model.dto.GlobalDTO;

import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */
public interface GlobalService{
    String addBean(GlobalDTO globalDTO);

    List<GlobalDTO> findAll();

    String update(GlobalDTO globalDTO);

    String delete(GlobalDTO globalDTO);

    GlobalDTO findById(String id);


    GlobalModel findModelById(String key);

    String deleteById(String key);


    boolean dtoHasImage(GlobalDTO dto);

    String saveOrUpdate(GlobalDTO global);
}
