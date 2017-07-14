package com.kinggloomy.site.service;

import com.kinggloomy.site.model.UserModel;

public interface UserService extends BaseService<UserModel> {


	UserModel findByUserCode(String name);

	UserModel login(UserModel user);
}
