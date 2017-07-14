package com.kinggloomy.site.service.impl;

import com.kinggloomy.site.core.Config;
import com.kinggloomy.site.dao.ImageModelMapper;
import com.kinggloomy.site.model.ImageModel;
import com.kinggloomy.site.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */
@Service("imageService")
@Transactional
public class ImageServiceImpl implements ImageService {
    private ImageModelMapper imageDao;


    @Override
    public Integer addBean(ImageModel imageModel) {
        imageDao.insert(imageModel);
        return imageModel.getId();
    }

    @Override
    public List<ImageModel> findAll() {
        return imageDao.selectAll();
    }

    @Override
    public List<ImageModel> findByType(String type) {
        return imageDao.selectByType(type);
    }

    @Override
    public List<Integer> findIdsByType(String type) {
        List<ImageModel> list = findByType(type);
        List<Integer> Ids = new ArrayList<>();
        for (ImageModel img : list) {
            Ids.add(img.getId());
        }
        return Ids;
    }

    @Override
    public Integer update(ImageModel imageModel) {
        return imageDao.updateByPrimaryKey(imageModel);
    }

    @Override
    @Deprecated
    public Integer delete(ImageModel imageModel) {
        return deleteById(imageModel.getId());
    }

    @Override
    public ImageModel findById(Integer id) {
        return imageDao.selectByPrimaryKey(id);
    }

    @Override
    @Deprecated
    public Integer deleteById(Integer id) {
        return null;
    }

    @Override
    public Integer deleteById(Integer id, HttpServletRequest request) throws IOException {
        ImageModel img = findById(id);
        deleteFile(img, request);
        return imageDao.deleteByPrimaryKey(id);
    }

    @Override
    public ImageModel findByName(String name) {
        return null;
    }

    @Override
    public Integer[] uploadImage(MultipartFile[] files, HttpServletRequest request, String type) throws IOException {
        ImageModel img = new ImageModel();
        List<Integer> list = new ArrayList<>();
        for (MultipartFile file : files) {
            String fileName = (new Date().getTime()) + "_" + file.getOriginalFilename();
            String path = request.getSession().getServletContext().getRealPath(Config.IMG_FILE_PATH) + "/" + type.toLowerCase();
            uploadFile(file, path, fileName);
            img.setFlag(true);
            img.setName(fileName);
            img.setPath(Config.IMG_FILE_PATH + "/" + type.toLowerCase() + "/");
            img.setType(type);
            img.setContentType(file.getContentType());
            img.setUploadDate(new Date());
            list.add(addBean(img));
        }
        Integer[] ids = new Integer[list.size()];
        list.toArray(ids);
        return ids;
    }

    @Override
    public void uploadBanner(MultipartFile file, HttpServletRequest request) throws IOException {
        String fileName = "banner.jpg";
        String path = request.getSession().getServletContext().getRealPath(Config.IMG_FILE_PATH) + "\\banner";
        uploadFile(file, path, fileName);
    }

    private void uploadFile(MultipartFile file, String path, String fileName) throws IOException {
        File targetFile = new File(path, fileName);
        if (targetFile.exists()) {
            targetFile.delete();
        }
        targetFile.mkdirs();
        file.transferTo(targetFile);

    }

    private void deleteFile(ImageModel image, HttpServletRequest request) throws IOException {
        String path = request.getSession().getServletContext().getRealPath(image.getPath());
        File targetFile = new File(path, image.getName());
        if (targetFile.exists()) {
            targetFile.delete();
        }

    }

    public ImageModelMapper getImageDao() {
        return imageDao;
    }

    @Autowired
    public void setImageDao(ImageModelMapper imageDao) {
        this.imageDao = imageDao;
    }


}
