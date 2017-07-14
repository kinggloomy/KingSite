package com.kinggloomy.site.dao;

import com.kinggloomy.site.model.RoleModel;

import java.util.List;

public interface RoleModelMapper extends BaseMapper<RoleModel>{
    RoleModel findByName(String name);

    List<RoleModel> findByUserCode(String userCode);
}