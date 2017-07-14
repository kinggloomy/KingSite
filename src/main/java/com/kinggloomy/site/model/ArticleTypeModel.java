package com.kinggloomy.site.model;

public class ArticleTypeModel extends BaseModel {

    private Integer index;

    private String articleTypeUseable;

    private Integer parenttypeId;

    private String typeName;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getArticleTypeUseable() {
        return articleTypeUseable;
    }

    public void setArticleTypeUseable(String articleTypeUseable) {
        this.articleTypeUseable = articleTypeUseable;
    }

    public Integer getParenttypeId() {
        return parenttypeId;
    }

    public void setParenttypeId(Integer parenttypeId) {
        this.parenttypeId = parenttypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}