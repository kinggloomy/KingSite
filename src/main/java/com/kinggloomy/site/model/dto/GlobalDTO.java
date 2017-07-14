package com.kinggloomy.site.model.dto;

import com.kinggloomy.site.model.ImageModel;

/**
 * Created by Administrator on 2017/6/14.
 */
public class GlobalDTO {
    private String globalKey;
    private String title;
    private String content;
    private Integer imageId;
    private ImageModel image;

    public String getGlobalKey() {
        return globalKey;
    }

    public void setGlobalKey(String globalKey) {
        this.globalKey = globalKey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public ImageModel getImage() {
        return image;
    }

    public void setImage(ImageModel image) {
        this.image = image;
    }
}
