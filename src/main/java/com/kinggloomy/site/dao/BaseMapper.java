package com.kinggloomy.site.dao;



import java.util.List;

/**
 * Created by Administrator on 2017/5/15.
 */
public interface BaseMapper<T> {
    Integer deleteByPrimaryKey(Integer id);

    int insert(T record);

    T selectByPrimaryKey(Integer id);

    List<T> selectAll();

    int updateByPrimaryKey(T record);
}
