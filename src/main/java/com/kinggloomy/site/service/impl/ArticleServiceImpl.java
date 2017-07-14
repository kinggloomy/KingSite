package com.kinggloomy.site.service.impl;

import java.util.List;

import com.kinggloomy.site.dao.ArticleModelMapper;
import com.kinggloomy.site.model.ArticleModel;
import com.kinggloomy.site.model.UserModel;
import com.kinggloomy.site.model.dto.ArticleDTO;
import com.kinggloomy.site.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("articleService")
@Transactional
public class ArticleServiceImpl implements ArticleService {

    private ArticleModelMapper articleDAO;

    @Override
    public Integer addBean(ArticleModel t) {
        return articleDAO.insert(t);

    }

    @Override
    public List<ArticleModel> findAll() {
        return articleDAO.selectAll();
    }

    @Override
    public Integer update(ArticleModel t) {
       return articleDAO.updateByPrimaryKey(t);

    }

    @Override
    public Integer delete(ArticleModel t) {
        return articleDAO.deleteByPrimaryKey(t.getId());
    }

    @Override
    public ArticleModel findById(Integer id) {
        return articleDAO.selectByPrimaryKey(id);
    }

    @Override
    public Integer deleteById(Integer id) {
        return articleDAO.deleteByPrimaryKey(id);
    }

    @Override
    public ArticleModel findByName(String name) {
        return articleDAO.selectByTitle(name);
    }

    @Override
    public List<ArticleModel> privateArticle(UserModel user) {
        return articleDAO.selectPrivateByUser(user.getId());
    }

    @Override
    public List<ArticleModel> publicArticle() {
        return articleDAO.selectPublicArticle();
    }

    @Override
    public ArticleDTO findDTOById(Integer id){
        return articleDAO.selectDTOByID(id);
    }

    @Override
    public List<ArticleDTO> findArticleByUser(Integer userId) {
        return  articleDAO.selectDTOByUserId(userId);
    }

    public ArticleModelMapper getArticleDAO() {
        return articleDAO;
    }

    @Autowired
    public void setArticleDAO(ArticleModelMapper articleDAO) {
        this.articleDAO = articleDAO;
    }
}
