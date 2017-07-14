package com.kinggloomy.site.service.impl;

import java.util.List;

import com.kinggloomy.site.dao.ArticleTypeModelMapper;
import com.kinggloomy.site.model.ArticleTypeModel;
import com.kinggloomy.site.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service("articleTypeService")

public class ArticleTypeServiceImpl implements ArticleTypeService {
	
	private ArticleTypeModelMapper articleTypeDAO;

	@Override
	public Integer addBean(ArticleTypeModel t) {
		return articleTypeDAO.insert(t);
	}

	@Override
	public List<ArticleTypeModel> findAll() {
		return articleTypeDAO.selectAll();
	}

	@Override
	public ArticleTypeModel findByName(String name) {
		return articleTypeDAO.selectByName(name);


	}

	@Override
	public Integer update(ArticleTypeModel t) {
		return articleTypeDAO.updateByPrimaryKey(t);
	}

	@Override
	public Integer delete(ArticleTypeModel t) {
		return deleteById(t.getId());
	}

	@Override
	public ArticleTypeModel findById(Integer id) {
		return articleTypeDAO.selectByPrimaryKey(id);
	}

	@Override
	public Integer deleteById(Integer id) {
		return articleTypeDAO.deleteByPrimaryKey(id);
	}


	public ArticleTypeModelMapper getArticleTypeDAO() {
		return articleTypeDAO;
	}

	@Autowired
	public void setArticleTypeDAO(ArticleTypeModelMapper articleTypeDAO) {
		this.articleTypeDAO = articleTypeDAO;
	}



}
