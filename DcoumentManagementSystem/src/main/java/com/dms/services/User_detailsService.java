package com.dms.services;

import com.dms.dto.Change_passwordDto;
import com.dms.dto.User_profile;
import com.dms.dto.User_registerDto;
import com.dms.entity.User_info;
import com.dms.entity.User_login;

public interface User_detailsService {
	public void saveUser(User_registerDto user_registerDto);
	public boolean checkPassword( User_login user_login );
	public User_info search_User_info(String email);
	public User_info search_profile(String email);
	public boolean change_password(Change_passwordDto change_password);
	public User_profile user_profile();
}
