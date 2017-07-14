package com.kinggloomy.site.service;

import com.kinggloomy.site.model.ImageModel;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */
public interface ImageService extends BaseService<ImageModel>{
    List<ImageModel> findByType(String type);

    List<Integer> findIdsByType(String type);

    Integer deleteById(Integer id, HttpServletRequest request) throws IOException;

    Integer[] uploadImage(MultipartFile[] files, HttpServletRequest request, String type) throws IOException;

    void uploadBanner(MultipartFile file, HttpServletRequest request) throws IOException;
}
