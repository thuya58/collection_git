package com.dms.services;

import java.util.List;

import com.dms.dto.User_registerDto;
import com.dms.entity.User_info;

public interface  User_infoService {
	public List<User_info> viewAllUser_info();

	public void updateUser(User_registerDto user);
	public User_info searchUser_info(long id);

	

}
