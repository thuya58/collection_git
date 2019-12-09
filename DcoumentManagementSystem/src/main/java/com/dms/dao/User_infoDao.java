package com.dms.dao;

import java.util.List;

import com.dms.dto.User_registerDto;
import com.dms.entity.User_info;
public interface User_infoDao {
	public List<User_info> viewAllUser_info();
	public User_info searchUser_info(long id);
	public void deleteUser_info(User_info user_info);
	public void saveOrUpdateUser_info(User_info user_info);
	public List<User_info> searchId(String username);
	public User_info search_User(long id);
	public User_info findByUserName(String name);
	public void updateUser(User_registerDto user);
	public List<User_info> searchWithDepartment(long id);
}
