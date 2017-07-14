package com.kinggloomy.site.service.utils.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kinggloomy.site.service.utils.service.JsonService;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by Administrator on 2017/4/26.
 */
@Component("jsonService")
public class JsonServiceImpl implements JsonService {
    private ObjectMapper mapper = new ObjectMapper();
    @Override
    public String objToJson(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);

    }
    @Override
    public <T> T jsonToObj(String json,Class<T> clazz) throws JsonProcessingException {
        T t = null;
        try {
            t = mapper.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;

    }
}
