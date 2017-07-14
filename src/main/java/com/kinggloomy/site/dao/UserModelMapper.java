package com.kinggloomy.site.dao;

import com.kinggloomy.site.model.UserModel;

public interface UserModelMapper extends BaseMapper<UserModel>{

    UserModel selectByUserCode(String code);

    UserModel login(UserModel user);
}