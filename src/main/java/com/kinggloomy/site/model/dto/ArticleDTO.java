package com.kinggloomy.site.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kinggloomy.site.model.ArticleTypeModel;
import com.kinggloomy.site.model.UserModel;

import java.util.Date;

/**
 * Created by Administrator on 2017/6/7.
 */
public class ArticleDTO {
    private Integer id;
    private Integer index;

    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date publishDate;

    private String title;

    private Integer articleTypeId;

    private ArticleTypeModel type;

    private Integer authorUserId;

    private UserModel auth;

    private Boolean privateFlag;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(Integer articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    public ArticleTypeModel getType() {
        return type;
    }

    public void setType(ArticleTypeModel type) {
        this.type = type;
    }

    public Integer getAuthorUserId() {
        return authorUserId;
    }

    public void setAuthorUserId(Integer authorUserId) {
        this.authorUserId = authorUserId;
    }

    public UserModel getAuth() {
        return auth;
    }

    public void setAuth(UserModel auth) {
        this.auth = auth;
    }

    public Boolean getPrivateFlag() {
        return privateFlag;
    }

    public void setPrivateFlag(Boolean privateFlag) {
        this.privateFlag = privateFlag;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
