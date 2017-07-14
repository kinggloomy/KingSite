package com.kinggloomy.site.service.impl;



import com.kinggloomy.site.dao.RoleModelMapper;
import com.kinggloomy.site.model.RoleModel;
import com.kinggloomy.site.model.UserModel;
import com.kinggloomy.site.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("rolesService")
@Transactional
public class RolesServiceImpl implements RolesService {
	
	private RoleModelMapper rolesDAO;
	


	@Override
	public Integer addBean(RoleModel t) {
		return rolesDAO.insert(t);

	}

	@Override
	public List<RoleModel> findAll() {
		return rolesDAO.selectAll();
	}

	@Override
	public Integer update(RoleModel t) {
		return rolesDAO.updateByPrimaryKey(t);
	}

	@Override
	public Integer delete(RoleModel t) {
		return deleteById(t.getId());
	}

	@Override
	public RoleModel findById(Integer id) {
		return rolesDAO.selectByPrimaryKey(id);
	}

	@Override
	public Integer deleteById(Integer id) {
		return rolesDAO.deleteByPrimaryKey(id);
	}

	@Override
	public RoleModel findByName(String name) {
		return rolesDAO.findByName(name);
	}
	@Override
	public List<RoleModel> finaByUser(UserModel user){
		
		return rolesDAO.findByUserCode(user.getUserCode());
	}

	public RoleModelMapper getRolesDAO() {
		return rolesDAO;
	}

	@Autowired
	public void setRolesDAO(RoleModelMapper rolesDAO) {
		this.rolesDAO = rolesDAO;
	}
}
