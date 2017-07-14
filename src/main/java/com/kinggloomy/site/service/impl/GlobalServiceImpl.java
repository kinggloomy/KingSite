package com.kinggloomy.site.service.impl;

import com.kinggloomy.site.dao.GlobalModelMapper;
import com.kinggloomy.site.model.GlobalModel;
import com.kinggloomy.site.model.dto.GlobalDTO;
import com.kinggloomy.site.service.GlobalService;
import com.kinggloomy.site.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/27.
 */
@Service("globalService")
public class GlobalServiceImpl implements GlobalService {
    private GlobalModelMapper globalDAO;
    private ImageService imageService;

    @Override
    public String addBean(GlobalDTO globalDTO) {
        if(globalDTO!=null){
            GlobalModel model = dtoToModel(globalDTO);
            if(globalDTO.getImageId()==null&&globalDTO.getImage()!=null&&globalDTO.getImage().getName()!=null){
                model.setImageId(imageService.addBean(globalDTO.getImage()));
            }
             globalDAO.insert(model);
            return model.getGlobalKey();
        }else{
            throw new RuntimeException("GlobalDTO is NULL");
        }

    }

    @Override
    public List<GlobalDTO> findAll() {
        List<GlobalModel> list = globalDAO.selectAll();
        List<GlobalDTO> result = new ArrayList<>();
        if(list.size()>0){
            for (GlobalModel model: list) {
                result.add(modelToDto(model));
            }
        }
        return result;
    }

    @Override
    public String update(GlobalDTO globalDTO) {
        GlobalModel model = dtoToModel(globalDTO);
        globalDAO.updateByPrimaryKey(model);
        return model.getGlobalKey();
    }

    @Override
    public String delete(GlobalDTO globalDTO) {
        return deleteById(globalDTO.getGlobalKey());
    }

    @Override
    public GlobalDTO findById(String key) {
        GlobalDTO dto = globalDAO.selectDTOByPrimaryKey(key);

        return dto;
    }
    @Override
    public GlobalModel findModelById(String key) {
      return globalDAO.selectByPrimaryKey(key);

    }


    @Override
    public String deleteById(String key) {
        return globalDAO.deleteByPrimaryKey(key);
    }


    private GlobalModel dtoToModel(GlobalDTO dto){
        GlobalModel model = new GlobalModel();
        model.setContent(dto.getContent());
        model.setImageId(dto.getImageId());
        model.setGlobalKey(dto.getGlobalKey());
        model.setTitle(dto.getTitle());
        return  model;
    }
    private GlobalDTO modelToDto(GlobalModel model){
        GlobalDTO dto = new GlobalDTO();
        dto.setContent(model.getContent());
        dto.setImageId(model.getImageId());
        dto.setGlobalKey(model.getGlobalKey());
        dto.setTitle(model.getTitle());
        return  dto;
    }
    @Override
    public boolean dtoHasImage(GlobalDTO dto){
        return dto.getImageId()!=null;
    }

    @Override
    public String saveOrUpdate(GlobalDTO global) {
        if(findById(global.getGlobalKey())!=null){
            return update(global);
        }else {
            return addBean(global);
        }
    }


    public GlobalModelMapper getGlobalDAO() {
        return globalDAO;
    }

    @Autowired
    public void setGlobalDAO(GlobalModelMapper globalDAO) {
        this.globalDAO = globalDAO;
    }

    public ImageService getImageService() {
        return imageService;
    }

    @Autowired
    public void setImageService(ImageService imageService) {
        this.imageService = imageService;
    }
}
