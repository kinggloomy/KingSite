package com.kinggloomy.site.model;

public class JurisdictionModel extends BaseModel {

    private Integer index;

    private Boolean enabled;

    private String jContent;

    private String jKey;

    private String jName;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getjContent() {
        return jContent;
    }

    public void setjContent(String jContent) {
        this.jContent = jContent;
    }

    public String getjKey() {
        return jKey;
    }

    public void setjKey(String jKey) {
        this.jKey = jKey;
    }

    public String getjName() {
        return jName;
    }

    public void setjName(String jName) {
        this.jName = jName;
    }
}