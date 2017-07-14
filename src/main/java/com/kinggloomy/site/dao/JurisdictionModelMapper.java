package com.kinggloomy.site.dao;

import com.kinggloomy.site.model.JurisdictionModel;

public interface JurisdictionModelMapper extends BaseMapper<JurisdictionModel> {
    JurisdictionModel findByName(String name);

}