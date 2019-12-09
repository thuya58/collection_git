package com.dms.dao;

import java.util.List;

import com.dms.entity.User_login;
public interface User_loginDao {
	public List<User_login> viewAllUser_login();
	public User_login searchUser_login(User_login id);
	public void deleteUser_login(User_login user_login);
	public void saveOrUpdateUser_login(User_login user_login);
	public User_login findUserByEmail(String name);
	public User_login searchId(String email);
	public boolean checkEmail(String email);
	public String getNewPassword(String email);
}
