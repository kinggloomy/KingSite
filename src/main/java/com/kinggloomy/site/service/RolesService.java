package com.kinggloomy.site.service;

import com.kinggloomy.site.model.RoleModel;
import com.kinggloomy.site.model.UserModel;

import java.util.List;

public interface RolesService extends BaseService<RoleModel> {

	List<RoleModel> finaByUser(UserModel user);

}
