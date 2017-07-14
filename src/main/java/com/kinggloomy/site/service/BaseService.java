package com.kinggloomy.site.service;

import java.util.List;

public interface BaseService<T> {

    //增
    public Integer addBean(T t);

    //查所有
    public List<T> findAll();

    //	改
    public Integer update(T t);

    //	删
    public Integer delete(T t);

    //	查单个
    public T findById(Integer id);

    public Integer deleteById(Integer id);

    public T findByName(String name);

}