package com.kinggloomy.site.service.impl;

import com.kinggloomy.site.dao.JurisdictionModelMapper;
import com.kinggloomy.site.model.JurisdictionModel;
import com.kinggloomy.site.service.JurisdictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jurisdictionService")
@Transactional
public class JurisdictionServiceImpl implements JurisdictionService {

    private JurisdictionModelMapper jurisdictionDAO;

    @Override
    public Integer addBean(JurisdictionModel t) {
        return jurisdictionDAO.insert(t);
    }

    @Override
    public List<JurisdictionModel> findAll() {
        return jurisdictionDAO.selectAll();
    }

    @Override
    public Integer update(JurisdictionModel t) {
       return jurisdictionDAO.updateByPrimaryKey(t);
    }

    @Override
    public Integer delete(JurisdictionModel t) {
        return deleteById(t.getId());
    }

    @Override
    public JurisdictionModel findById(Integer id) {
        return jurisdictionDAO.selectByPrimaryKey(id);
    }

    @Override
    public Integer deleteById(Integer id) {
        return jurisdictionDAO.deleteByPrimaryKey(id);
    }

    @Override
    public JurisdictionModel findByName(String name) {
        return jurisdictionDAO.findByName(name);
    }

    public JurisdictionModelMapper getJurisdictionDAO() {
        return jurisdictionDAO;
    }

    @Autowired
    public void setJurisdictionDAO(JurisdictionModelMapper jurisdictionDAO) {
        this.jurisdictionDAO = jurisdictionDAO;
    }
}
