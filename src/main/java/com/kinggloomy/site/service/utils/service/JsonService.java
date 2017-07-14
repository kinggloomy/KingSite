package com.kinggloomy.site.service.utils.service;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Created by Administrator on 2017/4/26.
 */
public interface JsonService {
    String objToJson(Object object) throws JsonProcessingException;

    <T> T jsonToObj(String json, Class<T> clazz) throws JsonProcessingException;
}
