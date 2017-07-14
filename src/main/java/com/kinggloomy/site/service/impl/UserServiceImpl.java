package com.kinggloomy.site.service.impl;

import java.util.List;

import com.kinggloomy.site.dao.UserModelMapper;
import com.kinggloomy.site.model.UserModel;
import com.kinggloomy.site.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	private UserModelMapper userDAO;


	
	@Override
	public Integer addBean(UserModel t) {
		return userDAO.insert(t);
		
	}

	@Override
	public List<UserModel> findAll() {
		return userDAO.selectAll();
	}

	@Override
	public Integer update(UserModel t) {
		return userDAO.updateByPrimaryKey(t);
	}

	@Override
	public Integer delete(UserModel t) {
		return deleteById(t.getId());
	}
	

	@Override
	public UserModel findById(Integer id) {
		return userDAO.selectByPrimaryKey(id);
	}

	@Override
	public Integer deleteById(Integer id) {
		return userDAO.deleteByPrimaryKey(id);
	}

	@Override
	@Deprecated
	public UserModel findByName(String name) {
		return null;
	}
	@Override
	public UserModel findByUserCode(String code) {
		return userDAO.selectByUserCode(code);
	}
	@Override
	public UserModel login(UserModel user){
		if (user!=null&&user.getUserCode()!=null&&user.getPassword()!=null){
			return userDAO.login(user);

			}
	return null;
	}
    public UserModelMapper getUserDAO() {
        return userDAO;
    }

    @Autowired
    public void setUserDAO(UserModelMapper userDAO) {
        this.userDAO = userDAO;
    }

}
