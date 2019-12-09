package com.dms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dms.dao.User_infoDao;
import com.dms.dto.User_registerDto;
import com.dms.entity.User_info;

@Service
@Transactional
public class User_infoServiceImp implements User_infoService {
	@Autowired
	private User_infoDao user_infoDao;
	@Override
	public List<User_info> viewAllUser_info() {
		
		return user_infoDao.viewAllUser_info();
	}
	@Override
	public void updateUser(User_registerDto user) {
		// TODO Auto-generated method stub
		user_infoDao.updateUser(user);
	}
	@Override
	public User_info searchUser_info(long id) {
		// TODO Auto-generated method stub
		return user_infoDao.searchUser_info(id);
	}
	
	
	

}
